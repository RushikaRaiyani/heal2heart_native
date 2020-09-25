package com.example.heal2heart.net;


import com.example.heal2heart.models.request.Login;
import com.example.heal2heart.models.response.login.LoginResponse;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("log-in")
    Call<LoginResponse> loginUser(@Field("email") String email, @Field("password") String password, @Field("device_token") String device_token, @Field("device_type") int device_type, @Field("user_type") int user_type, @Field("login_type") int login_type, @Field("social_id") String social_id);
}