package com.example.heal2heart.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.heal2heart.R;
import com.example.heal2heart.models.request.Login;
import com.example.heal2heart.models.response.login.LoginResponse;
import com.example.heal2heart.net.APIUrl;
import com.example.heal2heart.utils.ShareManager;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button ln_btn;
    EditText email, password;
    AbsoluteLayout absolute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ln_btn = (Button) findViewById(R.id.email_login_btn);
        email = (EditText) findViewById(R.id.email_edtxt);
        password = (EditText) findViewById(R.id.password_edtxt);
        absolute = (AbsoluteLayout) findViewById(R.id.absolute);
        absolute.setVisibility(View.GONE);

        ln_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    try {


                            absolute.setVisibility(View.VISIBLE);
                            String deviceId = Settings.Secure.getString(getContentResolver(),
                                    Settings.Secure.ANDROID_ID);

                            Log.w("deviceId", deviceId);

                            Login user = new Login(email.getText().toString(),password.getText().toString(), deviceId, 0, 1, 0,"");

                            Call<LoginResponse> call = APIUrl.provideApiService().loginUser(email.getText().toString(),password.getText().toString(), deviceId, 0, 1, 0,"");
                            call.enqueue(new Callback<LoginResponse>() {
                                @Override
                                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
                                {
                                    absolute.setVisibility(View.GONE);
                                    if(response.body().getCode() == 201){
                                        Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),  response.body().getMessage(), Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
                                        toast.show();
                                    }
                                    else{
                                        Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),  response.body().getMessage(), Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
                                        toast.show();

                                        new ShareManager(LoginActivity.this).saveLoginDetails(response.body().getData().getId(), response.body().getData().getUserImage(), response.body().getData().getEmail(), response.body().getData().getAccessToken());
                                        startHomeActivity();
                                    }
                                }

                                @Override
                                public void onFailure(Call<LoginResponse> call, Throwable t) {
                                    absolute.setVisibility(View.GONE);
                                    Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),"Please Enter valid Email and Password!!", Toast.LENGTH_LONG);
                                    toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
                                    toast.show();
                                }
                            });
                        }catch (Exception e){
                            absolute.setVisibility(View.GONE);
                            Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),"Error "+e,Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
                            toast.show();
                    }
                }
            }
        });
    }

    public void startHomeActivity(){
        Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }

    private boolean validate() {
        String e = email.getText().toString();
        String p = password.getText().toString();

        if (TextUtils.isEmpty(e)) {
            Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),"Please Enter Email", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }


        if (TextUtils.isEmpty(p)) {
            Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),"Please Enter Password", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),"Please Enter valid Email", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }


        if (p.length() < 6 || p.length() > 15) {
           Toast toast = Toast.makeText(LoginActivity.this.getApplicationContext(),"Password length must be 6 to 15 characters", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }

        return true;
    }
}
