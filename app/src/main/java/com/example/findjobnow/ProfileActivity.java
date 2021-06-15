package com.example.findjobnow;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity{

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mTextView = (TextView) findViewById(R.id.text);

    }

    public void openDatePicker(View view) {
    }
}