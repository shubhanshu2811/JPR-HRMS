package com.jpr_hrms.jpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jpr_hrms.R;
import com.jpr_hrms.db.DBHelper;
import com.jpr_hrms.modell.Employee;

public class AdminLoginActivity extends AppCompatActivity
{

    EditText pinEDT;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        pinEDT = findViewById(R.id.pinEdt);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pin = Integer.parseInt(pinEDT.getText().toString());
                if (pin > 0){

                    Employee employee = DBHelper.getInstance().getEmpByPin(pin);
                    if (employee != null){

                        Intent intent = new Intent(AdminLoginActivity.this, AdminMenu.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AdminLoginActivity.this, "Please enter correct pin", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(AdminLoginActivity.this, "Please enter your pin", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}



