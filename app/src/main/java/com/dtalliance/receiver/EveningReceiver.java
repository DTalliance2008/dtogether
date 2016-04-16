package com.dtalliance.receiver;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.dtalliance.R;
//import com.dtalliance.activity.ViewPagerActivity;
import com.dtalliance.db.PersistWord;

/**
 * time:2014/10/27-17:00
 * Broadcaset notification
 *by zhf
 */
public class EveningReceiver extends BroadcastReceiver {
	
	private PersistWord dataManager;
	private Context context;
	private final static int NOTIFICATION_ID = 1003; 
	private String evening = "���Ϻ�";
	@Override
    public void onReceive(Context context, Intent intent) {
		this.context = context;
		showNotification();
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void showNotification(){
		Notification noCation = new Notification(R.mipmap.ic_launcher,
				"һ����", System.currentTimeMillis());
		
		String phrase = "һ����";

		SharedPreferences sp = context.getSharedPreferences("count", context.MODE_PRIVATE);
		dataManager = new PersistWord(context); 
		int count = sp.getInt("count", 0);
		if(count != 0){
			phrase = dataManager.selectPersistData(Integer.toString(count), Integer.toString(count)).get(0).getKeyWord();
		}
//		Intent yiqikaoIntent = new Intent(context, ViewPagerActivity.class);
//		PendingIntent penIntent = PendingIntent.getActivity(context, 0,yiqikaoIntent, 0);

//		noCation.setLatestEventInfo(context, evening, phrase, penIntent);
		NotificationManager noCationManager = (NotificationManager) context.getSystemService(
					android.content.Context.NOTIFICATION_SERVICE);
		noCationManager.notify(NOTIFICATION_ID, noCation);
	}
}
