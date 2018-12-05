package com.example.wis.meetballs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;


public class CreateFragment extends Fragment {


    protected EditText titleEdit, notesEdit, dateEdit, timeEdit;
    static LatLng coord;

    GoogleMap mMap;
    MapView mMapView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);

        final Intent i = new Intent(getContext(), MapsActivity.class);

        titleEdit = view.findViewById(R.id.MeetingTitle);
        notesEdit = view.findViewById(R.id.MeetingNotes);
        dateEdit = view.findViewById(R.id.MeetingDate);
        timeEdit = view.findViewById(R.id.MeetingTime);


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

                i.getDoubleExtra("LATIUDE", MapsActivity.lat);
                i.getDoubleExtra("LONGITUDE", MapsActivity.longi);
                System.out.println("lat" + MapsActivity.lat);
                System.out.println("long" + MapsActivity.longi);

            }
        });


        return view;
    }




    public void addMeeting(View view) {
        String title = this.titleEdit.getText().toString();
        String notes = this.notesEdit.getText().toString();
        String date = this.dateEdit.getText().toString();
        String time = this.timeEdit.getText().toString();
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

        if (valid) {
            fh.createMeeting(title, notes, date, time, lat, longi);
        } else {
            Toast.makeText(this.getContext(), "Enter data", Toast.LENGTH_SHORT).show();
        }

        valid = false;

    }



}



