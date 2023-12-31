package com.example.school.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.R;
import com.example.school.pojo.StudentData;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

private Context context ;
private ArrayList<StudentData> list;


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
public void onBindViewHolder(@NonNull ViewHolder holder , int position) {
    StudentData studentData = list.get(position);
//        Glide.with(holder.img.getContext()).load(studentData.getImg())
//                .placeholder(R.drawable.ic_baseline_home_repair_service_24)
//                .circleCrop().error(R.drawable.ic_dashboard_black_24dp)
//                .into(holder.img);

    holder.name.setText(studentData.getFullName());
    holder.phone.setText(studentData.getStudent_phone());
     holder.parent_phone.setText(studentData.getParent_phone());
    holder.classs.setText(studentData.getYear());
        }

@Override
public int getItemCount() {
        return list.size ();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name,classs,phone,parent_phone;
    public ViewHolder(@NonNull View itemView) {
        super ( itemView );
        name = (TextView) itemView.findViewById(R.id.student_layout_tv_name);
        classs = (TextView) itemView.findViewById(R.id.student_layout_c_1);
        phone = (TextView) itemView.findViewById(R.id.student_layout_tv_ph);
        parent_phone = (TextView) itemView.findViewById(R.id.student_layout_tv_parentPh);

    }
}

}
