package com.example.ganesh.notificationbasic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notif=(Button)findViewById(R.id.btn_notif);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
               Notification notification = new Notification.Builder(MainActivity.this)
                       .setTicker("TickerTitle")
                       .setContentTitle("Content Title")
                       .setContentText(" Content Text")
                       .setSmallIcon(R.drawable.ic_android_black)
                       .addAction(R.drawable.ic_assignment_ind_black,"Action 1",pIntent)
                       .addAction(R.drawable.ic_account_circle_black,"Action 2",pIntent)
                       .setContentIntent(pIntent).getNotification();

                notification.flags=Notification.FLAG_AUTO_CANCEL;
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0,notification);

            }
        });
    }
}
