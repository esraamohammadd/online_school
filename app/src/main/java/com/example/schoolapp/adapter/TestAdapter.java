package com.example.schoolapp.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.example.schoolapp.pojo.StudentData;
import com.example.schoolapp.student.add_student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

private Context context ;
private ArrayList<StudentData> list;
DatabaseReference reference;


public TestAdapter(Context context , ArrayList<StudentData> list) {
        this.context = context;
        this.list = list;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(context)
        .inflate ( R.layout.student_layout,parent,false );

        return new ViewHolder ( view );
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder ,  int position) {
    StudentData studentData = list.get(position);
//        Glide.with(holder.img.getContext()).load(studentData.getImg())
//                .placeholder(R.drawable.ic_baseline_home_repair_service_24)
//                .circleCrop().error(R.drawable.ic_dashboard_black_24dp)
//                .into(holder.img);

    holder.name.setText(studentData.getFullName());
    holder.phone.setText(studentData.getStudent_phone());
     holder.parent_phone.setText(studentData.getParent_phone());
    holder.classs.setText(studentData.getYear());

    holder.btn_delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Are you sure delete this student");
            builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                  FirebaseDatabase.getInstance().getReference().child("school_Data")
                            .child(studentData.getYear()).
                child(studentData.getYear()).removeValue();

                    Toast.makeText(context, "you deleted student "+studentData.getFullName(), Toast.LENGTH_SHORT).show();



                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Toast.makeText(context, "you caceled deleting", Toast.LENGTH_SHORT).show();

                }
            });
            builder.show();
        }
    });
        }

@Override
public int getItemCount() {
        return list.size ();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name,classs,phone,parent_phone;
    ImageButton btn_delete;
    public ViewHolder(@NonNull View itemView) {
        super ( itemView );
        btn_delete = (ImageButton) itemView.findViewById(R.id.student_layout_btn_delete);
        name = (TextView) itemView.findViewById(R.id.student_layout_tv_name);
        classs = (TextView) itemView.findViewById(R.id.student_layout_c_1);
        phone = (TextView) itemView.findViewById(R.id.student_layout_tv_ph);
        parent_phone = (TextView) itemView.findViewById(R.id.student_layout_tv_parentPh);

    }
}

}
