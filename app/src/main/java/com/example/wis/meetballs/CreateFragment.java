package com.example.wis.meetballs;

import android.content.Intent;
import android.graphics.Color;
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
    //Variables to change the text
    static int colorText = Color.BLACK;
    static int sizeText = 26;
    //Variables for the text views inside the create fragment
    protected EditText titleEdit, notesEdit, dateEdit, timeEdit;
    protected AutoCompleteTextView attendeeEdit;

    //Called when the view is created
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

        titleEdit.setTextColor(colorText);
        titleEdit.setHintTextColor(colorText);
        titleEdit.setTextSize(sizeText);
        notesEdit.setTextColor(colorText);
        notesEdit.setHintTextColor(colorText);
        notesEdit.setTextSize(sizeText);

        dateEdit.setTextColor(colorText);
        dateEdit.setHintTextColor(colorText);
        dateEdit.setTextSize(sizeText);

        timeEdit.setTextColor(colorText);
        timeEdit.setHintTextColor(colorText);
        timeEdit.setTextSize(sizeText);

        attendeeEdit.setTextColor(colorText);
        attendeeEdit.setHintTextColor(colorText);
        attendeeEdit.setTextSize(sizeText);

        //Button to create the meeting and pass it to the filehandler
        Button createMeetingButton = view.findViewById(R.id.createMeetingButton);
        createMeetingButton.setTextColor(colorText);
        createMeetingButton.setTextSize(sizeText);
        createMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeeting(view);
            }
        });

        //Button to show the mapview and allow user to set location
        Button locationButton = view.findViewById(R.id.locationButton);
        locationButton.setTextColor(colorText);
        locationButton.setTextSize(sizeText);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

        //String adapter to apply the past attendees from the file
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                R.layout.attendee_layout, R.id.pastAttendee, FileHandler.findAttendees(this.getContext()));
        attendeeEdit.setAdapter(adapter);

        return view;
    }


    //Applies textviews to variables and passes those variables to a meeting which is
    //added to the text file via createMeeting()
    public void addMeeting(View view) {
        String title = this.titleEdit.getText().toString();
        String notes = this.notesEdit.getText().toString();
        String date = this.dateEdit.getText().toString();
        String time = this.timeEdit.getText().toString();
        String attend = this.attendeeEdit.getText().toString();
        Double lat = MapsActivity.lat;
        Double longi = MapsActivity.longi;
        FileHandler fh = new FileHandler(getContext());

        //Validation Checks
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
            //Add to meeting file
            String[] names = attend.split(" ");
            fh.createMeeting(title, notes, date, time, lat, longi, names);
        } else {
            Toast.makeText(this.getContext(), "Enter data", Toast.LENGTH_SHORT).show();
        }

        valid = false;

    }


}



