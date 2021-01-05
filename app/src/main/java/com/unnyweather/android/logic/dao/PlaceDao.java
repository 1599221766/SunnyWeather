package com.unnyweather.android.logic.dao;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.unnyweather.android.SunnyWeatherApplication;
import com.unnyweather.android.logic.model.Place;

public class PlaceDao {
    void savePlace(Place place)
    {
        sharedPreferences().edit().putString("place",new Gson().toJson(place));
    }
    public static Place getSavedPlace()
    {
       String placeJson=sharedPreferences().getString("place","");
        return new  Gson().fromJson(placeJson,Place.class);
    }


     public static boolean isPlaceSaved(){
        return sharedPreferences().contains("place");
     }
    private static SharedPreferences sharedPreferences(){
       return SunnyWeatherApplication.context.getSharedPreferences("sunny_weather",Context.MODE_PRIVATE);
    }
}
