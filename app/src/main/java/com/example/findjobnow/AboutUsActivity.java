package com.example.findjobnow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.findjobnow.Drawer.MainNavDrawer;

public class AboutUsActivity extends AppCompatActivity {

    DrawerLayout drawerNav;
    ImageView sandwichMenuOpen, sandwichMenuClose;
    MainNavDrawer mainNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // Get all components
        sandwichMenuOpen = findViewById(R.id.drawerOpenButton);
        sandwichMenuClose = findViewById(R.id.drawerCloseButton);
        drawerNav = findViewById(R.id.drawerLayout);
        mainNavDrawer = new MainNavDrawer(drawerNav, findViewById(R.id.mainNavView));

        // Assign on click event
        sandwichMenuOpen.setOnClickListener(v -> openDrawer(drawerNav));
        sandwichMenuClose.setOnClickListener(v -> closeDrawer(drawerNav));
        mainNavDrawer.getDrawerHome().setOnClickListener(view -> {
            Intent intent = new Intent(AboutUsActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
        mainNavDrawer.getDrawerAboutUs().setOnClickListener(view -> closeDrawer(drawerNav));
        mainNavDrawer.getDrawerLogOut().setOnClickListener(view -> {
            Intent intent = new Intent(AboutUsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
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