package com.example.wis.meetballs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CreateFragment extends Fragment {


    protected EditText titleEdit, notesEdit, dateEdit, timeEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        titleEdit = view.findViewById(R.id.MeetingTitle);
        notesEdit = view.findViewById(R.id.MeetingNotes);
        dateEdit = view.findViewById(R.id.MeetingDate);
        timeEdit = view.findViewById(R.id.MeetingTime);

        Button mButton;
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeeting(view);
                System.out.println("Click");
            }
        });

        return view;
    }

    public void addMeeting(View view) {
        String title = this.titleEdit.getText().toString();
        String notes = this.notesEdit.getText().toString();
        String date = this.dateEdit.getText().toString();
        String time = this.timeEdit.getText().toString();
        System.out.println(title);
        FileHandler fh = new FileHandler(getContext());
        fh.createMeeting(title, notes, date, time);

    }




}



