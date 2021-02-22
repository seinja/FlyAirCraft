package com.example.flyaircraft;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Score {
    private int score = 0;
    private final Paint paint;


    public Score(){
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(120);
    }

    public void addScore(int score){
        this.score += score;
    }

    public void onDraw(Canvas canvas){
        float x = (float) (canvas.getWidth() * 0.1);
        float y = (float) (canvas.getHeight() * 0.1);

        canvas.drawText(String.valueOf(score), x, y,paint);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
