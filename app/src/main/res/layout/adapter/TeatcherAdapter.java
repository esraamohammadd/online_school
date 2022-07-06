package com.example.school.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.R;
import com.example.school.pojo.TeatcherData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeatcherAdapter extends FirebaseRecyclerAdapter
        <TeatcherData,TeatcherAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TeatcherAdapter(@NonNull FirebaseRecyclerOptions<TeatcherData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull TeatcherData model) {

        holder.name.setText(model.getFullName());
        holder.c1.setText(model.getClass1());
        holder.c2.setText(model.getClass2());
        holder.c3.setText(model.getClass3());
        holder.phone.setText(model.getPhone_No());
//        Glide.with(holder.img.getContext()).load(model.getImg())
//                .placeholder(R.drawable.ic_baseline_home_repair_service_24)
//                .circleCrop().error(R.drawable.ic_dashboard_black_24dp)
//                .into(holder.img);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teach_layout
        ,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        ImageButton img_edit,img_delete;
        TextView name,c1,c2,c3,phone;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.teach_layout_img);
            img_edit = (ImageButton) itemView.findViewById(R.id.teach_layout_btn_edit);
            img_delete = (ImageButton) itemView.findViewById(R.id.teach_layout_btn_del);
            name = (TextView) itemView.findViewById(R.id.teach_layout_tv_name);
            c1 = (TextView) itemView.findViewById(R.id.teach_layout_c_1);
            phone = (TextView) itemView.findViewById(R.id.teach_layout_tv_ph);
            c2 = (TextView) itemView.findViewById(R.id.teach_layout_tv_c2);
            c3 = (TextView) itemView.findViewById(R.id.teach_layout_tv_c3);
        }
    }
}
