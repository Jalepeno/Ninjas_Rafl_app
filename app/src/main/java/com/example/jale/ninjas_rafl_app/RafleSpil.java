package com.example.jale.ninjas_rafl_app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Jale on 22-Dec-14.
 */
public class RafleSpil extends Activity implements SensorEventListener{
    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;
    long gameEnd;
    ImageView die,cup;

    public RafleSpil() {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameboard);
        gameEnd = System.currentTimeMillis()+this.getIntent().getLongExtra("timeSet",1000*60*5);
        die = (ImageView) findViewById(R.id.imgDie);
        cup = (ImageView) findViewById(R.id.imgRaflCup);
        cup.setImageResource(R.drawable.RafleCup);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
    }

}
