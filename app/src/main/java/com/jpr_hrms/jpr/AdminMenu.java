package com.jpr_hrms.jpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jpr_hrms.R;
import com.jpr_hrms.db.DBHelper;
import com.jpr_hrms.modell.Employee;

import java.util.ArrayList;
import java.util.List;

public class AdminMenu extends AppCompatActivity {

    Button buttonAdd;
    Button manageEmploye;


    List<Employee> employeList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

            buttonAdd = findViewById(R.id.addnew);
            manageEmploye = findViewById(R.id.btnManageEmploye);


            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(AdminMenu.this, AddEmploye.class);
                    startActivity(intent);
                }
            });


            manageEmploye.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    employeList = DBHelper.getInstance().getAllEmploye();

                    Intent intent = new Intent(AdminMenu.this,AdminEmployeeDetails.class);
                    startActivity(intent);
                    Toast.makeText(AdminMenu.this,"All Emp  "+employeList.size(),Toast.LENGTH_LONG).show();

                }
            });

        }

    }

