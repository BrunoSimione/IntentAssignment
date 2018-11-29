package com.example.bruno.intentassignment;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button btnSetAlarm;
    TextView tvName;
    CheckBox day1, day2, day3, day4, day5, day6, day7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        timePicker = findViewById(R.id.tp_clock);
        btnSetAlarm = findViewById(R.id.btn_setAlarm);
        tvName = findViewById(R.id.tv_alarm_name);
        day1 = findViewById(R.id.cb_week_1);
        day2 = findViewById(R.id.cb_week_2);
        day3 = findViewById(R.id.cb_week_3);
        day4 = findViewById(R.id.cb_week_4);
        day5 = findViewById(R.id.cb_week_5);
        day6 = findViewById(R.id.cb_week_6);
        day7 = findViewById(R.id.cb_week_7);

    }

    public void setAlarmClicked(View view) {
        String message = tvName.getText().toString();
        int hour = timePicker.getHour();
        int minutes = timePicker.getMinute();

        ArrayList<Integer> weekdays = new ArrayList<>();
        if(day1.isChecked()) weekdays.add(Calendar.SUNDAY);
        if(day2.isChecked()) weekdays.add(Calendar.MONDAY);
        if(day3.isChecked()) weekdays.add(Calendar.TUESDAY);
        if(day4.isChecked()) weekdays.add(Calendar.WEDNESDAY);
        if(day5.isChecked()) weekdays.add(Calendar.THURSDAY);
        if(day6.isChecked()) weekdays.add(Calendar.FRIDAY);
        if(day7.isChecked()) weekdays.add(Calendar.SATURDAY);

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_DAYS, weekdays);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
