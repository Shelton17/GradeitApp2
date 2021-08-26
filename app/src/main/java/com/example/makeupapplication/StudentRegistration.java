package com.example.makeupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegistration extends AppCompatActivity {

    private EditText textName, textID, textMail;
    private Button exitStudReg, addStudent;
    DatabaseReference databaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        setupViews();
        databaseRef = FirebaseDatabase.getInstance().getReference();
        exitStudReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){

                    String sID = textID.getText().toString();
                    String sName = textName.getText().toString();
                    int sMath = 0;
                    int sEng = 0;
                    int sSwa = 0;
                    String sMail = textMail.getText().toString();
                    StudentHelper student = new StudentHelper(sID,sName,sMath,sEng,sSwa,sMail);
                    databaseRef.child("Scores").child(sID).setValue(student);
                    Toast.makeText(StudentRegistration.this, "Student Registered", Toast.LENGTH_SHORT).show();
                    textID.setText("");
                    textName.setText("");
                    textMail.setText("");

                }

            }
        });
    }
    private void setupViews(){
        exitStudReg = (Button)findViewById(R.id.exitStudReg);
        addStudent = (Button)findViewById(R.id.addStudent);
        textName = (EditText)findViewById(R.id.txtName);
        textID = (EditText)findViewById(R.id.txtID);
        textMail = (EditText)findViewById(R.id.txtMail);
    }


    private Boolean validate(){
        Boolean result = false;

        String tName = textName.getText().toString();
        String tID = textID.getText().toString();
        String tMail = textMail.getText().toString();

        if (tName.isEmpty() || tID.isEmpty() || tMail.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();

        }else {
            if(isEmailValid()){
                result = true;
            }else {
                Toast.makeText(this, "Email Address Not Valid", Toast.LENGTH_SHORT).show();

            }

        }
        return result;
    }

    private Boolean isEmailValid(){
//        setupViews();
        String checkMail = textMail.getText().toString();
        CharSequence charSequence = new StringBuilder(checkMail);

        return (!TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches());

    }

}