package com.jpr_hrms.jpr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.jpr_hrms.R;
import com.jpr_hrms.db.DBHelper;
import com.jpr_hrms.modell.Employee;

import io.realm.Realm;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Realm.init(this);

        Employee employe = new Employee();
        employe.setEmpId("129");
        employe.setEmail("shubhanshu@gmail.com");
        employe.setName("shubu");
        employe.setMobile("9958654484");
        employe.setPin(1111);


        final int isSaved = DBHelper.getInstance().createEmploye(employe);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isSaved > 0) {
                    Intent intent = new Intent(SplashActivity.this, Login_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2 * 1000);


    }
}

