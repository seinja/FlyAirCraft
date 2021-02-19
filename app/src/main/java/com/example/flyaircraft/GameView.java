package com.example.flyaircraft;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements SensorEventListener {
    private final AirCraft airCraft = new AirCraft();
    private boolean isInit = false;




    public GameView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(34);
        SensorManager sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
        airCraft.setPosition(getWidth() >> 1, (float) (getHeight()* 0.9));
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        if(!isInit){
            airCraft.setPosition(getWidth() >> 1, (float) (getHeight()* 0.9));
            isInit = true;
        }
        canvas.drawColor(Color.rgb(0, 255, 247));
        airCraft.onDraw(canvas);
        invalidate();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getX() > 400) {
            Intent intent = new Intent(getContext(), ScoreActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Activity parentActivity = ((Activity) getContext());
            parentActivity.startActivity(intent);
            parentActivity.finish();
        } else {
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Activity parentActivity = ((Activity) getContext());
            parentActivity.startActivity(intent);
            parentActivity.finish();
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;
        if(mySensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];

            if(x != .5f && x != -.5f){
                if(airCraft.getX() > 0 && airCraft.getX() < getWidth()){
                    airCraft.moveAir(-x);
                }else{
                    if(airCraft.getX() < 0){
                        airCraft.setPosition(airCraft.getX() + 5);
                    }else{
                        airCraft.setPosition(airCraft.getX() - 5);
                    }
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
