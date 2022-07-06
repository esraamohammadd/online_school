package com.example.schoolapp.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolapp.Preference;
import com.example.schoolapp.R;
import com.example.schoolapp.student.student_Home;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_login extends AppCompatActivity {

//    Button login ;
    EditText et_userName , et_password;
    Button btn_login ;
    Switch sw_active;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_admin_login );
//        login = findViewById ( R.id.admi_Login_btn_login );
//        login.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View view) {
//                startActivity( new Intent (Admin_login.this,main_Admin.class) );
//
//            }
//        } );
//
//        et_userName = findViewById ( R.id.login_et_userName );
//        et_password = findViewById ( R.id.login_et_password );
//        btn_login=findViewById ( R.id.login_btn_login );
//        sw_active=findViewById ( R.id.login_sw_active );
//
//
//        btn_login.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View view) {
//                DatabaseReference reference= FirebaseDatabase.getInstance ().getReference ();
//                reference.child ( "login" ).addValueEventListener ( new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        String userName=et_userName.getText ().toString ();
//                        String password=et_password.getText ().toString ();
//                        if(snapshot.child ( userName ).exists ()){
//                            if (snapshot.child ( userName ).child("useres")
//                                    .equals(userName)) {
//                                if (sw_active.isChecked ()){
//                                    if (snapshot.child ( "as" ).equals ( "admin" )){
//
//                                        Preference.setDataLogin ( Admin_login.this,true );
//                                        Preference.setDataAs ( Admin_login.this,"Admin" );
//                                        Intent intent = new Intent(Admin_login.this,main_Admin.class);
//                                        startActivity(intent);
//
//                                    }else if(snapshot.child(password).child("as").equals("user")) {
//                                       Preference.setDataLogin ( Admin_login.this,true );
//                                        Preference.setDataAs ( Admin_login.this,"User" );
//                                        Intent intent = new Intent(Admin_login.this, student_Home.class);
//                                        startActivity(intent);
//
//
//
//                                    }
//                                }else {
//                                    if (snapshot.child ( "as" ).equals ( "admin" )){
//
//                                        Preference.setDataLogin ( Admin_login.this,false );
//                                        Intent in = new Intent(Admin_login.this,main_Admin.class);
//                                        startActivity(in);
//
//                                    }else if(snapshot.child(userName).child("as").equals("admin")){
//                                        Preference.setDataLogin ( Admin_login.this,false );
//                                        Intent intent = new Intent(Admin_login.this,student_Home.class);
//                                        startActivity(intent);
//
//
//                                    }
//
//                                }
//
//
//                            }else {
//
//                                Toast.makeText ( Admin_login.this , "password is not correct" , Toast.LENGTH_SHORT ).show ();
//                            }
//                        }else {
//
//                            Toast.makeText ( Admin_login.this , "not founded  inter correct user name" , Toast.LENGTH_SHORT ).show ();
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                } );
//            }
//        } );
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (Preference.getDataLogin(this)) {
//            if (Preference.getDataAs(this).equals("admin")) {
//                startActivity(new Intent(Admin_login.this, main_Admin.class));
//                finish();
//            } else if (Preference.getDataAs(this).equals("")) {
//                startActivity(new Intent(Admin_login.this, student_Home.class));
//                finish();
//
//            }
//        }
        et_userName = findViewById ( R.id.login_et_userName );
        et_password = findViewById ( R.id.login_et_password );
        btn_login=findViewById ( R.id.login_btn_login );
        sw_active=findViewById ( R.id.login_sw_active );


        btn_login.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
               reference= FirebaseDatabase.getInstance().getReference();
                reference.child("login").addValueEventListener ( new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String input1=et_userName.getText ().toString ();
                        String input2=et_password.getText ().toString ();
                        if(snapshot.child ( input1 ).exists ()){
                            if (snapshot.child (input1).child ( "password" ).getValue (String.class).equals ( input2 )) {
                                if (sw_active.isChecked ()){
                                    if (snapshot.child (input1).child ( "as" ).getValue (String.class).equals ( "admin" )){

                                        Preference.setDataLogin ( Admin_login.this,true );
                                        Preference.setDataAs ( Admin_login.this,"admin" );
                                        startActivity (  new Intent (Admin_login.this,main_Admin.class));

                                    }else if (snapshot.child (input1).child ( "as" ).getValue (String.class).equals ( "user" )){
                                        Preference.setDataLogin ( Admin_login.this,true );
                                        Preference.setDataAs ( Admin_login.this,"user" );
                                        startActivity (  new Intent (Admin_login.this,student_Home.class));

                                    }
                                }else {
                                    if (snapshot.child (input1).child ( "as" ).getValue (String.class).equals ( "admin" )){

                                        Preference.setDataLogin ( Admin_login.this,false );
                                        startActivity (  new Intent (Admin_login.this,main_Admin.class));

                                    }else if (snapshot.child (input1).child ( "as" ).getValue (String.class).equals ( "user" )){
                                        Preference.setDataLogin ( Admin_login.this,false );
                                        startActivity (  new Intent (Admin_login.this,student_Home.class));

                                    }

                                }


                            }else {

                                Toast.makeText ( Admin_login.this , "password is not correct" , Toast.LENGTH_SHORT ).show ();
                            }
                        }else {

                            Toast.makeText ( Admin_login.this , "not founded please !  inter correct user name" , Toast.LENGTH_SHORT ).show ();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                } );
            }
        } );
    }

    @Override
    protected void onStart() {
        super.onStart ();
        if(Preference.getDataLogin ( this )){
            if (Preference.getDataAs ( this ).equals ( "Admin" )) {

                startActivity (new Intent(Admin_login.this,main_Admin.class) );
                finish ();
            }else if (Preference.getDataAs ( this ).equals ( "User" )){
                startActivity (new Intent(Admin_login.this,student_Home.class) );
                finish ();
            }

        }
    }
    }