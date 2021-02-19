package com.example.flyaircraft;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class AirCraft {
    private float x;
    private float y;
    private final Paint paint = new Paint();

    public AirCraft(){
        paint.setColor(Color.BLACK);
    }


    public void onDraw(Canvas canvas) {
        int width = 50;
        canvas.drawRect(x- width,y+ width,x+ width,y- width,paint);
    }

    public void moveAir(float x) {
        double speed = 5;
        this.x += x * speed;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
    public void setPosition(float x){
        this.x = x;
    }

    public float getX(){
        return this.x;
    }
}
