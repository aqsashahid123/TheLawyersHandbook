package com.thelawyershandbook.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

import com.thelawyershandbook.R;

import org.json.JSONObject;


public class Prefrences {
    public static void savePreferences(String key, String value, Context context) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public static void saveBooleanPreferences(String key, boolean value, Context context) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public static String loadPreferences(Context context, String Key){
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sp.getString(Key, context.getString(R.string.no_record));

    }

    public static String loadZeroPreferences(Context context, String Key){
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sp.getString(Key, "0");
    }

    public static boolean loadBooleanPreferences(Context context, String Key){
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sp.getBoolean(Key, false);
    }

    public static void removePrefrence(Context context, String key){
        SharedPreferences myFavePref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = myFavePref.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void ClearPrefrences (Context context, Class<?> c){
        context.startActivity(new Intent(context, c));
        ((Activity)context).finish();
    }

}