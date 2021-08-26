package com.example.makeupapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClassList extends AppCompatActivity {

    ListView classListView;
    FirebaseDatabase db;
    DatabaseReference dbRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Students students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        students = new Students();
        classListView = (ListView)findViewById(R.id.classList);
        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Scores");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.class_info,R.id.classInfo,list);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot s: snapshot.getChildren()){

                    students = s.getValue(Students.class);
                    list.add(students.getStudID().toString()+ "     "+ students.getStudName().toString());

                }
                classListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}