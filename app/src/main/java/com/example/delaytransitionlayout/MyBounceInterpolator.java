package com.example.delaytransitionlayout;

import android.view.animation.Interpolator;

/**
 * Created by abc on 08/02/2018.
 */

public class MyBounceInterpolator implements Interpolator
{
    private  double mAmplitude;
    private  double mFrequency;

    public MyBounceInterpolator(double mAmplitude, double mFrequency) {
        this.mAmplitude = mAmplitude;
        this.mFrequency = mFrequency;
    }

    @Override
    public float getInterpolation(float v) {
        return (float) (-1*Math.pow(Math.E,-v/mAmplitude)*Math.cos(mFrequency*v)+1);
    }
}
