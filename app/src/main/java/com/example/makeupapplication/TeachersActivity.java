package com.example.makeupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeachersActivity extends AppCompatActivity {

    private Button btnExit, btnClassLogin;
    private EditText textUsername, textPassword;
    DatabaseReference dbReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        setupViews();
        dbReference = FirebaseDatabase.getInstance().getReference();

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        btnClassLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String enteredUserName = textUsername.getText().toString().trim();
                final String enteredUserPass = textPassword.getText().toString().trim();

                dbReference = FirebaseDatabase.getInstance().getReference().child("Teachers").child(enteredUserName);
                dbReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String classTeacherName = snapshot.child("teacherName").getValue().toString();
                        String classTeacherPass = snapshot.child("teacherPassword").getValue().toString();
                        String classTeacherRank = snapshot.child("teacherRank").getValue().toString();
                        String theTeacherSubject = snapshot.child("teacherSubject").getValue().toString();
                        Log.i("Password",classTeacherPass);
                        Log.i("Rank",classTeacherRank);
                        Log.i("Name",classTeacherName);
                        Log.i("enteredP",enteredUserPass);
                        Log.i("enteredName",enteredUserName);


                        boolean engCheck = theTeacherSubject.equals("English");
                        boolean swaCheck = theTeacherSubject.equals("Swahili");
                        boolean matCheck = theTeacherSubject.equals("Mathematics");
                        boolean passCheck = enteredUserPass.equals(classTeacherPass);
                        boolean ctCheck = classTeacherRank.equals("ClassTeacher");
                        boolean stCheck = classTeacherRank.equals("SubjectTeacher");

                        Log.i("passCheck", String.valueOf(passCheck));
                        Log.i("ctCheck", String.valueOf(ctCheck));
                        Log.i("stCheck", String.valueOf(stCheck));
                        Log.i("engCheck", String.valueOf(engCheck));
                        Log.i("swaCheck", String.valueOf(swaCheck));
                        Log.i("matCheck", String.valueOf(matCheck));



                        if (passCheck){

                            if (ctCheck){
                                startActivity(new Intent(TeachersActivity.this, ClassTeacherInterface.class));
                            }
                            if (stCheck){
                                if(engCheck){
                                    startActivity(new Intent(TeachersActivity.this, StudentEnglish.class));

                                }
                                if(swaCheck){
                                    startActivity(new Intent(TeachersActivity.this, StudentSwahili.class));

                                }
                                if(matCheck){
                                    startActivity(new Intent(TeachersActivity.this, StudentMath.class));

                                }


                            }


                        }else {
                            Toast.makeText(TeachersActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();


                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }
    private void setupViews(){
        btnExit = (Button)findViewById(R.id.btnExitApp);
        btnClassLogin = (Button)findViewById(R.id.btnClassLogIn);
        textPassword = (EditText)findViewById(R.id.tPassword);
        textUsername = (EditText)findViewById(R.id.tName);

    }
}