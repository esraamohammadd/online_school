package com.example.school.student;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.school.R;
import com.example.school.pojo.StudentData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class add_student extends AppCompatActivity {
    EditText et_fullName,et_student_ssn,et_id,et_std_phone,et_parent_phone
            ,et_address,et_password,et_username;
    Spinner spinner_year;
    FloatingActionButton btn_save;
    DatabaseReference reference;
    //****List
    List<StudentData> pre_1;
    List<StudentData> pre_2;
    List<StudentData> pre_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_add_student ); btn_save = findViewById ( R.id.addstudent_btn_save );
        et_fullName=findViewById ( R.id.addstudent_et_fullName );
        et_address=findViewById ( R.id.addstudent_et_address );
        et_student_ssn=findViewById ( R.id.addstudent_et_ssn );
        et_id=findViewById ( R.id.addstudent_et_id );
        et_address=findViewById ( R.id.addstudent_et_address );
        et_std_phone = findViewById ( R.id.addstudent_et_phone );
        et_parent_phone = findViewById ( R.id.addstudent_et_par_phone );
        spinner_year= findViewById ( R.id.addstudent_spiner );
        et_password = findViewById ( R.id.addstudent_et_password );
        et_username = findViewById ( R.id.addstudent_et_username );

        pre_1 = new ArrayList<>();
        pre_2 = new ArrayList<>();
        pre_3 = new ArrayList<>();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {String fullname = et_fullName.getText ().toString ();
                String ssn = et_student_ssn.getText ().toString ();
                String std_id = et_id.getText ().toString ();
                String password = et_password.getText ().toString ();
                String userName = et_username.getText ().toString ();
                String sp= spinner_year.getSelectedItem().toString();


                if(!TextUtils.isEmpty ( fullname )&&!TextUtils.isEmpty ( ssn )&&!TextUtils.isEmpty ( std_id )&&
                        !TextUtils.isEmpty ( password )&&!TextUtils.isEmpty ( userName ))
                {
                    addStudents();// to add new student at one of classes
                    et_fullName.setText ( "" );
                    et_id.setText ( "" );
                    et_student_ssn.setText ( "" );
                    et_parent_phone.setText ( "" );
                    et_std_phone.setText ( "" );
                    et_address.setText ( "" );
                    et_password.setText ( "" );
                    et_username.setText ( "" );

                }else{
                    et_fullName.setError ( "required" );
                    et_id.setError ( "required" );
                    et_student_ssn.setError ( "required" );
                    et_password.setError ( "required" );
                    et_username.setError ( "required" );

                }



            }
        });

    }    public  void addStudents()
    {
        String fullname = et_fullName.getText ().toString ();
        String std_phone = et_std_phone.getText ().toString ();
        String year = spinner_year.getSelectedItem ().toString ();
        String ssn = et_student_ssn.getText ().toString ();
        String parent_phone = et_parent_phone.getText ().toString ();
        String std_id = et_id.getText ().toString ();
        String address = et_address.getText ().toString ();
        String password = et_password.getText ().toString ();
        String userName = et_username.getText ().toString ();
        if(spinner_year.getSelectedItem().toString().equals("pre_1")) {
            StudentData studentData = new StudentData(fullname, std_phone, year, ssn,
                    parent_phone, std_id, address, password, userName);
            pre_1.add(studentData);

            reference = FirebaseDatabase.getInstance().getReference().child("school_Data")
                    .child("pre_1");
            reference.setValue(pre_1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {

                        Toast.makeText(getBaseContext(), "successfull", Toast.LENGTH_SHORT).show();

                    }

                }
            });


        } else if(spinner_year.getSelectedItem().toString().equals("pre_2")) {
            StudentData studentData = new StudentData(fullname, std_phone, year, ssn,
                    parent_phone, std_id, address, password, userName);
            pre_2.add(studentData);
            reference = FirebaseDatabase.getInstance().getReference().child("school_Data")
                    .child("pre_2");
            reference.setValue(pre_2).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {

                        Toast.makeText(getBaseContext(), "successfull", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }
        else if(spinner_year.getSelectedItem().toString().equals("pre_3")) {
            StudentData studentData = new StudentData(fullname, std_phone, year, ssn,
                    parent_phone, std_id, address, password, userName);
            pre_3.add(studentData);
            reference = FirebaseDatabase.getInstance().getReference().child("school_Data")
                    .child("pre_3");
            reference.setValue(pre_3).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {

                        Toast.makeText(getBaseContext(), "successfull", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }

        else
        {  Toast.makeText(this, "this class not found", Toast.LENGTH_SHORT).show();
        }}

}