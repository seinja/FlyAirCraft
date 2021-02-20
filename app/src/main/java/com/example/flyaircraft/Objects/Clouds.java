package com.example.flyaircraft.Objects;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.flyaircraft.R;

public class Clouds {
    private float x = 0;
    private float y = 0;
    private float startX;
    private float startY;
    Bitmap source;
    Bitmap origin;

    public Clouds(Context context) {
        source = BitmapFactory.decodeResource(context.getResources(), R.drawable.clouds);
        origin = Bitmap.createScaledBitmap(source, source.getWidth() / 15, source.getHeight() / 15, false);
        setPos(12, 12);

    }

    public void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        canvas.drawBitmap(origin, x, y, paint);
        fly();
    }

    public void fly() {
        if (y < 2100) {
            double cloudSpeed = 15;
            y += cloudSpeed;
        } else {
            setPos(startX, startY);
        }

    }

    public void setPos(float x, float y) {
        this.startX = x;
        this.startY = y;
        this.x = x;
        this.y = y;

    }
}
