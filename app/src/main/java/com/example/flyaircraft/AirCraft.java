package com.example.flyaircraft;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class AirCraft {
    private float x;
    private float y;
    private final Paint paint = new Paint();

    // Конструктор с установкой цвета нашего коробля
    public AirCraft(){
        paint.setColor(Color.BLACK);
    }


    // Метод отрисовки нашего коробля по кординатам
    public void onDraw(Canvas canvas) {
        int width = 50;
        canvas.drawRect(x- width,y+ width,x+ width,y- width,paint);
    }

    // Передвижение коробля в зависимости от полученной кординаты акселерометра помноженой на скорость
    public void moveAir(float x) {
        double speed = 5;
        this.x += x * speed;
    }

    // Установка начальной позиции для инциализации
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
    // Перемещение коробля если он собираеться выйти за границы
    public void setPosition(float x){
        this.x = x;
    }

    public float getX(){
        return this.x;
    }
}
