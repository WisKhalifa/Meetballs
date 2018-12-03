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

import java.util.List;


public class HomeFragment extends Fragment {


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

        List<Meeting> m;
        FileHandler fh = new FileHandler(getContext());
        m = fh.displayMeeting(getContext());
        mAdapter = new RecyclerAdapter(getContext(), m);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        return view;
    }



}
