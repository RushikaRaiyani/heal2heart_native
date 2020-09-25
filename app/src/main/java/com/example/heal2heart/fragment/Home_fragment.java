package com.example.heal2heart.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.heal2heart.R;
import com.example.heal2heart.adapter.BookSessionAdapter;
import com.example.heal2heart.adapter.SlidingImage_Adapter;
import com.example.heal2heart.adapter.StartSessionAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_fragment extends Fragment {

    RecyclerView startSessionRecyclerView, bookSessionRecyclerView;
    ImageView backArrow, nextArrow;

    int index = 0;

    private static ViewPager mPager;
    private ArrayList<String> ImagesArray = new ArrayList<String>();

    public Home_fragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.loading);

        Glide.with(this).load(R.drawable.loader).into(img);
        mPager = (ViewPager) view.findViewById(R.id.viewpager);

        ImagesArray.add("https://source.unsplash.com/1024x768/?nature");
        ImagesArray.add("https://source.unsplash.com/1024x768/?water");
        ImagesArray.add("https://source.unsplash.com/1024x768/?girl");
        ImagesArray.add("https://source.unsplash.com/1024x768/?tree");


        mPager.setAdapter(new SlidingImage_Adapter(getContext(), ImagesArray));

        startSessionRecyclerView = (RecyclerView) view.findViewById(R.id.start_session);
        startSessionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        StartSessionAdapter startSessionAdapter = new StartSessionAdapter(getContext());
        startSessionRecyclerView.setAdapter(startSessionAdapter);

        bookSessionRecyclerView = (RecyclerView) view.findViewById(R.id.book_session);
        bookSessionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        BookSessionAdapter bookSessionAdapter = new BookSessionAdapter(getContext());
        bookSessionRecyclerView.setAdapter(bookSessionAdapter);

        backArrow = (ImageView) view.findViewById(R.id.back_arrow);
        nextArrow = (ImageView) view.findViewById(R.id.next_arrow);

        if(index <= 0){
            backArrow.setVisibility(View.INVISIBLE);
        }

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = index - 1;
                mPager.setCurrentItem(index, true);
                if(index == 0){
                    backArrow.setVisibility(View.INVISIBLE);
                }
                else{
                    backArrow.setVisibility(View.VISIBLE);
                }

                if(index < ImagesArray.size()-1){
                    nextArrow.setVisibility(View.VISIBLE);
                }
            }
        });

        if(index >= ImagesArray.size()){
            nextArrow.setVisibility(View.INVISIBLE);
        }

        nextArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = index + 1;
                mPager.setCurrentItem(index, true);
                if(index > 0){
                    backArrow.setVisibility(View.VISIBLE);
                }
                if(index >= ImagesArray.size()-1){
                    nextArrow.setVisibility(View.INVISIBLE);
                }
                else{
                    nextArrow.setVisibility(View.VISIBLE);
                }
            }
        });

        mPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Log.w("test ","test");
                return true;
            }
        });

        return view;
    }

}
