package com.example.school.teatcher;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class add_teacher extends AppCompatActivity {
 FloatingActionButton fbtn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_add_teacher );
        fbtn_save = findViewById ( R.id.teacher_btn_add );

    }
}