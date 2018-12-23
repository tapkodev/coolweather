package com.guixin.tapko.util;

import java.net.URI;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2018/12/23.
 */

public class Httputil {
   public static void sendOkhttpRequest(String url, Callback callback){
       OkHttpClient client = new OkHttpClient();
       Request request = new Request.Builder().url(url).build();
       client.newCall(request).enqueue(callback);
   }
}
