package com.example.flyaircraft.Objects;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.flyaircraft.R;

public class Background {

    Bitmap source;
    Bitmap origin;

    public Background(Context context){
        source = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
        origin = Bitmap.createScaledBitmap(source,source.getWidth(),source.getHeight()*2,false);

    }

    public void onDraw(Canvas canvas){
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        canvas.drawBitmap(origin,0,0,paint);

    }
}
