package com.example.school.admin.ui.students;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.R;
import com.example.school.adapter.TestAdapter;
import com.example.school.databinding.FragmentStudentsBinding;
import com.example.school.pojo.StudentData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class StudentsFragment extends Fragment {

    private FragmentStudentsBinding binding;
   FloatingActionButton fbtn;
//   RecyclerView rv;
RecyclerView recyclerView;
    TestAdapter adapter;
    ArrayList<StudentData> list;
    DatabaseReference reference;


    public View onCreateView(@NonNull LayoutInflater inflater ,
                             ViewGroup container , Bundle savedInstanceState) {
        StudentViewModel studentViewModel =
                new ViewModelProvider ( this ).get ( StudentViewModel.class );

        binding = FragmentStudentsBinding.inflate ( inflater , container , false );
        View root = binding.getRoot ();
        recyclerView = root.findViewById(R.id.student_rv);
        fbtn = root.findViewById(R.id.fr_std_fbtn_add);
        list = new ArrayList<>();
//        StudentData s = new StudentData("esraa mohammad",
//                "0116543","pre_1","29905012643",
//        "0128765","440018","assuit","255","Esraa");
//        StudentData s1= new StudentData("esraa mohammad",
//                "0116543","pre_1","29905012643",
//                "0128765","440018","assuit","255","Esraa");
//
//        StudentData s2 = new StudentData("esraa mohammad",
//                "0116543","pre_1","29905012643",
//                "0128765","440018","assuit","255","Esraa");
//        StudentData s3 = new StudentData("esraa mohammad",
//                "0116543","pre_1","29905012643",
//                "0128765","440018","assuit","255","Esraa");
//        list.add(s);
//        list.add(s2);
//        list.add(s3);
//        list.add(s1);
//

        reference = FirebaseDatabase.getInstance().getReference().child("school_Data")
                .child("pre_1");

        reference.addValueEventListener ( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear ();
                for (DataSnapshot snap : snapshot.getChildren ()) {
                  StudentData studentData = snap.getValue ( com.example.school.pojo.StudentData.class );
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


//
//     fbtn = binding.floatingActionButton;
 //    rv = binding.studentRv;
//     rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//     FirebaseRecyclerOptions<StudentModel> options =
//                new FirebaseRecyclerOptions.Builder<StudentModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference("school_Data")
//                                .child("s1") , StudentModel.class)
//                        .build();
//        StudentAdapter adapter = new StudentAdapter(options);
//        rv.setAdapter(adapter);



      //  notificationsViewModel.getText ().observe ( getViewLifecycleOwner () , textView::setText );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        binding = null;
    }



}