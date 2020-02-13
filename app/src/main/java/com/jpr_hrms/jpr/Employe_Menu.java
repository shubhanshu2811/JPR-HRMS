package com.jpr_hrms.jpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jpr_hrms.R;

public class Employe_Menu extends AppCompatActivity {

    Button markattendance, appplyleaves, viewAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe__menu);

        markattendance = findViewById(R.id.btn_markattendance);
        appplyleaves = findViewById(R.id.btn_appplyleaves);
        viewAttendance =findViewById(R.id.BTN_ViewAttendance);


    }
}
