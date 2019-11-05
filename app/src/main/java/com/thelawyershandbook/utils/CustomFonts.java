package com.thelawyershandbook.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Admin on 11/15/2016.
 */

public class CustomFonts {

    public static Typeface getTypeface(Context context, String typeface) {
        Typeface mFont = null;
        if (mFont == null) {
            mFont = Typeface.createFromAsset(context.getAssets(), typeface);
        }
        return mFont;
    }
}
