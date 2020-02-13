package com.jpr_hrms.jpr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jpr_hrms.R;

public class Login_Activity  extends AppCompatActivity {


    Button btn_login, tv_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, Employe_Menu.class);
                startActivity(intent);
                finish();
            }
        });

        tv_admin = (Button) findViewById(R.id.tv_admin);
        tv_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Login_Activity.this, AdminLoginActivity.class);
                startActivity(a);
                finish();
            }
        });
    }
}



