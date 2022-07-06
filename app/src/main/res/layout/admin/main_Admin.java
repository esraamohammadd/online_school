package com.example.school.admin;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.school.R;
import com.example.school.databinding.ActivityMainAdminBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class main_Admin extends AppCompatActivity {

    private ActivityMainAdminBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        binding = ActivityMainAdminBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        BottomNavigationView navView = findViewById ( R.id.nav_view );
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder (
                R.id.navigation_home , R.id.navigation_teatcheres , R.id.navigation_students  , R.id.navigation_setting)
                .build ();
        NavController navController = Navigation.findNavController ( this , R.id.nav_host_fragment_activity_main_admin );
        NavigationUI.setupActionBarWithNavController ( this , navController , appBarConfiguration );
        NavigationUI.setupWithNavController ( binding.navView , navController );




    }

    //*******menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//  getMenuInflater().
        return super.onCreateOptionsMenu(menu);
    }


}