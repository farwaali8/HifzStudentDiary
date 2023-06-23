package com.example.madrasataskmanager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    DBHandler db;
    ListView listView;
    TextView head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        FloatingActionButton floatingButton = findViewById(R.id.floatingActionButton4);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action when the button is clicked
                Intent intent = new Intent(StudentListActivity.this, addActivity.class);
                startActivity(intent);
            }});
        //setContentView(R.layout.activity_student_list);
        head = findViewById(R.id.textView);
        db = new DBHandler(this);
        ArrayList<Student> students = db.getAllStudents();
        int size = students.size();
        head.setText("Total Students: " + size);
        listView = findViewById(R.id.listView);

        // Create an instance of the custom adapter
        StudentAdapter adapter = new StudentAdapter(this, students);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);



    }
}
