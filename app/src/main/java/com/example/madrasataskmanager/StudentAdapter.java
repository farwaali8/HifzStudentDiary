package com.example.madrasataskmanager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.madrasataskmanager.Student;
import com.example.madrasataskmanager.R;
import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private ArrayList<Student> students;

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

        return view;
    }

    static class ViewHolder {
        ImageView imageViewFriendPicture;
        TextView textViewFriendName;
        TextView textViewDate;
        TextView textViewCity;
    }
}

