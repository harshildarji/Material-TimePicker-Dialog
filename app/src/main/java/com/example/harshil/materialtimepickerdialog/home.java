package com.example.harshil.materialtimepickerdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Date;

public class home extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private EditText time;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        timePickerDialog = TimePickerDialog.newInstance(home.this, new Date().getHours(), new Date().getMinutes(), false);
        timePickerDialog.enableMinutes(false);

        time = (EditText) findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show(getFragmentManager(), "TimePickerDialog");
            }
        });
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String form;
        if (hourOfDay > 12) {
            hourOfDay = hourOfDay - 12;
            form = "PM";
        } else {
            if (hourOfDay == 0) {
                hourOfDay = 12;
            }
            form = "AM";
        }
        time.setText(String.valueOf(hourOfDay) + " " + form);
    }
}
