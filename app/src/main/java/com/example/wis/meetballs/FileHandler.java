package com.example.wis.meetballs;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileHandler {


    private Context context;

    public FileHandler(Context context) {
        this.context = context;
    }


    public void createMeeting(String title, String notes, String date, String time) {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("meetings.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(title);
            outputStreamWriter.close();

        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        System.out.println("YEET");


    }

}
