package com.example.flyaircraft.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.flyaircraft.AirCraft;

public class Bullet {
    private float x;
    private float y;
    private final Paint paint = new Paint();


    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        paint.setColor(Color.YELLOW);

    }

    public void onDraw(Canvas canvas) {
        int radius = 25;
        canvas.drawCircle(this.x, this.y, radius, paint);
    }

    public void fly(AirCraft airCraft) {
        if (y > 0) {
            double bulletSpeed = 30;
            y -= bulletSpeed;
        } else {
            x = airCraft.getX() + 145;
            y = airCraft.getY();
        }
    }


}
