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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CreateFragment extends Fragment {

    Button mButton;
    EditText Title, Notes, Date, Time;
    Writer out = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButton = mButton.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMeeting(view);
                System.out.println("Click");
            }
        });

    }

    public void createMeeting(View v) {
        Title = Title.findViewById(R.id.MeetingTitle);
        Notes = Notes.findViewById(R.id.MeetingNotes);
        Date = Date.findViewById(R.id.MeetingDate);
        Time = Time.findViewById(R.id.MeetingTime);

        System.out.println(Title);
        System.out.println(Notes);
        System.out.println(Date);
        System.out.println(Time);


        try {
            File f = new File("meetings.txt");
            if (!f.exists()) {
                f.createNewFile();
            } else {
                Toast.makeText(getContext(), "File already exists :(", Toast.LENGTH_LONG).show();
            }

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
            out.write(Title.getText().toString());
            out.write(Notes.getText().toString());
            out.write(Date.getText().toString());
            out.write(Time.getText().toString());

            Toast.makeText(getContext(), "Meeting Created!", Toast.LENGTH_LONG).show();


        } catch (IOException ex) {
            Toast.makeText(getContext(), "Could not create meeting :(", Toast.LENGTH_LONG).show();
        } finally {
            try {
                out.close();
            } catch (Exception ex) {
            }
        }

    }
}



