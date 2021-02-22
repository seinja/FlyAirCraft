package com.example.flyaircraft.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.flyaircraft.AirCraft;


// Класс пули
public class Bullet extends CollisionObject {

    // Кординаты и кисть
    private float x;
    private float y;
    private final Paint paint = new Paint();


    // Инциализация полей
    public Bullet(float x, float y) {
        super(x,y,25f);
        this.x = x;
        this.y = y;
        paint.setColor(Color.YELLOW);

    }


    // Отрисовка пули
    public void onDraw(Canvas canvas) {
        int radius = 25;
        canvas.drawCircle(this.x, this.y, radius, paint);
    }

    // Перемещение пули в простаранстве вверх
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
