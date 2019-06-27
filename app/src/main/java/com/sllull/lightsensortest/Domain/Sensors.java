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


public class Sensors  {
    private int sensorValue;
    private String sensorTitle;

    public Sensors (int type, String title, int value){
        //type = Sensor.TYPE_LIGHT
        this.sensorTitle = " "+type;
        this.sensorTitle = title;
        this.sensorValue = value;
    }

    public String getTitle() {
        return sensorTitle;
    }

    public int getValue() {
        return sensorValue;
    }
}