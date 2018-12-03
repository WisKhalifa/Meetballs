package com.example.wis.meetballs;

import java.io.Serializable;
import java.util.ArrayList;

public class Meeting implements Serializable {

    private String name, notes, location;
    private ArrayList<String> attendees;
    private Double lat, longi;
    private String date;


    public Meeting(String name, String date) {
        this.name = name;
        this.date = date;
        attendees = new ArrayList<>();
        notes = "test";
        //lat = loc.getLatitude();

        //longi = loc.getLongitude();
        //location = loc.getProvider();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<String> attendees) {
        this.attendees = attendees;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
