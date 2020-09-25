package com.example.heal2heart.models.request;

public class Login {
     String  email,password,device_token,social_id;
      int device_type,user_type,login_type;

    public Login(String  email, String password, String device_token, int device_type, int user_type, int login_type, String social_id){
        this.email = email;
        this.password = password;
        this.device_token = device_token;
        this.device_type = device_type;
        this.user_type = user_type;
        this.login_type = login_type;
        this.social_id = social_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getDeviceToken() {
        return device_token;
    }

    public int getDeviceType() {
        return device_type;
    }
    public int getUserType() {
        return user_type;
    }

    public int getLoginType() {
        return login_type;
    }
    public String getSocialId() {
        return social_id;
    }

}
