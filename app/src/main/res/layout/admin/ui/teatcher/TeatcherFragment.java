package com.example.school.admin.ui.teatcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.databinding.FragmentTeatcherBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class TeatcherFragment extends Fragment {


    private FragmentTeatcherBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater ,
                             ViewGroup container , Bundle savedInstanceState) {


        TeatcherViewModel dashboardViewModel =
                new ViewModelProvider ( this ).get ( TeatcherViewModel.class );

        binding = FragmentTeatcherBinding.inflate ( inflater , container , false );
        View root = binding.getRoot ();
        final RecyclerView rv =binding.teacherRv;
        final FloatingActionButton fbtn = binding.teacherBtnAdd;
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        //final TextView textView = binding.textDashboard;
       // dashboardViewModel.getText ().observe ( getViewLifecycleOwner () , textView::setText );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        binding = null;
    }
}