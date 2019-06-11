package com.sllull.lightsensortest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SensorFragment extends Fragment {

    private TextView sensotTitle;
    private TextView sensotValue;

    public SensorFragment (){
        //Require empty public constructor
    }

    public static SensorFragment newInstance (){

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
        return v;
    }
}
