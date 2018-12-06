package com.example.wis.meetballs;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private Context context;

    //Generic constructor
    public FileHandler(Context context) {
        this.context = context;
    }

    //Adds attendees to a list of strings to be added to attendee view
    public static List<String> findAttendees(Context c) {
        List<String> names = new ArrayList<>();
        List<Meeting> meets = displayMeeting(c);

        for (Meeting m : meets) {
            for (String s : m.getAttendees()) {
                names.add(s);
            }
        }
        return names;
    }

    //Take meetings from file and apply them to a list of meeting objects
    public static List<Meeting> displayMeeting(Context c) {
        List<Meeting> meeting = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(c.openFileInput("meetings.txt"));
            BufferedReader r = new BufferedReader(inputStreamReader);

            Meeting m = null;
            String appendText = "";
            while ((appendText = r.readLine()) != null) {
                //Have to create a meeting object first then add that object to meeting list
                //This ends when there are no more lines to read in
                String[] ms = appendText.split(",");
                if (ms.length > 3) {
                    m = new Meeting(ms[0], ms[2]);
                    m.setNotes(ms[1]);
                    m.setTime(ms[3]);
                    m.setLat(Double.parseDouble(ms[4]));
                    m.setLongi(Double.parseDouble(ms[5]));
                    String[] names = ms[6].split(";");
                    for (String s : names) {
                        m.getAttendees().add(s);
                    }
                    meeting.add(m);
                }
            }
            r.close();
        } catch (IOException e) {
        }
        return meeting;
    }

    //Creates a meeting object given the parameters and writes to file with a , delimiter, ends with
    // a new line
    public void createMeeting(String title, String notes, String date, String time
            , double lat, double longi, String[] attendees) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput
                    ("meetings.txt", Context.MODE_APPEND));
            outputStreamWriter.write(title);
            outputStreamWriter.write(",");
            outputStreamWriter.write(notes);
            outputStreamWriter.write(",");
            outputStreamWriter.write(date);
            outputStreamWriter.write(",");
            outputStreamWriter.write(time);
            outputStreamWriter.write(",");
            outputStreamWriter.write(Double.toString(lat));
            outputStreamWriter.write(",");
            outputStreamWriter.write(Double.toString(longi));
            outputStreamWriter.write(",");
            for (String s : attendees) {
                outputStreamWriter.write(s + ";");
            }
            outputStreamWriter.write("\n");
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
