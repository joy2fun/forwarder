package com.example.forwarder;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Config {
    public static final String ENDPOINT_NAME = "endpoint";
    public static final String ENDPOINT_URL = "http://192.168.0.108:9998/t.php";

    public static String getEndpointUrl(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(Config.ENDPOINT_NAME, MODE_PRIVATE);
        return  prefs.getString("url", Config.ENDPOINT_URL);
    }
}
