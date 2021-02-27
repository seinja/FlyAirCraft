package com.example.flyaircraft.Objects;

import java.util.TimerTask;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Obstacle extends CollisionObject {
    private float x;
    private float y;
    private float w = 50;
    private Paint paint = new Paint();



    public Obstacle(float size) {
        super((int) size);
        paint.setColor(Color.BLACK);
    }

    public void onDraw(Canvas canvas){
        canvas.drawRect(x-w,y+w,x+w,y-w,paint);
        fall();

    }

    public void setPos(){
        this.y = -100;
        this.x = (float) (1 +(Math.random()*650));
    }

    private void fall(){
        if (y < 2100) {
            double cloudSpeed = 15;
            y += cloudSpeed;
        } else {
            setPos();
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    @Override
    public boolean onCollisionEnter(CollisionObject object) {
        return super.onCollisionEnter(object);
    }


}
