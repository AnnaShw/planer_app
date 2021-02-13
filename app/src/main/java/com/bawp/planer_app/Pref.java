package com.bawp.planer_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedList;


public class Pref {
    private static final String LIST_KEY="lst_key";
    public static void TothePref(Context conext, LinkedList<String> lst){
        Gson gson=new Gson();
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(conext);
        SharedPreferences.Editor editor=pref.edit();
        String jsonString=gson.toJson(lst);
        editor.putString(LIST_KEY,jsonString);
        editor.apply();
    }
    public static LinkedList<String> FromthePref(Context conext){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(conext);
        String jsonString=pref.getString(LIST_KEY,"");
        Gson gson=new Gson();
        Type type=new TypeToken<LinkedList<String>>(){}.getType();
        LinkedList<String> lst=gson.fromJson(jsonString,type);
        return lst;
    }
}
