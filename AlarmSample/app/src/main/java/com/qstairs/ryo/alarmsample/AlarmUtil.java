package com.qstairs.ryo.alarmsample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by Qstairs on 2016/05/29.
 */
public class AlarmUtil {
    public static void setLocalAlarm(Context context, String message, int requestCode, int interval){
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("MESSAGE", message);
        PendingIntent sender = PendingIntent.getBroadcast(context,  requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, interval);

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    public static void cancelLocalAlarm(Context context, int requestCode){
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}
