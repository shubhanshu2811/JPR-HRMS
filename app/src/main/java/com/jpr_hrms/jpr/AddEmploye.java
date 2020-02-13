package com.jpr_hrms.jpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.jpr_hrms.R;
import com.jpr_hrms.db.DBHelper;
import com.jpr_hrms.modell.Employee;


public class AddEmploye extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText emailEdt;
    Spinner spinnerDesig;
    private Button btn_submit;
    String designation;
    String[] designationArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employe);


        designationArray = getResources().getStringArray(R.array.designation);


        emailEdt = findViewById(R.id.et_entremail);
        radioGroup = findViewById(R.id.rg_gender);
        spinnerDesig = findViewById(R.id.spinnerDesignation);
        btn_submit = findViewById(R.id.btn_submit);


        spinnerDesig.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                designation = designationArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int btnId = radioGroup.getCheckedRadioButtonId();
                RadioButton rbBtn = findViewById(btnId);
                String gender = rbBtn.getText().toString();
                String email = emailEdt.getText().toString().trim();

                boolean isValid = checkAllInput(designation, gender, email);


                if (isValid) {

                    Employee employe = new Employee();
                    employe.setEmpId(String.valueOf(125+System.currentTimeMillis()));
                    employe.setEmail(email);
                    employe.setName("Kamal");
                    employe.setGender(gender);
                    employe.setDesgination(designation);
                    employe.setMobile("83846366344");
                    employe.setPassword("1234");

                    int isSaved = DBHelper.getInstance().createEmploye(employe);

                    if (isSaved > 0) {
                        Toast.makeText(AddEmploye.this, "Employee added successfully ", Toast.LENGTH_LONG).show();
                        finish();
                    }


                }


            }
        });
    }

    private boolean checkAllInput(String designation, String gender, String email) {



        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(AddEmploye.this, "Please select gender", Toast.LENGTH_LONG).show();
            return false;
        }


        if (TextUtils.isEmpty(email) || !isValidEmail(email)) {
            Toast.makeText(AddEmploye.this, "Please enter valid  Email", Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(designation) || designation.equalsIgnoreCase("Select Designation")) {
            Toast.makeText(AddEmploye.this, "Please select designation", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;

    }


    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}


