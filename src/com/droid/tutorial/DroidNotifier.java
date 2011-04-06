package com.droid.tutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class DroidNotifier extends Activity{
	private static final int HELLO_ID = 1;
	 public void notifyMe(String aNotice){
		 TextView greeter = (TextView) findViewById(R.id.nameTextBox);
    	 String ns = Context.NOTIFICATION_SERVICE;
         NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
         
         int icon = R.drawable.icon;
 		CharSequence tickerText = "Hello " + greeter.getText();
 	
 		long when = System.currentTimeMillis();

 		Notification notification = new Notification(icon, tickerText, when);
 	
 		Context context = getApplicationContext();
 		CharSequence contentTitle = "Foo";
 		CharSequence contentText = aNotice + " " + String.valueOf(when);
 		Intent notificationIntent = new Intent(this, DroidNotifier.class);
 		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

 		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
 		
 		mNotificationManager.notify(HELLO_ID, notification);
    	
    }
}
