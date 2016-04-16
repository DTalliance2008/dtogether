package com.dtalliance.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.dtalliance.R;
import com.dtalliance.adapter.DTab;
import com.dtalliance.adapter.MyPagerAdapter;
import com.dtalliance.fragment.IntroduceFragment;
import com.dtalliance.fragment.NoteFragment;
import com.dtalliance.fragment.PersistFragment;
import com.dtalliance.fragment.ShareFragment;

import java.util.ArrayList;
import java.util.List;


public class DTActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{
	
	private List<DTab> tabList = new ArrayList<DTab>();
	private List<TextView> textViewList = new ArrayList<>();
	private ViewPager viewPager;
	private int indexPager = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dt);
		
		initAction();
	}
	
	public void initAction(){

		initTextViewList();
		viewPager = (ViewPager) findViewById(R.id.vp_dt);
		tabList.add(new DTab(R.string.persist, PersistFragment.class));
		tabList.add(new DTab(R.string.note, NoteFragment.class));
		tabList.add(new DTab(R.string.sharedream, ShareFragment.class));
		tabList.add(new DTab(R.string.my, IntroduceFragment.class));

		viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), tabList));
		viewPager.setOnPageChangeListener(this);
	}

	private void initTextViewList(){
		TextView persist = (TextView) findViewById(R.id.tv_persist);
		TextView note = (TextView) findViewById(R.id.tv_note);
		TextView share = (TextView) findViewById(R.id.tv_share);
		TextView intro = (TextView) findViewById(R.id.tv_my);

		textViewList.add(persist);
		textViewList.add(note);
		textViewList.add(share);
		textViewList.add(intro);
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int i) {
		changeTextViewColor(i);
	}

	private void changeTextViewColor(int position){
		if(textViewList != null){
			for(int i=0;i<textViewList.size();i++){
				if(i==position){
					textViewList.get(i).setTextColor(Color.RED);
				}else{
					textViewList.get(i).setTextColor(getResources().getColor(R.color.blue));
				}
			}
		}
	}


	@Override 
	public boolean onCreateOptionsMenu(Menu menu) {  
	    MenuInflater inflater = getMenuInflater();  
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);  
	}  
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem){
		switch(menuItem.getItemId()){
		case R.id.writeNote:
//			goWriteNote();
			return true;
		case R.id.set_alert:
//			goRemind();
			return true;
		case R.id.it_search:
//			goFriendChoose();
		default:
			return false;
		}
	}
	
//	public void goFriendChoose(){
//		Intent intent = new Intent(this, FriendChooseActivity.class);
//		startActivity(intent);
//	}
//
//	public void goWriteNote(){
//		Intent intent = new Intent(this, WriteNoteActivity.class);
//		startActivity(intent);
//	}
//
//	public void goRemind(){
//		Intent intent = new Intent(this, RemindActivity.class);
//		startActivity(intent);
//	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
}
