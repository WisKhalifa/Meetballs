package com.example.wis.meetballs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Meeting> mMeetings;
    private Context context;

    static int colorText = Color.BLACK;
    static int sizeText = 26;


    public RecyclerAdapter(Context context, List<Meeting> mMeetings) {
        this.context = context;
        this.mMeetings = mMeetings;

    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate
        //(R.layout.recycler_layout, parent, false);
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.recycler_layout, parent, false);


        MyViewHolder vh = new MyViewHolder(v, mMeetings);



        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Meeting meeting = mMeetings.get(position);
        holder.mTextView1.setText(meeting.getName());

        holder.mTextView2.setText(meeting.getDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                builder.setTitle("Meeting Details");
                LayoutInflater lF = LayoutInflater.from(context);
                final View mFormView = lF.inflate(R.layout.activity_alert_dialog_custom_view_display_meeting, null);
                builder.setView(mFormView);

                TextView mTitleView = mFormView.findViewById(R.id.dialogMeetingTle);
                mTitleView.setText(meeting.getName());

                TextView mNoteView = mFormView.findViewById(R.id.dialogMeetingNotes);
                mNoteView.setText(meeting.getNotes());

                TextView mDateView = mFormView.findViewById(R.id.dialogMeetingDate);
                mDateView.setText(meeting.getDate());

                TextView mTimeView = mFormView.findViewById(R.id.dialogMeetingTime);
                mTimeView.setText(meeting.getTime());

                TextView mLatView = mFormView.findViewById(R.id.dialogMeetingLat);
                mLatView.setText(Double.toString(meeting.getLat()));

                TextView mLongView = mFormView.findViewById(R.id.dialogMeetingLong);
                mLongView.setText(Double.toString(meeting.getLongi()));

                TextView mAttendView = mFormView.findViewById(R.id.dialogMeetingAttend);
                String atts = "";
                for (String s : meeting.getAttendees()) {
                    atts += s + "; ";
                }
                mAttendView.setText(atts);

                mTitleView.setTextColor(colorText);
                mTitleView.setTextSize(sizeText);
                mNoteView.setTextColor(colorText);
                mNoteView.setTextSize(sizeText);
                mDateView.setTextColor(colorText);
                mDateView.setTextSize(sizeText);
                mTimeView.setTextColor(colorText);
                mTimeView.setTextSize(sizeText);
                mLatView.setTextColor(colorText);
                mLatView.setTextSize(sizeText);
                mLongView.setTextColor(colorText);
                mLongView.setTextSize(sizeText);
                mAttendView.setTextColor(colorText);
                mAttendView.setTextSize(sizeText);


                Button mLocView = mFormView.findViewById(R.id.meetingLocation);
                mLocView.setTextColor(colorText);
                mLocView.setTextSize(sizeText);

                mLocView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MapsActivity.lat = meeting.getLat();
                        MapsActivity.longi = meeting.getLongi();
                        Intent inti = new Intent(view.getContext(), MapsActivity.class);
                        context.startActivity(inti);
                    }
                });


                builder.create();
                builder.show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1, mTextView2;


        private List<Meeting> currentMeeting;

        public MyViewHolder(final View v, final List<Meeting> m) {
            super(v);

            mTextView1 = v.findViewById(R.id.meetName);
            mTextView2 = v.findViewById(R.id.meetDate);

            mTextView1.setTextColor(colorText);
            mTextView1.setTextSize(sizeText);
            mTextView2.setTextColor(colorText);
            mTextView2.setTextSize(sizeText);
            currentMeeting = m;


        }


    }


}
