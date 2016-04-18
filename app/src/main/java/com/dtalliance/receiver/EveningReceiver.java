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
	private String evening = "晚上好";
	@Override
    public void onReceive(Context context, Intent intent) {
		this.context = context;
		showNotification();
	}
	
	public void showNotification(){
		SharedPreferences sp = context.getSharedPreferences("count", context.MODE_PRIVATE);
		dataManager = new PersistWord(context);
		int count = sp.getInt("count", 0);
		String phrase = "天气不错";
		if(count != 0){
			phrase = dataManager.selectPersistData(Integer.toString(count), Integer.toString(count)).get(0).getKeyWord();
		}

		Notification.Builder builder = new Notification.Builder(context);
		builder.setContentTitle(evening)
			.setContentText(phrase);
//			.setSmallIcon();
		Notification notification = builder.build();
//		Intent yiqikaoIntent = new Intent(context, ViewPagerActivity.class);
//		PendingIntent penIntent = PendingIntent.getActivity(context, 0,yiqikaoIntent, 0);
//		notification.contentIntent = penIntent;
		NotificationManager noCationManager = (NotificationManager) context.getSystemService(
					android.content.Context.NOTIFICATION_SERVICE);
		noCationManager.notify(NOTIFICATION_ID, notification);
	}
}
