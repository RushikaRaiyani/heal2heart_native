package com.example.heal2heart.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUrl {
    private static final String BASE_URL = "http://18.237.50.45/projects/heal2heart/api/";
    private static Retrofit retrofit;
    private static OkHttpClient getRequestHeader(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().readTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS).build();
        return okHttpClient;
    }

    private static Retrofit provideRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getRequestHeader())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    private static APIService service = provideRetrofit().create(APIService.class);

    public static APIService provideApiService() {
        return service;
    }
}