package com.qstairs.ryo.alarmsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmUtil alarmUtil = new AlarmUtil();
        alarmUtil.setLocalAlarm(this, "アラーム通知", 0, 10);
    }


}
