package com.sllull.lightsensortest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textValues;
    private SensorManager mSensorManager;
    private Sensor mSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValues = findViewById(R.id.value_text);

        mSensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)!=null){
            mSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }else{
            //Failure
            Log.d("sllull2","No light sensor available");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mSensor!=null){
            mSensorManager.registerListener(this,
                    mSensor,
                    SensorManager.SENSOR_DELAY_NORMAL
            );
        }
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float lux = event.values[0];
        String oldvalues = textValues.getText().toString();
        textValues.setText(lux + "\n" + oldvalues );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
