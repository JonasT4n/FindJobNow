package com.example.findjobnow.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.findjobnow.R;

import java.util.ArrayList;

public class JobListAdapter extends ArrayAdapter<JobListElementData> {

    private Context myContext;
    private int resourceTemplate;

    public JobListAdapter(@NonNull Context context, int resource, ArrayList<JobListElementData> jobs) {
        super(context, resource, jobs);
        myContext = context;
        resourceTemplate = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(myContext);
            convertView = inflater.inflate(resourceTemplate, null);
        }

        JobListElementData item = getItem(position);
        if (item != null) {
            TextView titleTxt = convertView.findViewById(R.id.jobTitle);
            TextView descTxt = convertView.findViewById(R.id.jobDescription);

            titleTxt.setText(item.getTitle());
            descTxt.setText(item.getDescription());
        }

        return convertView;
    }


}
