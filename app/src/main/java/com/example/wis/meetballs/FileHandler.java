package com.example.wis.meetballs;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {


    private Context context;


    public FileHandler(Context context) {
        this.context = context;
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
        System.out.println("YEET");


    }

    public List<String> displayMeeting() {
        List<String> meeting = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.openFileInput("meetings.txt"));
            BufferedReader r = new BufferedReader(inputStreamReader);
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line).append('\n');
                meeting.add(line);
            }
            System.out.println(Arrays.toString(meeting.toArray()));
            r.close();

        } catch (IOException e) {

        }

        return meeting;
    }


}
