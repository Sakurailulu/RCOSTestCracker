package com.example.share.util;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    public static String post(String url, Map<String, String> map) throws Exception {

        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .header("Content-type", "application/x-www-form-urlencoded")
                .post(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute();

        if (response.body() == null) {
            return null;
        }

        return response.body().string();
    }
}