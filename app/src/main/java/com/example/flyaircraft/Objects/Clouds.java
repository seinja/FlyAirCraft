package com.example.flyaircraft.Objects;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.flyaircraft.R;
// Облока
//Todo допилить это говно чтоб было с рандомными кординатами в пределе канваса
public class Clouds {

    private float x = 0;
    private float y = 0;
    private float startX;
    private float startY;
    // Наше пнг изображение облоков
    Bitmap source;
    Bitmap origin;

    //Инициализация нашего изображения
    public Clouds(Context context) {
        // Исходное изображение разрешение дохуя Х дохуя
        source = BitmapFactory.decodeResource(context.getResources(), R.drawable.clouds);
        // Тоже изображение умешьшеное в 10 раз
        origin = Bitmap.createScaledBitmap(source, source.getWidth() / 10, source.getHeight() / 10, false);
        setPos(12, 12);

    }

    // Отрисовка
    public void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        canvas.drawBitmap(origin, x, y, paint);
        fly();
    }

    // Функция полетв только уже вверх
    public void fly() {
        if (y < 2100) {
            double cloudSpeed = 15;
            y += cloudSpeed;
        } else {
            setPos(startX, startY);
        }

    }

    // Установка начальной позиции в будущем поменять и сделать рандомной
    public void setPos(float x, float y) {
        this.startX = x;
        this.startY = y;
        this.x = x;
        this.y = y;

    }
}
