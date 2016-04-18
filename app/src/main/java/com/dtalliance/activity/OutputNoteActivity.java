package com.dtalliance.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.dtalliance.R;
import com.dtalliance.file.StoreFileToSD;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.TimeUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class OutputNoteActivity extends Activity{

	private TextView contentNote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notedisplay);
		init();
	}

	private void init() {
		TextView titleNote = (TextView) findViewById(R.id.tv_notedisplay_tittle);
		TextView timeNote = (TextView) findViewById(R.id.tv_notedisplay_time);
		contentNote = (TextView) findViewById(R.id.tv_notedisplay_note);

		String fileName = getIntent().getExtras().getString("filename");
		String[] array = TimeUtil.getFileName(fileName);
		titleNote.setText(array[0]);
		if(array.length > 1){
			timeNote.setText(array[1]);
		}
		new ReadSdcardFile(getApplication()).execute(fileName);
	}



	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
			goDT();
		}
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.outputnote, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) { 
		case R.id.optnoteitem:
			goDT();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Deprecated
	public String ReadFile(String path){
		String content = null;
		try{
			FileInputStream inStream = this.openFileInput(path);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = inStream.read(buffer)) != -1){
				byteStream.write(buffer, 0, len);
			}
			content = byteStream.toString();
			byteStream.close();
			inStream.close();
		} catch(Exception e ){
			e.printStackTrace();
		} 
		return content;
	}
	
	public void goDT(){
		Intent intent = new Intent(this, DTActivity.class);
		startActivity(intent);
		finish();
	}

	private class ReadSdcardFile extends  AsyncTaskWithProgressDialog{

		public ReadSdcardFile(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
		protected void onPostExecute2(String result) {
			if(result != null){
				contentNote.setText(result);
			}
		}

		@Override
		protected String doInBackground2(String... params) {
			StoreFileToSD storeFileToSD = new StoreFileToSD();
			return storeFileToSD.readSD(ConstantUtil.SD_PATH + params[0]);
		}
	}

}
