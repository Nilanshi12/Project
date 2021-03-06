package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    Spinner empTypes, color;
    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    TextView t1, t2;
    RadioButton rb1, rb2;
    RadioGroup r1, r2;
    int Age = 0;
    double annualIncome = 0.0;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    EmployeeDBHandler mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        empTypes = (Spinner) findViewById(R.id.emp_Type);
        t1 = (TextView) findViewById(R.id.textView8);
        t2 = (TextView) findViewById(R.id.textView10);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.editText6);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText3);
        e6 = (EditText) findViewById(R.id.editText);
        e7 = (EditText) findViewById(R.id.editText7);
        e9 = (EditText) findViewById(R.id.e9);
        e10 = (EditText) findViewById(R.id.editText2);
        r1 = (RadioGroup) findViewById(R.id.radioGroup1);
        r2 = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton3);
        rb2 = (RadioButton) findViewById(R.id.radioButton4);
        color = (Spinner) findViewById(R.id.color);


        mDatabase = new EmployeeDBHandler(this);
        List<String> emp = new ArrayList<>();

        emp.add("Choose:");
        emp.add("Manager");
        emp.add("Tester");
        emp.add("Programmer");
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, emp);
        empTypes.setAdapter(adapter);
        empTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(empTypes.getSelectedItem().toString().equals("Choose:")){
                    t1.setVisibility(view.GONE);
                }
                else if (empTypes.getSelectedItem().toString().equals("Manager")) {
                    t1.setText("#clients");
                    t1.setVisibility(View.VISIBLE);
                    e1.setVisibility(View.VISIBLE);

                }
                else if (empTypes.getSelectedItem().toString().equals("Tester")) {
                    t1.setText("#bugs");
                    t1.setVisibility(View.VISIBLE);
                    e1.setVisibility(View.VISIBLE);
                }
               else if (empTypes.getSelectedItem().toString().equals("Programmer")) {
                    t1.setText("#projects");
                    t1.setVisibility(View.VISIBLE);
                    e1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> colors = new ArrayList<>();
        colors.add("Choose Color:");
        colors.add("Red");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Orange");
        colors.add("Purple");
        colors.add("Pink");
        colors.add("Brown");
        colors.add("White");
        colors.add("Black");
        colors.add("Beige");

        //creating adapter for spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        color.setAdapter(adapter1);
    }

    public void register(View view) {
        if (TextUtils.isEmpty(e4.getText().toString())) {
            e4.setError("First name is required!");
            return;
        }
        if (TextUtils.isEmpty(e3.getText().toString())) {
            e3.setError("Last name is required!");
            return;
        }
        if (TextUtils.isEmpty(e5.getText().toString())) {
            e5.setError("Birth Date is required!");
            return;
        } else if ((Integer.parseInt(e5.getText().toString())) < 1950) {
            e5.setError("Birth Year not valid!");
            return;
        }else {
            //converting birth year to age
            int currentYear = Integer.parseInt(e5.getText().toString());
            Age = year - currentYear;
        }


//calculating annual income from monthly salary

        if (TextUtils.isEmpty(e6.getText().toString())) {
            e6.setError("Employee Salary is required!");
            return;
        }
        else {
            double monthlySalary = Double.parseDouble(e6.getText().toString());
            annualIncome = monthlySalary * 12;
        }
        if (TextUtils.isEmpty(e7.getText().toString())) {
            e7.setError("Occupation Rate is required!");
            return;
        }
        /* else if ((Integer.parseInt(e7.getText().toString())) < 10) {
            e7.setError("Occupation rate must be greater than 10");
            return;
        }else if ((Integer.parseInt(e7.getText().toString())) >100) {
            e7.setError("Occupation rate must be less than 100");
            return;
        }
        */


        if (empTypes.getSelectedItem() == null || color.getSelectedItem() == null
                || r1.getCheckedRadioButtonId() == -1 || r2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "All Fields Required.",
                    Toast.LENGTH_SHORT).show();
        }


        if (TextUtils.isEmpty(e1.getText().toString())) {
            e1.setError("Numbers are required!");
            return;
        }
        if (TextUtils.isEmpty(e9.getText().toString())) {
            e9.setError("Vehicle Model is required!");
            return;
        }
        if (TextUtils.isEmpty(e10.getText().toString())) {
            e10.setError("Plate Number is required!");
            return;
        }

        //creating condition to add a new employee
        String firstName = e4.getText().toString();
        String lastName = e3.getText().toString();
        int age = Age;
        double salary = annualIncome;
        int occRate = Integer.parseInt(e7.getText().toString());

        if(occRate>100)
        {
            occRate=100;
        }
        else if(occRate<10)
        {
            occRate=10;
        }

        String employeeType = empTypes.getSelectedItem().toString();
        int cpb = Integer.parseInt(e1.getText().toString());
        String vehicle = "";

        switch (r2.getCheckedRadioButtonId()) {
            case R.id.radioButton3:
                vehicle = "car";
                break;
            case R.id.radioButton4:
                vehicle = "motorcycle";
                break;
            default:
                break;
        }
        String model = e9.getText().toString();
        String plate = e10.getText().toString();
        String Color = color.getSelectedItem().toString();
        String sidecar = "";
        switch (r1.getCheckedRadioButtonId()) {
            case R.id.radioButton5:
                sidecar = "Yes";
                break;
            case R.id.radioButton6:
                sidecar = "No";
                break;
            default:
                break;
        }


        if (mDatabase.addEmployee(firstName, lastName, age, salary, occRate, employeeType, cpb,
                vehicle, model, plate, Color, sidecar)) {
            Toast.makeText(this, "Employee added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else
            Toast.makeText(this, "Employee not added", Toast.LENGTH_SHORT).show();


    }

    public void onCheckedRB3(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton3:
                if (checked) {
                    t2.setText("Car Type:");
                    r1.setVisibility(View.GONE);
                    t2.setVisibility(View.VISIBLE);
                    e2.setVisibility(View.VISIBLE);
                }
        }

    }

    public void onCheckedRB4(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton4:
                if (checked) {
                    t2.setText("Side car:");
                    t2.setVisibility(View.VISIBLE);
                    r1.setVisibility(View.VISIBLE);
                    e2.setVisibility(View.GONE);
                }
        }
    }
}
