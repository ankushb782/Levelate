package com.example.levelate.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class TriangleAndArc extends View {

    private int measuredWidth, measuredHeight;
    private float density;
    private float a1Degrees;
    private float textHeight;
    private double a1Radians;

    private Paint mLinePaint, mPointPaint, mTextPaint, mCirclePaint;
    private DashPathEffect dashedEffect;
    private PointF p1, p2, m, c;


    public TriangleAndArc(Context context) {
        super(context);
        init(context);
    }

    public TriangleAndArc(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TriangleAndArc(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
        init(context);
    }

    private void init(Context ctx) {

        p1 = new PointF();
        p2 = new PointF();
        c = new PointF();
        m = new PointF();

        Resources res = ctx.getResources();
        density = res.getDisplayMetrics().density;

        a1Degrees = 36.0f;
        a1Radians = Math.toRadians(a1Degrees);

        dashedEffect = new DashPathEffect(new float[]{5, 5}, 1.0f);
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeJoin(Paint.Join.ROUND);
        mLinePaint.setStrokeWidth(2 * density);
        mLinePaint.setColor(Color.BLACK);
        //mPaint.setPathEffect(dashedEffect);

        mPointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPointPaint.setStyle(Paint.Style.FILL);
        mPointPaint.setColor(Color.RED);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(10 * density);
        mTextPaint.setTypeface(Typeface.create("Roboto-Thin", Typeface.BOLD));
        mTextPaint.setColor(Color.RED);

        if(!isInEditMode()) {
            // Shadow layer is not supported in preview mode and android studio makes an ugly warning about it!
            mTextPaint.setShadowLayer(0.1f, 0, 1, Color.GRAY);
        }

        textHeight = Math.abs(mTextPaint.descent() + mTextPaint.ascent());

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.BLUE);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(density);
    }

    // Square a number
    private double sq(double a) {
        return a * a;
    }

    private void drawIncenterAndExcenter(PointF A, PointF B, PointF C, Canvas canvas) {
        double a = Math.sqrt((B.x - C.x) * (B.x - C.x) + (B.y - C.y) * (B.y - C.y));
        double b = Math.sqrt((A.x - C.x) * (A.x - C.x) + (A.y - C.y) * (A.y - C.y));
        double c = Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));

        double perimeter = a + b + c;
        double s = 0.5 * perimeter;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        // Inscribed Circle
        double iRadius = area / s;
        PointF iCenter = new PointF();
        iCenter.x = (float) ((a * A.x + b * B.x + c * C.x) / (perimeter));
        iCenter.y = (float) ((a * A.y + b * B.y + c * C.y) / (perimeter));

        // Circumscribed Circle
        PointF cCenter = new PointF();
        double cRadius = (a * b * c) / (4.0 * area);
        double D = 2 * (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y));
        double sqA = sq(A.x) + sq(A.y);
        double sqB = sq(B.x) + sq(B.y);
        double sqC = sq(C.x) + sq(C.y);
        cCenter.x = (float) ((sqA * (B.y - C.y) + sqB * (C.y - A.y) + sqC * (A.y - B.y)) / D);
        cCenter.y = (float) ((sqA * (C.x - B.x) + sqB * (A.x - C.x) + sqC * (B.x - A.x)) / D);

        // Draw
        canvas.drawCircle(iCenter.x, iCenter.y, density * 5, mPointPaint);
        canvas.drawCircle(iCenter.x, iCenter.y, (float) iRadius, mCirclePaint);
        canvas.drawText("I", iCenter.x - mTextPaint.measureText("I") * 0.5f, iCenter.y - textHeight - 2 * density, mTextPaint);


        canvas.drawCircle(cCenter.x, cCenter.y, density * 5, mPointPaint);
        canvas.drawCircle(cCenter.x, cCenter.y, (float) cRadius, mCirclePaint);
        canvas.drawText("E", cCenter.x - mTextPaint.measureText("E") * 0.5f, cCenter.y - textHeight - 2 * density, mTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
        //Log.d(TAG, "Height: " + measuredHeight + " Width: " + measuredWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (measuredHeight <= 0 || measuredWidth <= 0) {
            // Not much we can draw...  :/
            return;
        }

        // Orientation independent drawing
        int width = (measuredWidth > measuredHeight) ? measuredWidth : measuredHeight;
        int height = (width == measuredWidth) ? measuredHeight : measuredWidth;

        // Define points
        p1.x = width * 0.7f;
        p1.y = height * 0.2f - 20;

        p2.x = width * 0.85f;
        p2.y = 2 * height / 3.0f - 20;

        float dx = p2.x - p1.x;
        float dy = p2.y - p1.y;

        // l1 is half the length of the line from p1 to p2
        double l = Math.sqrt(dx * dx + dy * dy);
        double l1 = l / 2.0;

        // Center of the circle
        double h = l1 / (Math.tan(a1Radians / 2.0));

        // Radius of the circle
        double r = l1 / (Math.sin(a1Radians / 2.0));

        // a2 is the angle at which L intersects the x axis
        double a2 = Math.atan2(dy, dx);

        // a3 is the angle at which H intersects the x axis
        double a3 = (Math.PI / 2.0) - a2;

        // m is the midpoint of the line from e1 to e2
        m.x = (p1.x + p2.x) / 2.0f;
        m.y = (p1.y + p2.y) / 2.0f;

        // c is the the center of the circle
        c.x = (float) (m.x - (h * Math.cos(a3)));
        c.y = (float) (m.y + (h * Math.sin(a3)));

        // rect is the square RectF that bounds the "oval"
        RectF oval = new RectF((float) (c.x - r), (float) (c.y - r), (float) (c.x + r), (float) (c.y + r));

        // a4 is the starting sweep angle
        double rawA4 = Math.atan2(p1.y - c.y, p1.x - c.x);
        float a4 = (float) Math.toDegrees(rawA4);

        // Draw lines
        canvas.drawLine(p1.x, p1.y, p2.x, p2.y, mLinePaint);
        canvas.drawLine(c.x, c.y, p1.x, p1.y, mLinePaint);
        canvas.drawLine(c.x, c.y, p2.x, p2.y, mLinePaint);
        canvas.drawLine(c.x, c.y, m.x, m.y, mLinePaint);

        // Draw arc
        mLinePaint.setPathEffect(dashedEffect);
        canvas.drawArc(oval, a4, a1Degrees, false, mLinePaint);

        // Draw dots
        canvas.drawCircle(p1.x, p1.y, density * 5, mPointPaint);
        canvas.drawCircle(p2.x, p2.y, density * 5, mPointPaint);
        canvas.drawCircle(m.x, m.y, density * 5, mPointPaint);
        canvas.drawCircle(c.x, c.y, density * 5, mPointPaint);

        // Draw text
        float halfOfTextHeight = textHeight * 0.5f; // We need an offset of a half
        canvas.drawText("p1", p1.x + density * 7, p1.y + halfOfTextHeight, mTextPaint);
        canvas.drawText("p2", p2.x + density * 7, p2.y + halfOfTextHeight, mTextPaint);
        canvas.drawText("m", m.x + density * 7, m.y + halfOfTextHeight, mTextPaint);
        canvas.drawText("c", c.x - mTextPaint.measureText("c") - density * 7, c.y + halfOfTextHeight, mTextPaint);

        drawIncenterAndExcenter(p1, p2, c, canvas);

    }
}
