package com.example.carsondemand;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars );
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car(R.drawable.car1,"Toyota","i20","2010","100,000"));
            cars.add(new Car(R.drawable.car2,"Hyundai","300","2000","200,000"));
            cars.add(new Car(R.drawable.car3,"Mazda","V2","2080","300,000"));
            cars.add(new Car(R.drawable.car4,"Bmw","V30","2003","90,000"));
            cars.add(new Car(R.drawable.car5,"Porche","xc120","2002","55,000"));
            cars.add(new Car(R.drawable.car6,"Volvo","i50","1990","75,000"));
            cars.add(new Car(R.drawable.car7,"Honda","xc60","1994","110,000"));
            cars.add(new Car(R.drawable.car8,"mercedes","i20","2020","120,000"));
            return cars;
        }
    }
}
