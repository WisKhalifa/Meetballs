package com.example.wis.meetballs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public List<String> mDs = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FragmentActivity c = getActivity();

        mRecyclerView = view.findViewById(R.id.MeetingList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        mRecyclerView.setLayoutManager(layoutManager);

        Button mButton;
        mButton = view.findViewById(R.id.ShowMeetingsButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMeetings(view);

            }
        });

        return view;
    }


    public void showMeetings(View view) {


        FileHandler fh = new FileHandler(getContext());
        mDs = fh.displayMeeting();
        mAdapter = new RecyclerAdapter(mDs);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }
}
