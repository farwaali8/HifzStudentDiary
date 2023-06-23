package com.example.madrasataskmanager;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.madrasataskmanager.Student;
import com.example.madrasataskmanager.R;
import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    public ArrayList<Student> students;


    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
        this.context = context;
        this.students = students;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.view, parent, false);

            holder = new ViewHolder();


            // holder.imageViewFriendPicture = view.findViewById(R.id.imageViewFriendPicture);
            holder.textViewFriendName = view.findViewById(R.id.textViewName);
            holder.textViewDate = view.findViewById(R.id.textViewRollNo);
            holder.textViewCity = view.findViewById(R.id.textViewClassName);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Student student = students.get(position);

        // Set the data to the views
       // holder.imageViewFriendPicture.setImageResource(R.drawable.muslim);
        holder.textViewFriendName.setText(student.getName());
        holder.textViewDate.setText(student.getRollNo());
        holder.textViewCity.setText(student.getclass());
        holder.deleteButton = view.findViewById(R.id.button4);
        holder.updateButton = view.findViewById(R.id.button3);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the desired action when the list item is clicked
                // For example, you can display a toast message with the student's name
                Toast.makeText(context, "Clicked student: " + student.getName(), Toast.LENGTH_SHORT).show();

                // You can also pass the selected student's data to another activity
                // by creating an intent and adding the student object as an extra
                Intent intent = new Intent(context, TaskAssign.class);
                intent.putExtra("student", student);
                context.startActivity(intent);
            }
        });
// Enable the Buttons
//        holder.deleteButton.setEnabled(true);
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the student at the specified position
        Student student = students.get(position);

        // Create an instance of DBHandler
        DBHandler dbHandler = new DBHandler(context);

        // Delete the student from the database
        int deletedRows = dbHandler.deleteStudent(student.getRollNo());

        if (deletedRows > 0) {
            // Remove the student from the ArrayList
            students.remove(position);

            // Notify the adapter that the data has changed
            notifyDataSetChanged();
        }
                }

        });



        return view;
    }

    static class ViewHolder {
        ImageView imageViewFriendPicture;
        TextView textViewFriendName;
        TextView textViewDate;
        TextView textViewCity;

        Button deleteButton;
        Button updateButton;
    }
}

