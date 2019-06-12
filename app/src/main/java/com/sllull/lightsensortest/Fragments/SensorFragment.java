package com.sllull.lightsensortest.Fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import com.sllull.lightsensortest.Adapters.SensorAdapter;
import com.sllull.lightsensortest.Domain.Sensors;
import com.sllull.lightsensortest.R;

import java.util.ArrayList;

public class SensorFragment extends Fragment {

    private ArrayList<Sensors> dataset;
    private RecyclerView sensorList;
    private SensorAdapter sensorAdapter;

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
        View v = inflater.inflate(R.layout.sensor_item,container,false);
        sensorList = v.findViewById(R.id.sensor_list);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        sensorList.setLayoutManager(mLayoutManager);

        if(dataset == null){
            dataset = prepareDummySensors();
        }

        sensorAdapter = new SensorAdapter(dataset, getContext(),(SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE));
        sensorList.setAdapter(sensorAdapter);
        return v;
    }

    private ArrayList<Sensors> prepareDummySensors() {
        ArrayList<Sensors> sensorsList = null;
        sensorsList.add(new Sensors(Sensor.TYPE_LIGHT, (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE)));
        return sensorsList;
    }
}
