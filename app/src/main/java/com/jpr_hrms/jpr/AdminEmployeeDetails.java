package com.jpr_hrms.jpr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jpr_hrms.Constans;
import com.jpr_hrms.R;
import com.jpr_hrms.db.DBHelper;
import com.jpr_hrms.modell.Employee;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.jpr_hrms.Constans.EmpID;
import static com.jpr_hrms.db.DBHelper.getInstance;

public class AdminEmployeeDetails extends AppCompatActivity {

    TextView tvname, tvemail;
    Button btnedit, btndelet;
    CardView empCard;
    private String empId;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__employee__details);

        tvname = findViewById(R.id.tv_name);
        tvemail = findViewById(R.id.tv_email);
        btnedit = findViewById(R.id.btn_edit);
        btndelet = findViewById(R.id.btn_delet);
        empCard = findViewById(R.id.empCardCV);

        final Intent intent = getIntent();
        empId = intent.getStringExtra(EmpID);
        final Employee employee = DBHelper.getInstance().getEmploye(empId);

        if (employee != null) {


            tvname.setText("" + employee.getName());
            tvemail.setText("" + employee.getName());

        }

        btndelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (employee != null) {

                    AskOption();
                }
            }
        });


        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AdminEmployeeDetails.this, AddEmploye.class);
                intent1.putExtra(EmpID, empId);
                startActivity(intent1);

            }
        });

    }






/*        Intent bundle = getIntent();

        employee = bundle.getStringExtra("EmpID");
        realm = Realm.getDefaultInstance();

        RealmResults<Employee>employees = realm.where(Employee.class).equalTo("EmpID",employee).findAll();
        if (employees!=null && employees.size()>0){

            Employee employee1  = employees.first();
            tvname.setText(employee1.getName());
            tvemail.setText(employee1.getEmail());
        }
*/


      /*  Intent intent = getIntent();
      final int empId = intent.getIntExtra(Constans.EmpID, 0);

        employee = getInstance().getEmploye(empId);*/

       /* final Intent intent = getIntent();
        empId = intent.getStringExtra(EmpID);


        final Employee employee = DBHelper.getInstance().getEmploye(empId);
        if (employee != null) {
            tvname.setText("" + employee.getName());
            tvemail.setText("" + employee.getEmail());
        }*/

       /*btndelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (employee != null) {
                    AskOption();

                }

            }
        });


    }*/
   private void AskOption()

    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)

                .setTitle("Delete")
                .setMessage("Do you want to Delete")

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        int isdeleted = DBHelper.getInstance().deleteEmploye(employee);

                        if (isdeleted>0) {

                            finish();
                        }
                    }
                })

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .create();

         myQuittingDialogBox.show();
    }
}



