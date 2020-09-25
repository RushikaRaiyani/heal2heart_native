package com.example.heal2heart.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.heal2heart.R;
import com.example.heal2heart.activity.MainActivity;
import com.example.heal2heart.activity.ProfileActivity;
import com.example.heal2heart.utils.ShareManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    LinearLayout logout_btn, proflie_btn;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_more, container, false);

        logout_btn = (LinearLayout) v.findViewById(R.id.logout_btn);
        proflie_btn = (LinearLayout) v.findViewById(R.id.proflie_btn);

        proflie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ProfileActivity.class);
                startActivity(i);
            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogButtonClicked(v);
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    public void showAlertDialogButtonClicked(View view)
    {

        // Create an alert builder
        AlertDialog.Builder builder
                = new AlertDialog.Builder(getContext());
        // set the custom layout
        final View customLayout
                = getLayoutInflater()
                .inflate(
                        R.layout.logout_dialog,
                        null);
        builder.setView(customLayout);

        Button yes
                = customLayout
                .findViewById(
                        R.id.positive);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareManager(getContext()).Logout();
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        final AlertDialog dialog
                = builder.create();
        dialog.show();

        Button no
                = customLayout
                .findViewById(
                        R.id.nagative);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
    }
}
