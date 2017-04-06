package io.happylrd.childishscorems.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import io.happylrd.childishscorems.model.Student;

public class ShareUtil {

    public static final String NAME = "config";

    public static void putStudent(Context context, String key, Student student) {
        Gson gson = new Gson();
        String json = gson.toJson(student);

        SharedPreferences sp = context
                .getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit()
                .putString(key, json)
                .commit();
    }

    public static Student getStudent(Context context, String key, String defValue) {
        SharedPreferences sp = context
                .getSharedPreferences(NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString(key, defValue);
        return gson.fromJson(json, Student.class);
    }
}
