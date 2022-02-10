package com.example.mobileapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.Course;
import com.example.mobileapp.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context)
                .inflate(R.layout.course_item, parent, false);

        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        holder.courseTitle.setText(courseList.get(position).getTitle());
        holder.courseDate.setText(courseList.get(position).getDate());
        holder.courseLevel.setText(courseList.get(position).getLevel());
        holder.courseBackColor.setBackgroundColor(Color.parseColor(courseList.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + courseList.get(position).getImg(),
                "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public final static class CourseViewHolder extends RecyclerView.ViewHolder {

        LinearLayout courseBackColor;
        ImageView courseImage;
        TextView courseTitle, courseLevel, courseDate;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseBackColor = itemView.findViewById(R.id.courseBackColor);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseLevel = itemView.findViewById(R.id.courseLevel);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseImage = itemView.findViewById(R.id.courseImage);
        }
    }

}
