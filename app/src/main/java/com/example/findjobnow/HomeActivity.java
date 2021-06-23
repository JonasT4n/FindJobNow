package com.example.findjobnow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.example.findjobnow.Adapters.JobListAdapter;
import com.example.findjobnow.Adapters.JobListElementData;
import com.example.findjobnow.Drawer.MainNavDrawer;
import com.example.findjobnow.Drawer.NavDrawerType;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<JobListElementData> jobs = new ArrayList<>();
    DrawerLayout drawerNav;
    ImageView sandwichMenuOpen, sandwichMenuClose;
    ListView jobListView;
    Spinner dropDownCategory;
    MainNavDrawer mainNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get all components
        sandwichMenuOpen = findViewById(R.id.drawerOpenButton);
        sandwichMenuClose = findViewById(R.id.drawerCloseButton);
        drawerNav = findViewById(R.id.drawerLayout);
        jobListView = findViewById(R.id.homeJobList);
        dropDownCategory = findViewById(R.id.homeDropDownCategories);
        mainNavDrawer = new MainNavDrawer(drawerNav, findViewById(R.id.mainNavView));

        // Assign on click event
        sandwichMenuOpen.setOnClickListener(v -> openDrawer(drawerNav));
        sandwichMenuClose.setOnClickListener(v -> closeDrawer(drawerNav));
        mainNavDrawer.getDrawerHome().setOnClickListener(view -> closeDrawer(drawerNav));
        mainNavDrawer.getDrawerAboutUs().setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
            startActivity(intent);
            finish();
        });
        mainNavDrawer.getDrawerLogOut().setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Create sample data
        jobs.add(new JobListElementData("Job Title 1", "This is Job number 1"));
        jobs.add(new JobListElementData("Job Title 2", "This is Job number 2"));

        // Init adapter in list view
        JobListAdapter jobListAdapter = new JobListAdapter(HomeActivity.this,
                R.layout.layout_job_listview_preview, jobs);
        jobListView.setAdapter(jobListAdapter);

        // Set Dropdown categories
        ArrayAdapter<CharSequence> catAdapter = ArrayAdapter.createFromResource(this,
                R.array.job_categories, android.R.layout.simple_spinner_item);
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownCategory.setAdapter(catAdapter);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
