package com.example.jayden.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by jayden on 8/10/15.
 */
public class CounterView extends View implements View.OnClickListener{
    private Paint paint;
    private Rect bounds;
    private int count;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(Color.YELLOW);
        paint.setTextSize(30);
        String text = String.valueOf(count);
        paint.getTextBounds(text, 0, text.length(), bounds);
        float width = bounds.width();
        float height = bounds.height();
        canvas.drawText(text, getWidth() / 2 - width / 2, getHeight() / 2 + height / 2, paint);
    }

    @Override
    public void onClick(View v) {
        count++;
        invalidate();
    }
}
