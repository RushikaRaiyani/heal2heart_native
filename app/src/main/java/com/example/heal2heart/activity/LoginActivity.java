package com.example.heal2heart.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
    ImageView back_arrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ln_btn = (Button) findViewById(R.id.email_login_btn);
        email = (EditText) findViewById(R.id.email_edtxt);
        password = (EditText) findViewById(R.id.password_edtxt);
        absolute = (AbsoluteLayout) findViewById(R.id.absolute);
        absolute.setVisibility(View.GONE);
        ImageView img = (ImageView) findViewById(R.id.spin_kit);
        Glide.with(this).load(R.drawable.loader).into(img);

        setupUI(findViewById(R.id.parent));


        back_arrow = (ImageView) findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ln_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    try {


                            absolute.setVisibility(View.VISIBLE);
                            String deviceId = Settings.Secure.getString(getContentResolver(),
                                    Settings.Secure.ANDROID_ID);


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
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
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

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(LoginActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
