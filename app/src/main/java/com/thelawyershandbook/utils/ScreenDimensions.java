package com.thelawyershandbook.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Onebyte on 1/20/2017.
 */

public class ScreenDimensions {
    public static int DynamicHeight(Context context, int height){
        final float scale = context.getResources().getDisplayMetrics().density;
        int dynamicHeight = (int) (height * scale + 0.5f);

        return dynamicHeight;
    }

    public static int DynamicWidth(Context context, int width){
        final float scale = context.getResources().getDisplayMetrics().density;
        int dynamicWidth = (int) (width * scale + 0.5f);

        return dynamicWidth;
    }

    public static float BaseHeight(Activity context, int height){
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        float heightt = (Float.valueOf(size.y)/ Float.valueOf(1776));

        return heightt*height;
    }

    public static float BaseWidth(Activity context, int width){
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        float heightt = (Float.valueOf(size.x)/ Float.valueOf(1080));

        return heightt*width;
    }

    public static float BaseFontSize(Activity context, float textSize){
        DisplayMetrics metrics;
        metrics = context.getApplicationContext().getResources().getDisplayMetrics();
        float Textsize =textSize/metrics.density;
        return Textsize;
    }

    public static float pxFromDp(float dp, Context mContext) {
        return dp * mContext.getResources().getDisplayMetrics().density;
    }

    public static void showKeyboard(final EditText ettext, final Context context) {
        ettext.requestFocus();
        ettext.postDelayed(new Runnable() {
                               @Override
                               public void run() {
                                   InputMethodManager keyboard = (InputMethodManager) context
                                           .getSystemService(Context.INPUT_METHOD_SERVICE);
                                   keyboard.showSoftInput(ettext, 0);
                               }
                           }
                , 200);
    }

}
