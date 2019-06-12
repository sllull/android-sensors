package com.sllull.lightsensortest.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sllull.lightsensortest.Fragments.SensorFragment;
import com.sllull.lightsensortest.R;

class SensorActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        this.fm = getSupportFragmentManager();

        Fragment bf = this.fm.findFragmentById(R.id.sensor_list);
        if(bf == null){
            FragmentTransaction ft = this.fm.beginTransaction();
            SensorFragment sf = SensorFragment.newInstance();
            ft.add(R.id.sensor_list,sf);
            ft.commit();
        }

       // new lskdfslkjf(getSys)
    }
}
