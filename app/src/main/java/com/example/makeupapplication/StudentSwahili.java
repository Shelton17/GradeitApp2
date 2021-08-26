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

public class StudentSwahili extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    SwahiliAdapter myAdapter;
    ArrayList<SwahiliHelper> list;
    Button swahiliUpdate, swahiliExit;
    EditText swaUpID, swaUpScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_swahili);

        swahiliUpdate = (Button)findViewById(R.id.btnUpdateSwahiliScore);
        swahiliExit = (Button)findViewById(R.id.btnSwaUpdateExit);
        swaUpID = (EditText)findViewById(R.id.swaUpdateID);
        swaUpScore = (EditText)findViewById(R.id.swaUpdateScore);

        recyclerView = findViewById(R.id.swaList);
        databaseReference = FirebaseDatabase.getInstance().getReference("Scores");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new SwahiliAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    SwahiliHelper students = ds.getValue(SwahiliHelper.class);
                    list.add(students);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        swahiliExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        swahiliUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newSwaScore = Integer.parseInt(swaUpScore.getText().toString());
                String swaUpdateID = swaUpID.getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("studSwa",newSwaScore);
                databaseReference.child(swaUpdateID).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(StudentSwahili.this, "Swahili Score Updated", Toast.LENGTH_SHORT).show();

                    }
                });
                swaUpID.setText("");
                swaUpScore.setText("");
            }
        });

    }
}