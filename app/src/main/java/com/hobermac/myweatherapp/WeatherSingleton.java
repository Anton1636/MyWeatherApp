package com.hobermac.myweatherapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class WeatherSingleton {
    private static WeatherSingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private WeatherSingleton(Context context)
    {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized WeatherSingleton getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new WeatherSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }
}
