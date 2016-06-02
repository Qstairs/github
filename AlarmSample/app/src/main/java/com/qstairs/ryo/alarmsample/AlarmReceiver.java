package com.qstairs.ryo.alarmsample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Qstairs on 2016/05/29.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        String message = intent.getStringExtra("MESSAGE");
        sendNotification(context, message);
    }

    private void sendNotification(Context context, String message) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClass(context, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        Notification notification = new Notification.Builder(context)
                .setContentTitle(message)
                .setContentText("text")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .build();

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1000, notification);
    }
}
