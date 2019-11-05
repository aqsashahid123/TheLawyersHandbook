package com.thelawyershandbook.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by talk2 on 7/17/2017.
 */

public class IntentCall {
    public static void NavigateScreen(Context context, Class<?> c, boolean isFinish){
        Intent intent = new Intent(context, c);
        context.startActivity(intent);
        if (isFinish){
            ((Activity)context).finish();
        }
    }

}
