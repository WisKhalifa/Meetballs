package com.example.wis.meetballs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<String> mMeetings;


    public RecyclerAdapter(List<String> meetings) {
        this.mMeetings = meetings;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.fragment_home, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mMeetings.get(position));
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.Test);
        }
    }
}
