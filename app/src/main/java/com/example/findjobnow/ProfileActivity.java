package com.example.findjobnow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity{

    private TextView mTextView;

    Button LoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get all view components
        mTextView = findViewById(R.id.text);

        // Subscribe events to views
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load home page
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                ProfileActivity.this.finish();
                startActivity(intent);
            }
        });
    }

    public void openDatePicker(View view) {

    }
}