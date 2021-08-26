package com.example.makeupapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteStudent extends AppCompatActivity {

    private  Button delBtn, exitBtn;
    private EditText delID;
    DatabaseReference delStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        setupViews();
        delStudent= FirebaseDatabase.getInstance().getReference("Scores");

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
                String deleteID = delID.getText().toString();
                delStudent.child(deleteID).removeValue();
                Toast.makeText(DeleteStudent.this, "Student removed from class", Toast.LENGTH_SHORT).show();
                delID.setText("");


            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }
    public void openDialog(){
        DialogClass dialogClass = new DialogClass();
        dialogClass.show(getSupportFragmentManager(),"DELETE DIALOG");
    }
    private void setupViews(){

        exitBtn = (Button) findViewById(R.id.exDelInterface);
        delBtn = (Button) findViewById(R.id.btnDeleteStudent);
        delID = (EditText) findViewById(R.id.delID);
    }
}