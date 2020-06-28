package com.example.levelate.util;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TimerCircleAngleAnimation extends Animation {

    private TimerCircle circle;

    private float startingAngle;
    private float endingAngle;

    public TimerCircleAngleAnimation(TimerCircle circle, int endingAngle) {
        this.startingAngle = circle.getDegreesUpTillPreFill();
        this.endingAngle = endingAngle;
        this.circle = circle;
    }

    @Override
    protected void applyTransformation(float interpolatedTime,
                                       Transformation transformation) {

        float finalAngle = startingAngle + ((endingAngle - startingAngle)
                * interpolatedTime);

        circle.setDegreesUpTillPreFill(finalAngle);
        circle.requestLayout();
    }
}
