package com.thelawyershandbook.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

import com.thelawyershandbook.R;


public class Validator {

    public static boolean isNameValid(CharSequence name) {
        if (name.toString().isEmpty() || name.toString().length() < 5) {
            return false;
        }
        return true;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            ToastGenerator.show(context, context.getString(R.string.internet_not_connected), true);
            return false;
        }
    }

    public static boolean isEmailValid(CharSequence email) {
        if (email.toString().isEmpty()) {
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }
        return true;
    }


    public static boolean isPasswordValid(String password) {
        if (password.trim().isEmpty() || password.length() < 6) {
            return false;
        }
        return true;
    }

    public final static boolean isValidNumber(String text) {

        if (text.trim().length() > 3 && text.trim().length() == 10) {
            return true;
        } else if (text.trim().length() == 3) {
            return false;
        }

        return true;
    }

}
