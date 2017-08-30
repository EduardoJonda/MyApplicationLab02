package com.a4.c15.segunda.eduardo.jonda.myapplicationlab2;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView displayTime;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        displayTime = (TextView) findViewById(R.id.textView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                displayTime.setText("Time: " + hourOfDay + ":" + minute);
            }
        });

        // Optional: Set current time (Android time)
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        // This method was deprecated in API level 23. Use setHour() and setMinute()
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minute);
    }

    public void pick(View view){
        // This method was deprecated in API level 23. Use getHour() and getMinute()
        displayTime.setText("Picked: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());
    }
}
