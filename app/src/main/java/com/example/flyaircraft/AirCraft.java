package com.example.flyaircraft;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.flyaircraft.Objects.Bullet;

public class AirCraft {
    private float x;
    private float y;
    private final Paint paint = new Paint();
    private final Bitmap character;
    private final Bullet bullet;

    // Конструктор с установкой цвета нашего коробля
    public AirCraft(Context context) {
        paint.setColor(Color.BLACK);
        Bitmap source = BitmapFactory.decodeResource(context.getResources(), R.drawable.some);
        character = Bitmap.createScaledBitmap(source, source.getWidth() / 10, source.getHeight() / 10, false);

        bullet = new Bullet(x, y);

    }


    // Метод отрисовки нашего коробля по кординатам
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(character, x, y, paint);
        bullet.onDraw(canvas);
        bullet.fly(this);
    }

    // Передвижение коробля в зависимости от полученной кординаты акселерометра помноженой на скорость
    public void moveAir(float x) {
        double speed = 5;
        this.x += x * speed;
    }

    // Установка начальной позиции для инциализации
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Перемещение коробля если он собираеться выйти за границы
    public void setPosition(float x) {
        this.x = x;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }


}
