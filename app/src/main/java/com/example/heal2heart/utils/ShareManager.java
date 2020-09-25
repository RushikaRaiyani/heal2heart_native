package com.example.heal2heart.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareManager {
    Context context;
    public ShareManager(Context context){
        this.context=context;
    }
    public void saveLoginDetails(int id, String profile_img, String email, String device_token)
    {
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("id",id);
        editor.putString("profile_img",profile_img);
        editor.putString("email",email);
        editor.putString("device_token",device_token);
        editor.apply();
    }
    public String getEmail(){
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        return sp.getString("email","");


    }
    public String getDeviceToken(){
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        return sp.getString("device_token","");

    }

    public String getProfileImg(){
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        return sp.getString("profile_img","");


    }
    public int getId(){
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        return sp.getInt("id",0);

    }

    public boolean isLogout(){
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        boolean isEmptyEmail=sp.getString("email","").isEmpty();
        boolean isEmptyToken=sp.getString("device_token","").isEmpty();
        return isEmptyEmail || isEmptyToken;
    }
    public boolean Logout(){
        SharedPreferences sp=context.getSharedPreferences("LoginDetail",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.clear();
        editor.commit();
        return true;
    }

}
