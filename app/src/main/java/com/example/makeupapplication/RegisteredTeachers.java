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

public class RegisteredTeachers extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference dbRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Teachers teachers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_teachers);
        teachers = new Teachers();
        listView = (ListView)findViewById(R.id.teacherList);
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference("Teachers");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.teacher_info,R.id.teacherInfo,list);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    teachers = snapshot1.getValue(Teachers.class);
                    list.add(teachers.getTeacherName().toString() + "  "+ teachers.getTeacherRank().toString()+ "  "+ teachers.getTeacherSubject().toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}