package com.example.findjobnow.Drawer;

import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.findjobnow.R;
import com.google.android.material.navigation.NavigationView;

public class MainNavDrawer {

    private final DrawerLayout drawerLayout;
    private final NavigationView view;
    private final View drawerHome, drawerAboutUs, drawerLogOut;

    public MainNavDrawer(DrawerLayout drawerLayout, NavigationView view) {
        this.drawerLayout = drawerLayout;
        this.view = view;

        drawerHome = view.findViewById(R.id.drawerMenuHome);
        drawerAboutUs = view.findViewById(R.id.drawerMenuAboutUs);
        drawerLogOut = view.findViewById(R.id.drawerMenuLogOut);
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public NavigationView getView() {
        return view;
    }

    public View getDrawerHome() {
        return drawerHome;
    }

    public View getDrawerAboutUs() {
        return drawerAboutUs;
    }

    public View getDrawerLogOut() {
        return drawerLogOut;
    }
}
