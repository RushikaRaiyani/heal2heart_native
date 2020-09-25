package com.example.heal2heart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heal2heart.R;

public class BookSessionAdapter extends RecyclerView.Adapter<BookSessionAdapter.MyViewholder> {
    private Context context;
    LayoutInflater layoutInflater;
    int p;

    public BookSessionAdapter(Context context) {
        this.context=context;
        layoutInflater=LayoutInflater.from(context);

    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public BookSessionAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= layoutInflater.inflate(R.layout.book_session,parent,false);

        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSessionAdapter.MyViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}