package com.example.makeupapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentEnglish extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    EnglishAdapter myAdapter;
    ArrayList<EnglishHelper> list;
    Button englishUpdate, englishExit;
    EditText engUpID, engUpScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_english);

        englishUpdate = (Button)findViewById(R.id.btnUpdateEnglishScore);
        englishExit = (Button)findViewById(R.id.btnEngUpdateExit);
        engUpID = (EditText)findViewById(R.id.engUpdateID);
        engUpScore = (EditText)findViewById(R.id.engUpdateScore);

        recyclerView = findViewById(R.id.engList);
        databaseReference = FirebaseDatabase.getInstance().getReference("Scores");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new EnglishAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    EnglishHelper students = ds.getValue(EnglishHelper.class);
                    list.add(students);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        englishExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        englishUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newEngScore = Integer.parseInt(engUpScore.getText().toString());
                String engUpdateID = engUpID.getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("studEng",newEngScore);
                databaseReference.child(engUpdateID).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(StudentEnglish.this, "English Score Updated", Toast.LENGTH_SHORT).show();
                    }
                });
                engUpID.setText("");
                engUpScore.setText("");
            }
        });


    }
}