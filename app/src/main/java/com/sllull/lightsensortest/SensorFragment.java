package com.sllull.lightsensortest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class SensorFragment extends Fragment {

    private TextView sensotTitle;
    private TextView sensotValue;
    private RecyclerView sensorList;

    public SensorFragment (){
        //Require empty public constructor
    }

    public static SensorFragment newInstance (){
        return new SensorFragment();
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensor,container,false);
        sensotTitle = v.findViewById(R.id.sensor_title);
        sensotValue = v.findViewById(R.id.sensor_value);
//        Bundle args = getArguments();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        sensorList.setLayoutManager(mLayoutManager);

        return v;
    }
}
