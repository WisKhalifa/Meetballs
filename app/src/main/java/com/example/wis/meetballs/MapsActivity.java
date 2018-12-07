package com.example.wis.meetballs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //Changable latitude and longitude variables
    public static double lat = 51.619543;
    public static double longi = -3.878634;
    private GoogleMap mMap;

    //Sets content view to mapview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //Sets up the mapview by adding a marker to the Computational Foundry, and allowing
    //user to add a marker by tapping their finger on that location
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        LatLng coFo = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(coFo).title("Computational Foundry"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(coFo));

        //Listener for user tap to add a marker there
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                mMap.clear();
                MarkerOptions marker = new MarkerOptions()
                        .position(point)
                        .title("New Marker Point");
                mMap.addMarker(marker);
                //Changes latitude and longitude to new marker location
                lat = (point.latitude);
                longi = (point.longitude);
                Toast.makeText(MapsActivity.this, point.latitude + " " + point.longitude, Toast.LENGTH_LONG).show();
            }

        });
    }
}
