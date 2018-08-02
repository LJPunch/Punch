package com.punch.punch.util.network.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "http://169.254.253.227:8080/";

    private static final class RetrofitClientHolder{
        private static final RetrofitClient retrofitClient = new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return RetrofitClientHolder.retrofitClient;
    }

    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    public <T> T create(Class <? extends T> type){
        return retrofit.create(type);
    }

}
