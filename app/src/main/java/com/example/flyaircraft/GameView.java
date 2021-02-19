package com.example.flyaircraft;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameView  extends View {
    private Paint paint = new Paint();


    public GameView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.rgb(0, 255, 247));
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getX() > 400){
            Intent intent = new Intent(getContext(),ScoreActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Activity parentActivity  = ((Activity) getContext());
            parentActivity.startActivity(intent);
            parentActivity.finish();
        }else{
            Intent intent = new Intent(getContext(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Activity parentActivity  = ((Activity) getContext());
            parentActivity.startActivity(intent);
            parentActivity.finish();
        }
        return super.onTouchEvent(event);
    }
}
