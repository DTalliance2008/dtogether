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
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.UserApplication;

/**
 * time:2014/11/10-17:00
 * Broadcaset notification Morning 
 *by zhf
 */
public class MorningReceiver extends BroadcastReceiver {
	
	private PersistWord dataManager;
	private Context context;
	private final String morning =  "早上好";
	private final static int NOTIFICATION_ID = 1001;
	@Override
    public void onReceive(Context context, Intent intent) {
		this.context = context;
		showNotification();
	}
	
	public void showNotification(){
		String phrase = "天气不错";
		SharedPreferences sp = context.getSharedPreferences("dream", context.MODE_PRIVATE);
		dataManager = new PersistWord(context);
		int count = sp.getInt("count", 0);
		if(count != 0){
			phrase = dataManager.selectPersistData(Integer.toString(count), Integer.toString(count)).get(0).getKeyWord();
		}
		Notification.Builder builder = new Notification.Builder(new UserApplication());
		builder.setContentTitle(morning)
				.setContentText(phrase)
				.setSmallIcon(R.mipmap.ic_launcher);

		Notification notification = builder.build();
//		Intent yiqimengIntent = new Intent(context, ViewPagerActivity.class);
//		PendingIntent penIntent = PendingIntent.getActivity(context, 0,
//				yiqimengIntent, 0);
//		notification.contentIntent = penIntent;
		NotificationManager noCationManager = (NotificationManager) context.getSystemService(
					android.content.Context.NOTIFICATION_SERVICE);
		noCationManager.notify(NOTIFICATION_ID, notification);
	}
}
