package com.chhavi.pickzie.Helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;

import java.io.InputStream;

public class GradientOverImageDrawable extends BitmapDrawable {

    private int[] gradientColors;
    private float[] gradientPositions;
    private double gradientStart = 0;
    private double gradientEnd = 1;

    public GradientOverImageDrawable(Resources res, Bitmap bitmap) {
        super(res, bitmap);
    }

    public GradientOverImageDrawable(Resources res, String filepath) {
        super(res, filepath);
    }

    public GradientOverImageDrawable(Resources res, InputStream is) {
        super(res, is);
    }

    public void setGradientColors(int[] gradientColors) {
        this.gradientColors = gradientColors;
    }

    public void setGradientColors(int startColor, int... endColors) {
        if (endColors.length == 0) {
            throw new IllegalArgumentException("The endColors array must have at least one element");
        }
        gradientColors = new int[endColors.length + 1];
        gradientColors[0] = startColor;
        System.arraycopy(endColors, 0, gradientColors, 1, endColors.length);
    }

    public int[] getGradientColors() {
        return gradientColors;
    }

    public float[] getGradientPositions() {
        return gradientPositions;
    }

    public void setGradientPositions(float[] gradientPositions) {
        for (float pos : gradientPositions) {
            if (pos > 1 || pos < 0) {
                throw new IllegalArgumentException("The gradient position must be a float number between 0 and 1");
            }
        }
        this.gradientPositions = gradientPositions;
    }

    public double getGradientStart() {
        return gradientStart;
    }

    public void setGradientStart(double gradientStart) {
        this.gradientStart = gradientStart;
    }

    public double getGradientEnd() {
        return gradientEnd;
    }

    public void setGradientEnd(double gradientEnd) {
        this.gradientEnd = gradientEnd;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (gradientColors != null) {
            Rect bounds = getBounds();

            int x0 = bounds.left;
            int y0 = (int) Math.round(bounds.bottom * gradientStart);
            int x1 = x0;
            int y1 = (int) Math.round(bounds.bottom * gradientEnd);

            LinearGradient shader = new LinearGradient(x0, y0, x1, y1, gradientColors, gradientPositions, Shader.TileMode.CLAMP);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setShader(shader);
            canvas.drawRect(x0, y0, bounds.right, y1, paint);
        }
    }
}