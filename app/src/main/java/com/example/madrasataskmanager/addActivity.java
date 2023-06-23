package com.example.madrasataskmanager;


//import android.content.Intent;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addActivity extends AppCompatActivity {
    EditText name, rollNum, Class;
    Button add;
    DBHandler db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.editName);
        rollNum = findViewById(R.id.editTextNumber2);
        Class = findViewById(R.id.editTextTextPersonName2);
        add = findViewById(R.id.button2);
        db = new DBHandler(this);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String RollNumber = rollNum.getText().toString();
                String StdClass = Class.getText().toString();
                if (Name.isEmpty() || RollNumber.isEmpty() || StdClass.isEmpty())
                {
                    Toast.makeText(addActivity.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Student student = new Student(Name, RollNumber, StdClass);
                    long result = db.insertStudent(student);
                    if (result != -1)
                    {
                        Toast.makeText(addActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(addActivity.this, "Operation Failed", Toast.LENGTH_SHORT).show();
                    }
                    name.setText("");
                    rollNum.setText("");
                    Class.setText("");
                }
            }
        });
    }
}

