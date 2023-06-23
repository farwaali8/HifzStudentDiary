package com.example.madrasataskmanager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.madrasataskmanager.Student;

public class TaskAssign extends AppCompatActivity {
    //Button nextButton = findViewById(R.id.button56);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_assign);
        Button nextButton = findViewById(R.id.button56);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the action when the button is clicked
                Intent intent = new Intent(TaskAssign.this, TaskDetails.class);
                startActivity(intent);
            }
        });


        // Retrieve the Intent that started this activity
        Intent intent = getIntent();

        // Check if the Intent contains the "student" extra data
        if (intent.hasExtra("student")) {
            // Retrieve the Student object from the Intent
            Student student = (Student) intent.getSerializableExtra("student");

            // Display the data in TextViews or any other UI elements
            TextView nameTextView = findViewById(R.id.textView6);
            TextView rollNoTextView = findViewById(R.id.textView7);
            TextView classTextView = findViewById(R.id.textView8);

            nameTextView.setText(student.getName());
            rollNoTextView.setText(student.getRollNo());
            classTextView.setText(student.getclass());
        }
    }
}
