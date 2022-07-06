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

public class Student_Adapter extends RecyclerView.Adapter<Student_Adapter.MyViewHolder> {

    private Context context ;
    private ArrayList<StudentData> list;


    public Student_Adapter(Context context , ArrayList<StudentData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // holder.name.setText ( list.get ( position ).getName () );

        StudentData studentData = list.get(position);
//        Glide.with(holder.img.getContext()).load(studentData.getImg())
//                .placeholder(R.drawable.ic_baseline_home_repair_service_24)
//                .circleCrop().error(R.drawable.ic_dashboard_black_24dp)
//                .into(holder.img);

        holder.name.setText(studentData.getFullName());
        holder.phone.setText(studentData.getStudent_phone());
       // holder.parent_phone.setText(studentData.getParent_phone());
        holder.classs.setText(studentData.getYear());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //CircleImageView img;
       // ImageButton img_edit,img_delete;
        TextView name,classs,phone,parent_phone;
        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );

           // img = (CircleImageView) itemView.findViewById(R.id.student_layout_img);
          //  img_edit = (ImageButton) itemView.findViewById(R.id.student_layout_btn_edit);
          //  img_delete = (ImageButton) itemView.findViewById(R.id.student_layout_btn_del);
            name = (TextView) itemView.findViewById(R.id.student_layout_tv_name);
            classs = (TextView) itemView.findViewById(R.id.student_layout_c_1);
            phone = (TextView) itemView.findViewById(R.id.student_layout_tv_ph);
            parent_phone = (TextView) itemView.findViewById(R.id.student_layout_tv_parentPh);



        }
    }
}
