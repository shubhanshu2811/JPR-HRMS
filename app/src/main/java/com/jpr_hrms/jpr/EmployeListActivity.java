package com.jpr_hrms.jpr;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jpr_hrms.Adapter.AdapterList;
import com.jpr_hrms.Constans;
import com.jpr_hrms.R;
import com.jpr_hrms.db.DBHelper;
import com.jpr_hrms.modell.Employee;

import java.util.List;

public class EmployeListActivity extends AppCompatActivity implements AdapterList.OnClickEmp {

    private List<Employee> employeList;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);

        recyclerView = findViewById(R.id.empListRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // AdapterList adapterList = new AdapterList(employeList, this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        employeList = DBHelper.getInstance().getAllEmploye();

        AdapterList adapterList = new AdapterList(employeList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClickOFEmp(int position) {
        Employee employe = employeList.get(position);

       String empId =employe.getEmpId();
        Intent intent =new Intent(EmployeListActivity.this, AdminEmployeeDetails.class);
        intent.putExtra(Constans.EmpID, empId);
        startActivity(intent);

    }
}

