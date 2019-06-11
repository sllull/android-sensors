package com.sllull.lightsensortest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragmentManager = getSupportFragmentManager();
        Fragment fr = this.fragmentManager.findFragmentById(R.id.fragment_sensor);

        if(fr == null){
            FragmentTransaction ft = this.fragmentManager.beginTransaction();
            SensorFragment sensorFragment = SensorFragment.newInstance();
            ft.add(R.id.fragment_sensor,sensorFragment);
        }
    }
}
