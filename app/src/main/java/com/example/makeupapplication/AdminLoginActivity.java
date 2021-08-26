package com.example.makeupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {
    private Button btnExit, btnAdminLogin;
    private EditText textUsername, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        setupViews();

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminName = textUsername.getText().toString().trim();
                final String adminPassword = textPassword.getText().toString().trim();

                String systemName = "admin";
                String systemPass = "gradeit@pp";

                if (adminName.equals(systemName)){
                    if(adminPassword.equals(systemPass)){
                        startActivity(new Intent(AdminLoginActivity.this, RegisterTeachers.class));
                    }else {
                        Toast.makeText(AdminLoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(AdminLoginActivity.this, "Wrong username", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    private void setupViews(){
        btnExit = (Button)findViewById(R.id.btnExitApp);
        btnAdminLogin = (Button)findViewById(R.id.btnAdminLogIn);
        textPassword = (EditText)findViewById(R.id.adminPassword);
        textUsername = (EditText)findViewById(R.id.adminName);

    }
}