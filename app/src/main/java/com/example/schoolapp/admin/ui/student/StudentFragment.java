package com.example.schoolapp.admin.ui.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.example.schoolapp.adapter.TestAdapter;
import com.example.schoolapp.pojo.StudentData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentFragment extends Fragment {

    FloatingActionButton fbtn;

    
    RecyclerView recyclerView;
    TestAdapter adapter;
    ArrayList<StudentData> list;
    DatabaseReference reference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_students, container, false);
        recyclerView = v.findViewById(R.id.student_rv);
        fbtn = v.findViewById(R.id.fr_std_fbtn_add);
        list = new ArrayList<>();
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),
                        com.example.schoolapp.student.add_student.class));
            }
        });

        reference = FirebaseDatabase.getInstance().getReference().child("school_Data");

        reference.child("pre_1").addValueEventListener ( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear ();
                for (DataSnapshot snap : snapshot.getChildren ()) {
                    StudentData studentData = snap.getValue ( com.example.schoolapp.pojo.StudentData.class );
                    list.add ( studentData );
                    adapter.notifyDataSetChanged ();


                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        } );
        reference.child("pre_2").addValueEventListener ( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list.clear ();
                for (DataSnapshot snap : snapshot.getChildren ()) {
                    StudentData studentData = snap.getValue ( com.example.schoolapp.pojo.StudentData.class );
                    list.add ( studentData );
                    adapter.notifyDataSetChanged ();


                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        } );
        reference.child("pre_3").addValueEventListener ( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list.clear ();
                for (DataSnapshot snap : snapshot.getChildren ()) {
                    StudentData studentData = snap.getValue ( com.example.schoolapp.pojo.StudentData.class );
                    list.add ( studentData );
                    adapter.notifyDataSetChanged ();


                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        } );
        LinearLayoutManager llm= new LinearLayoutManager ( getActivity()
                , RecyclerView.VERTICAL,false );

        adapter=new TestAdapter (getActivity(),list);
        recyclerView.setLayoutManager ( llm );
        recyclerView.setAdapter ( adapter );

         return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}