package com.example.wis.meetballs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class CreateFragment extends Fragment {


    protected EditText titleEdit, notesEdit, dateEdit, timeEdit;
    protected AutoCompleteTextView attendeeEdit;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);


        final Intent i = new Intent(getContext(), MapsActivity.class);

        titleEdit = view.findViewById(R.id.MeetingTitle);
        notesEdit = view.findViewById(R.id.MeetingNotes);
        dateEdit = view.findViewById(R.id.MeetingDate);
        timeEdit = view.findViewById(R.id.MeetingTime);
        attendeeEdit = view.findViewById(R.id.AddAttendee);


        Button createMeetingButton, locationButton;
        createMeetingButton = view.findViewById(R.id.createMeetingButton);
        createMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeeting(view);
            }
        });

        locationButton = view.findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                R.layout.attendee_layout, R.id.pastAttendee, FileHandler.findAttendees(this.getContext()));
        attendeeEdit.setAdapter(adapter);


        return view;
    }




    public void addMeeting(View view) {
        String title = this.titleEdit.getText().toString();
        String notes = this.notesEdit.getText().toString();
        String date = this.dateEdit.getText().toString();
        String time = this.timeEdit.getText().toString();
        String attend = this.attendeeEdit.getText().toString();
        Double lat = MapsActivity.lat;
        Double longi = MapsActivity.longi;
        FileHandler fh = new FileHandler(getContext());

        boolean valid = true;

        if (title.equals("")) {
            valid = false;
        }
        if (date.equals("")) {
            valid = false;
        }
        if (notes.equals("")) {
            valid = false;
        }
        if (time.equals("")) {
            valid = false;
        }

        if (attend.equals("")) {
            valid = false;
        }

        if (valid) {

            String[] names = attend.split(" ");

            fh.createMeeting(title, notes, date, time, lat, longi, names);
        } else {
            Toast.makeText(this.getContext(), "Enter data", Toast.LENGTH_SHORT).show();
        }

        valid = false;

    }

    public void setTextColorBlue() {
        EditText titleEdit = getActivity().findViewById(R.id.MeetingTitle);

        titleEdit.setTextColor(0xFF00FF00);
        titleEdit.setHintTextColor(0xFF00FF00);
    }



}



