package com.dtalliance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.dtalliance.R;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.SPUtil;

public class TeamDreamActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_teamdream);
		
		TextView taskbt = (TextView) findViewById(R.id.tv_teamdream_mytask);
		
		TextView firstDream = (TextView) findViewById(R.id.tv_teamdream_firstdream);
		TextView middleDream = (TextView) findViewById(R.id.tv_teamdream_middledream);
		TextView terminalDream = (TextView) findViewById(R.id.tv_teamdream_terminaldream);
		TextView teamName = (TextView) findViewById(R.id.tv_teamdream_name);
		TextView battleTeam = (TextView) findViewById(R.id.tv_teamdream_myteambattle);
		
		teamName.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_FIRST_LEVEL, ConstantUtil.TEAM_NAME));
		firstDream.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_FIRST_LEVEL, "title"));
		middleDream.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_MIDDLE_LEVEL, "title"));
		terminalDream.setText(SPUtil.getString(getApplicationContext(), ConstantUtil.TEAM_TERMINAL_LEVEL, "title"));
		
		taskbt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goTeamTask();
			}
		});
		
		battleTeam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				goDreamVersus();
			}
		});
	}
	
	public void goDreamVersus(){
		Intent intent = new Intent(this, DreamVersusActivity.class);
		startActivity(intent);
	}
	
	public void goTeamTask(){
		Intent intent = new Intent(this, TeamTaskActivity.class);
		intent.putExtra(ConstantUtil.DREAM_LEVEL, ConstantUtil.TEAM_DREAM);
		startActivity(intent);
	}

}
