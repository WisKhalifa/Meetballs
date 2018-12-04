package com.example.wis.meetballs;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Meeting> mMeetings;
    private Context context;


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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);
        holder.mTextView1.setText(meeting.getName());

        holder.mTextView2.setText(meeting.getDate());

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1, mTextView2;
        LinearLayout row_linearlayout;
        RecyclerView rv2;
        private List<Meeting> currentMeeting;

        public MyViewHolder(final View v, List<Meeting> m) {
            super(v);
            mTextView1 = v.findViewById(R.id.meetName);
            mTextView2 = v.findViewById(R.id.meetDate);
            //row_linearlayout = v.findViewById(R.id.linrlayout);
            //rv2 = v.findViewById(R.id.MeetingList);

            currentMeeting = m;


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("test")
                            .show();
                }
            });

        }




    }
}
