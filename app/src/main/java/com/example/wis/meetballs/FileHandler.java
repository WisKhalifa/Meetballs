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


    public FileHandler(Context context) {
        this.context = context;
    }


    public static List<Meeting> displayMeeting(Context c) {
        List<Meeting> meeting = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(c.openFileInput("meetings.txt"));
            BufferedReader r = new BufferedReader(inputStreamReader);


            Meeting m = null;
            String appendText = "";
            while ((appendText = r.readLine()) != null) {

                String[] ms = appendText.split(",");
                if (ms.length > 3) {
                    //Location l = new Location(ms[3]);
                    m = new Meeting(ms[0], ms[2]);
                    m.setNotes(ms[1]);

                    meeting.add(m);
                }


            }
            //System.out.println(Arrays.toString(meeting.toArray()));
            r.close();

        } catch (IOException e) {

        }

        return meeting;
    }

    public void createMeeting(String title, String notes, String date, String time) {


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
            outputStreamWriter.write("\n");
            outputStreamWriter.close();


        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        //System.out.println("YEET");


    }


}
