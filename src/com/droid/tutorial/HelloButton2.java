package com.droid.tutorial;



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloButton2 extends Activity {
    /** Called when the activity is first created. */
	 TextView greeter;
	 NotificationManager mNotificationManager ;
	 private static final int HELLO_ID = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button sayHi = (Button) findViewById(R.id.SayHiButton);
        
        
         greeter = (TextView) findViewById(R.id.nameTextBox);
        String ns = Context.NOTIFICATION_SERVICE;
         mNotificationManager = (NotificationManager) getSystemService(ns);
       
       
       
       
        sayHi.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		Toast.makeText(v.getContext(), "HELLO WORLDSs!!!$$", Toast.LENGTH_LONG).show();
        		giveNotice();
        	}

        });
    }
    
   public void giveNotice(){
	   
	   int icon = R.drawable.icon;
		CharSequence tickerText = "Hello " + greeter.getText();
	
		long when = System.currentTimeMillis();

		Notification notification = new Notification(icon, tickerText, when);
	
		Context context = getApplicationContext();
		CharSequence contentTitle = "Foo";
		CharSequence contentText = "hello" + " " + String.valueOf(when);
		Intent notificationIntent = new Intent(this, DroidNotifier.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		mNotificationManager.notify(HELLO_ID, notification);
	   
//	   DroidNotifier notify = new DroidNotifier();
//	   notify.notifyMe("HELLO WORLDSs!!!$$ ");
   }
}