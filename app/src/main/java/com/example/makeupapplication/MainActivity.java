package com.example.makeupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnTeachers, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

        btnTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TeachersActivity.class));
            }
        });
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdminLoginActivity.class));
            }
        });
    }
    private void setupViews(){
        btnAdmin = (Button)findViewById(R.id.btnAdmin);
        btnTeachers = (Button)findViewById(R.id.btnTeachers);

    }
}