package com.thelawyershandbook.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.thelawyershandbook.R;


/**
 * Created by Faraz on 12/30/2015.
 */
public class StatusBarColor {

    public static void SetColor(Activity activity){
       if (Integer.valueOf(Build.VERSION.SDK_INT)>=20){
           Window window = activity.getWindow();
           window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
           window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
           window.setStatusBarColor(activity.getResources().getColor(R.color.colorStaus));
       }

    }

    public static void SetColorCustome(Activity activity){
        if (Integer.valueOf(Build.VERSION.SDK_INT)>=20){
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(activity.getResources().getColor(R.color.colorStaus));
        }

    }
}
