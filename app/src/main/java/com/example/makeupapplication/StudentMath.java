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

public class StudentMath extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MathAdapter myAdapter;
    ArrayList<MathHelper> list;
    Button mathUpdate, mathExit;
    EditText mathUpID, mathUpScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_math);

        mathUpdate = (Button)findViewById(R.id.btnUpdateMathScore);
        mathExit = (Button)findViewById(R.id.btnMathUpdateExit);
        mathUpID = (EditText)findViewById(R.id.mathUpdateID);
        mathUpScore = (EditText)findViewById(R.id.mathUpdateScore);

        recyclerView = findViewById(R.id.mathList);
        databaseReference = FirebaseDatabase.getInstance().getReference("Scores");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MathAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    MathHelper students = ds.getValue(MathHelper.class);
                    list.add(students);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mathExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        mathUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newMathScore = Integer.parseInt(mathUpScore.getText().toString());
                String mathUpdateID = mathUpID.getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("studMath",newMathScore);
                databaseReference.child(mathUpdateID).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(StudentMath.this, "Mathematics Score Updated", Toast.LENGTH_SHORT).show();

                    }
                });

                mathUpID.setText("");
                mathUpScore.setText("");

                }
        });

    }
}