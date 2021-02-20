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

import com.example.flyaircraft.Objects.Clouds;

public class GameView extends View implements SensorEventListener {
    private final AirCraft airCraft;
    private boolean isInit = false;
    private final Clouds[] clouds = new Clouds[2];


    // Конструктор класс
    public GameView(Context context) {
        super(context);
        // Работа с кистью(выбор цвета и т.д)
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(34);
        // Инициализация сенсрменеджера и самого сенсора типа акселерометр
        SensorManager sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Добавляем в сенсорменеджер наш сенсор акселерометр
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
        paint.setColor(Color.BLACK);
        clouds[0] = new Clouds(context);
        clouds[0].setPos(12, 12);
        clouds[1] = new Clouds(context);
        clouds[1].setPos(450, 100);

        // Устанавливаем начальное положение игрока
        airCraft = new AirCraft(context);
        airCraft.setPosition(getWidth() >> 1, (float) (getHeight() * 0.9));

    }


    // Отрисовка игрока на игровыом поле и игровое поле соответственно
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInit) {
            airCraft.setPosition(getWidth() >> 1, (float) (getHeight() * 0.85));
            isInit = true;
        }
        canvas.drawColor(Color.rgb(0, 255, 247));
        for (Clouds cloud : clouds) {
            cloud.onDraw(canvas);
        }
        airCraft.onDraw(canvas);

        // Перерисовка
        invalidate();
    }


    // Функция реагирующая на нажатие на экран левее середины переход к очкам, правее на начальную активность
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


    // Функция изменения положения нашего сенсора акселерометра
    @Override
    public void onSensorChanged(SensorEvent event) {
        // создаём обект сенсора и присваем ему сенсор который на передают
        Sensor mySensor = event.sensor;
        // Проверяем если тип сенсора акселерометр то берем переменную x в кординатак акселерометра
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];

            // Если нахлон больше установленных значений до передвигаем нашего игрока в направлении наклона
            if (x != .5f && x != -.5f) {
                if (airCraft.getX() > 0 && airCraft.getX() < getWidth()) {
                    airCraft.moveAir(-x);
                } else {
                    if (airCraft.getX() < 0) {
                        airCraft.setPosition(airCraft.getX() + 5);
                    } else {
                        airCraft.setPosition(airCraft.getX() - 5);
                    }
                }
            }
        }
    }

    // Функция изменения точности(пока не требуеться)
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
