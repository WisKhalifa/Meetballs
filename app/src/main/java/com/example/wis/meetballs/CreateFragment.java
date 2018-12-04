package com.example.wis.meetballs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class CreateFragment extends Fragment implements OnMapReadyCallback {


    protected EditText titleEdit, notesEdit, dateEdit, timeEdit;
    GoogleMap mMap;
    MapView mMapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);

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
                showMap(view, savedInstanceState);
            }
        });



        return view;
    }


    public void showMap(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        LatLng coFo = new LatLng(51.619543, -3.878634);
        mMap.addMarker(new MarkerOptions().position(coFo).title("Computational Foundry"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coFo));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions marker = new MarkerOptions()
                        .position(point)
                        .title("New Marker Point");
                mMap.addMarker(marker);
                Toast.makeText(getContext(), point.latitude + " " + point.longitude, Toast.LENGTH_LONG).show();
            }

        });
    }


    public void addMeeting(View view) {
        String title = this.titleEdit.getText().toString();
        String notes = this.notesEdit.getText().toString();
        String date = this.dateEdit.getText().toString();
        String time = this.timeEdit.getText().toString();
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
            fh.createMeeting(title, notes, date, time);
        } else {
            Toast.makeText(this.getContext(), "Enter data", Toast.LENGTH_SHORT).show();
        }

        valid = false;

    }



}



