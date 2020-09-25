package com.example.heal2heart.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heal2heart.fragment.Home_fragment;
import com.example.heal2heart.fragment.MoreFragment;
import com.example.heal2heart.fragment.NotificationFragment;
import com.example.heal2heart.R;
import com.example.heal2heart.fragment.SessionFragment;
import com.example.heal2heart.fragment.CourseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    Drawable home_color_icon, session_color_icon, course_color_icon, notification_color_icon, more_color_icon;
    Drawable home_gray_icon, session_gray_icon, course_gray_icon, notification_gray_icon, more_gray_icon;
    ImageView home_icon, session_icon, course_icon, notification_icon, more_icon;
    TextView home_txt, session_txt, course_txt, notification_txt, more_txt;
    int previous_tab = 0, current_tab = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        loadFragment(new Home_fragment());
        View homeLayout = findViewById(R.id.home_layout);
        View sessionLayout = findViewById(R.id.session_layout);
        View courseLayout = findViewById(R.id.course_layout);
        View notificationLayout = findViewById(R.id.notification_layout);
        View moreLayout = findViewById(R.id.more_layout);

        int home = getResources().getIdentifier("@drawable/ic_home_color", null, getPackageName());
        int session = getResources().getIdentifier("@drawable/ic_session1", null, getPackageName());
        int course  = getResources().getIdentifier("@drawable/ic_course_color", null, getPackageName());
        int notification = getResources().getIdentifier("@drawable/ic_bell_color", null, getPackageName());
        int more  = getResources().getIdentifier("@drawable/ic_more_color", null, getPackageName());

        home_color_icon = getResources().getDrawable(home);
        session_color_icon = getResources().getDrawable(session);
        course_color_icon = getResources().getDrawable(course);
        notification_color_icon = getResources().getDrawable(notification);
        more_color_icon = getResources().getDrawable(more);

        home = getResources().getIdentifier("@drawable/ic_home", null, getPackageName());
        session = getResources().getIdentifier("@drawable/ic_session", null, getPackageName());
        course  = getResources().getIdentifier("@drawable/ic_course", null, getPackageName());
        notification = getResources().getIdentifier("@drawable/ic_bell", null, getPackageName());
        more  = getResources().getIdentifier("@drawable/ic_more", null, getPackageName());

        home_gray_icon = getResources().getDrawable(home);
        session_gray_icon = getResources().getDrawable(session);
        course_gray_icon = getResources().getDrawable(course);
        notification_gray_icon = getResources().getDrawable(notification);
        more_gray_icon = getResources().getDrawable(more);

         home_icon = (ImageView) homeLayout.findViewById(R.id.home_img_icon);
         session_icon = (ImageView) sessionLayout.findViewById(R.id.session_img_icon);
         course_icon = (ImageView) courseLayout.findViewById(R.id.course_img_icon);
         notification_icon = (ImageView) notificationLayout.findViewById(R.id.notification_img_icon);
         more_icon = (ImageView) moreLayout.findViewById(R.id.more_img_icon);

        home_txt = (TextView) homeLayout.findViewById(R.id.home_txt);
        session_txt = (TextView) sessionLayout.findViewById(R.id.session_txt);
        course_txt = (TextView) courseLayout.findViewById(R.id.course_txt);
        notification_txt = (TextView) notificationLayout.findViewById(R.id.notification_txt);
        more_txt = (TextView) moreLayout.findViewById(R.id.more_txt);

        home_icon.setImageDrawable(home_color_icon);
        home_txt.setTextColor(getResources().getColor(R.color.menuColorText));

        homeLayout.setOnClickListener(this);
        sessionLayout.setOnClickListener(this);
        courseLayout.setOnClickListener(this);
        notificationLayout.setOnClickListener(this);
        moreLayout.setOnClickListener(this);


//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }



    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        Fragment fragment = null;

        previous_tab = current_tab;

        switch (v.getId()) {
            case R.id.home_layout:
                fragment = new Home_fragment();
                current_tab = 0;
                break;

            case R.id.session_layout:
                fragment = new SessionFragment();
                current_tab = 1;
                break;

            case R.id.course_layout:
                fragment = new CourseFragment();
                current_tab = 2;
                break;

            case R.id.notification_layout:
                fragment = new NotificationFragment();
                current_tab = 3;
                break;

            case R.id.more_layout:
                fragment = new MoreFragment();
                current_tab = 4;
                break;
        }

        if(previous_tab != current_tab){
            changeIconColor();
            loadFragment(fragment);
        }

    }

    void changeIconColor(){

        switch (previous_tab){
            case 0:
                home_icon.setImageDrawable(home_gray_icon);
                home_txt.setTextColor(getResources().getColor(R.color.menuText));
                break;
            case 1:
                session_icon.setImageDrawable(session_gray_icon);
                session_txt.setTextColor(getResources().getColor(R.color.menuText));
                break;
            case 2:
                course_icon.setImageDrawable(course_gray_icon);
                course_txt.setTextColor(getResources().getColor(R.color.menuText));
                break;
            case 3:
                notification_icon.setImageDrawable(notification_gray_icon);
                notification_txt.setTextColor(getResources().getColor(R.color.menuText));
                break;
            case 4:
                more_icon.setImageDrawable(more_gray_icon);
                more_txt.setTextColor(getResources().getColor(R.color.menuText));
                break;
        }

        switch (current_tab){
            case 0:
                home_icon.setImageDrawable(home_color_icon);
                home_txt.setTextColor(getResources().getColor(R.color.menuColorText));
                break;
            case 1:
                session_icon.setImageDrawable(session_color_icon);
                session_txt.setTextColor(getResources().getColor(R.color.menuColorText));
                break;
            case 2:
                course_icon.setImageDrawable(course_color_icon);
                course_txt.setTextColor(getResources().getColor(R.color.menuColorText));
                break;
            case 3:
                notification_icon.setImageDrawable(notification_color_icon);
                notification_txt.setTextColor(getResources().getColor(R.color.menuColorText));
                break;
            case 4:
                more_icon.setImageDrawable(more_color_icon);
                more_txt.setTextColor(getResources().getColor(R.color.menuColorText));
                break;
        }
    }
}
