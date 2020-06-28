package com.example.levelate.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TimerCircle extends View {

    private Paint paint;
    private RectF rectF;

    // The point from where the color-fill animation will start.
    private static final int startingPointInDegrees = 270;
    // The point up-till which user wants the circle to be pre-filled.
    private float degreesUpTillPreFill = 0;

    public TimerCircle(Context context, AttributeSet attrs) {
        super(context, attrs);

        int strokeWidth = (int) convertDpIntoPixel(5);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);

        // Define the size of the circle
        rectF = new RectF(strokeWidth, strokeWidth,
                (int) convertDpIntoPixel(100) + strokeWidth,
                (int) convertDpIntoPixel(100) + strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Grey Circle - This circle will be there by default.
        paint.setColor(Color.parseColor("#d2d2d2"));
        canvas.drawCircle(rectF.centerX(), rectF.centerY(),
                (int) convertDpIntoPixel(50), paint);

        // Green Arc (Arc with max 360 angle) - This circle will be created as
        // time progresses.
        paint.setColor(Color.parseColor("#00ba8c"));
        canvas.drawArc(rectF, startingPointInDegrees, degreesUpTillPreFill,
                false, paint);
    }

    public float getDegreesUpTillPreFill() {
        return degreesUpTillPreFill;
    }

    public void setDegreesUpTillPreFill(float degreesUpTillPreFill) {
        this.degreesUpTillPreFill = degreesUpTillPreFill;
    }

    // Method to convert DPs into Pixels.
    private float convertDpIntoPixel(float dp) {
        float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
}