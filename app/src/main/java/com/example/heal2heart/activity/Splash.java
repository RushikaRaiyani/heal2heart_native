package com.example.heal2heart.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.heal2heart.R;
import com.example.heal2heart.utils.ShareManager;

public class Splash extends AppCompatActivity {

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        thread=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                }catch (Exception e){

                }
                finally {
                    boolean isLogout =  new ShareManager(Splash.this).isLogout();
                    Log.w("aa ","login "+isLogout);
                    if(isLogout){
                        Intent intent=new Intent(Splash.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Intent intent=new Intent(Splash.this,DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            }
        };
        thread.start();

    }
}
