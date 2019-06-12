package com.sllull.lightsensortest.Domain;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class Sensors implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor mLight;
    private String sensorValue;
    private String sensorTitle;

    public Sensors (int type, SensorManager sensorManager){
        //type = Sensor.TYPE_LIGHT
        this.sensorTitle = " "+type;
        this.sensorManager = sensorManager;
        mLight = sensorManager.getDefaultSensor(type);
    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.

        sensorValue = ""+event.values[0];
        // Do something with this sensor value.
    }

    public String getTitle() {
        return sensorTitle;
    }

    public String getValue() {
        return sensorValue;
    }
}