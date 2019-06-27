package com.sllull.lightsensortest.Activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.sllull.lightsensortest.Adapters.SensorAdapter;
import com.sllull.lightsensortest.Domain.Sensors;
import com.sllull.lightsensortest.R;

import java.util.ArrayList;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;

    private Sensor mSensorLight;
    private Sensor mSensorAccelerometer;
    private Sensor mSensorGyroscope;
    private Sensor mSensorRotation;

    //private RecyclerView sensorList;
    //private ArrayList<Sensors> sensors;
    //private SensorAdapter mSensorAdapter;

   // private SensorEventListener mSensorListener;

    private TextView mTextSensorLight;
    private TextView mTextSensorAccelerometer;
    private TextView mTextSensorGyroscope;
    private TextView mTextSensorRotation;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        //sensorList = findViewById(R.id.sensor_list);
        mTextSensorLight = findViewById(R.id.lightSensorValue);
        mTextSensorAccelerometer= findViewById(R.id.accelerometerSensorValue);
        mTextSensorGyroscope= findViewById(R.id.gyroscopeSensorValue);
        mTextSensorRotation= findViewById(R.id.rotationSensorValue);


        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        //sensorList.setLayoutManager(mLayoutManager);

        //mSensorAdapter = new SensorAdapter(sensors);
        //sensorList.setAdapter(mSensorAdapter);

        mSensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);

        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensorRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mSensorAccelerometer != null) {
            mSensorManager.registerListener(this, mSensorAccelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorLight != null) {
            mSensorManager.registerListener(this, mSensorLight,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorGyroscope != null) {
            mSensorManager.registerListener(this, mSensorGyroscope,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorRotation != null) {
            mSensorManager.registerListener(this, mSensorRotation,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];

        switch (sensorType) {
            // Event came from the light sensor.
            case Sensor.TYPE_LIGHT:
                // Set the light sensor text view to the light sensor string
                // from the resources, with the placeholder filled in.

                mTextSensorLight.setText(currentValue + "");// currentValue));

                break;
            case Sensor.TYPE_ACCELEROMETER:
                // Set the light sensor text view to the light sensor string
                // from the resources, with the placeholder filled in.
                mTextSensorAccelerometer.setText(currentValue + "");

                break;
            case Sensor.TYPE_GYROSCOPE:
                // Set the light sensor text view to the light sensor string
                // from the resources, with the placeholder filled in.

                mTextSensorGyroscope.setText(currentValue + "");

                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                // Set the light sensor text view to the light sensor string
                // from the resources, with the placeholder filled in.

                mTextSensorRotation.setText(currentValue + "");

                break;
            default:
                // do nothing
        }
    }

    /**
     * Abstract method in SensorEventListener.  It must be implemented, but is
     * unused in this app.
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
