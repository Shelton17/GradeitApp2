package com.example.makeupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterTeachers extends AppCompatActivity {
    private EditText teachName;
    private EditText teachPassword, teachSubject;
    private String teachRank;
    private Button btnExit, showTeachers, registerTeacher;
    DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teachers);
        setupViews();

        dbReference = FirebaseDatabase.getInstance().getReference();
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        registerTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (validate()){
                String tName = teachName.getText().toString();
                String tPassword = teachPassword.getText().toString();
                String tRank = teachRank;
                String tSub = teachSubject.getText().toString();

                DatabaseClass newTeacher = new DatabaseClass(tName,tPassword,tRank,tSub);
                dbReference.child("Teachers").child(tName).setValue(newTeacher);
                Toast.makeText(RegisterTeachers.this, "Teacher registration successful", Toast.LENGTH_SHORT).show();

            }
            }
        });
        showTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterTeachers.this, RegisteredTeachers.class);
                startActivity(intent);
            }
        });

    }
    private void setupViews(){
        btnExit = (Button)findViewById(R.id.btnExitApp);
        showTeachers = (Button)findViewById(R.id.btnShowTeachers);
        registerTeacher = (Button)findViewById(R.id.btnRegTeacher);
        teachName = (EditText)findViewById(R.id.teacherName);
        teachPassword = (EditText)findViewById(R.id.teacherPassword);
        teachSubject = (EditText) findViewById(R.id.teacherSubject);
    }
    private Boolean validate(){
        Boolean result = false;

        String tName = teachName.getText().toString();
        String tPassword = teachPassword.getText().toString();

        if (tName.isEmpty() || tPassword.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();

        }else {
            result = true;
        }
        return result;
    }

    public void teacherRank(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.classTeacher:
                teachRank = "ClassTeacher";
                break;
            case R.id.subjectTeacher:
                teachRank = "SubjectTeacher";

        }
    }
}