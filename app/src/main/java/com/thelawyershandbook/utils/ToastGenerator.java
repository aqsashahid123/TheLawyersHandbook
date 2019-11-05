package com.thelawyershandbook.utils;

import android.content.Context;
import android.widget.Toast;


public class ToastGenerator {
    public static void show(Context context, String text, boolean isLong) {
        if (isLong) {
            Toast.makeText(context, text,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, text,Toast.LENGTH_SHORT).show();
        }
    }
}
