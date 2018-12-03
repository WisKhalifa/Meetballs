package com.example.wis.meetballs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View v = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.recycler_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView1.setText(mMeetings.get(position).getName());
        holder.mTextView2.setText(mMeetings.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1, mTextView2;

        public MyViewHolder(View v) {
            super(v);
            mTextView1 = v.findViewById(R.id.meetName);
            mTextView2 = v.findViewById(R.id.meetDate);
        }
    }
}
