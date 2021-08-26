package com.example.makeupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassTeacherInterface extends AppCompatActivity {

    private Button addStud, classList, classPerf, delStud, exInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_teacher_interface);
        addStud = (Button)findViewById(R.id.addStud);
        classList = (Button)findViewById(R.id.viewStud);
        classPerf = (Button)findViewById(R.id.viewPerf);
        delStud = (Button) findViewById(R.id.delStud);
        exInterface = (Button)findViewById(R.id.btnExit);
        addStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClassTeacherInterface.this, StudentRegistration.class));

            }
        });
        classList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassTeacherInterface.this,ClassList.class);
                startActivity(intent);
            }
        });
        delStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClassTeacherInterface.this, DeleteStudent.class));

            }
        });
        classPerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClassTeacherInterface.this, StudentResult.class));

            }
        });
        exInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}