package com.example.findjobnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameField, pwField;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all components
        usernameField = findViewById(R.id.loginUsernameInput);
        pwField = findViewById(R.id.loginPasswordInput);
        loginBtn = findViewById(R.id.loginButton);

        // Fill saved username field
        SharedPreferences savedPref = getSharedPreferences(getString(
                R.string.pref_file_key), MODE_PRIVATE);
        usernameField.setText(savedPref.getString(getString(R.string.pref_save_username),
                "\0"));

        // Create login event listener
        loginBtn.setOnClickListener(v -> {
            String usernameStr = usernameField.getText().toString();
            String passwordStr = pwField.getText().toString();
            if (usernameStr.length() == 0 || passwordStr.length() == 0) {
                Toast.makeText(MainActivity.this, "Username or Password cannot be empty.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Save local data
            SharedPreferences sharedPreferences = getSharedPreferences(getString(
                    R.string.pref_file_key), MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();
            prefEdit.putString(getString(R.string.pref_save_username), usernameStr);
            prefEdit.apply();

            // Load home page
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            MainActivity.this.finish();
            startActivity(intent);
        });
    }
}
