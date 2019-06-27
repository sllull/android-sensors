package com.sllull.lightsensortest.Adapters;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sllull.lightsensortest.Domain.Sensors;
import com.sllull.lightsensortest.R;

import java.util.ArrayList;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {

    private ArrayList<Sensors> sensors;

    public SensorAdapter (ArrayList<Sensors> sensors){
        this.sensors = sensors;
    }

    @NonNull
    @Override
    public SensorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sensor_item, viewGroup, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull SensorAdapter.ViewHolder viewHolder, int i) {
        Sensors sens = sensors.get(i);
        viewHolder.setup(sens);
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Sensor sens;
        public TextView sensorTitle;
        public TextView sensorValue;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sensorTitle = itemView.findViewById(R.id.sensor_title);
            sensorValue = itemView.findViewById(R.id.sensor_value);

        }

        public void setup(final Sensors sens) {
            sensorTitle.setText(sens.getTitle());
            sensorValue.setText(sens.getValue());

        }
    }
}
