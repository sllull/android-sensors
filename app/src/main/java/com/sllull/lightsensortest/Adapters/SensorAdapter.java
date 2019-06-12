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

    private ArrayList<Sensors> data;
    private Context context;
    private SensorManager sensorManager;

    public SensorAdapter (ArrayList<Sensors> data, Context context, SensorManager sensorManager){
        this.data = data;
        this.context =  context;
        this.sensorManager = sensorManager;
    }

    @NonNull
    @Override
    public SensorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_sensor, viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull SensorAdapter.ViewHolder viewHolder, int i) {
        Sensors sens = data.get(i);
        viewHolder.setup(sens, context);
    }

    @Override
    public int getItemCount() {
        return data.size();
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

        public void setup(final Sensors sens, final Context context) {
            sensorTitle.setText(sens.getTitle());
            sensorValue.setText(sens.getValue());

        }
    }
}
