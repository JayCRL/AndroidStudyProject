package com.example.myapplication11.Shp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication11.R;

public class MyData {
    private int number;
    private Context context;
    public MyData(Context context){
        this.context=context;
    }
    public void save(){
        SharedPreferences sharedPreferences= context.getSharedPreferences("MyAppData",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String key =context.getResources().getString(R.string.mykey);
        editor.putInt(key,number);
        editor.apply();
    }
    public void load(){
        SharedPreferences sharedPreferences= context.getSharedPreferences("MyAppData",Context.MODE_PRIVATE);
        String key =context.getResources().getString(R.string.mykey);
        number=sharedPreferences.getInt(key,R.string.mykeyDefaultValue);
    }
    public int getNumber(){
        return number;
    }
    public boolean setNumber(Integer integer){
        number=integer;
        save();
        return  true;
    }
}
