package com.example.photobomb1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.example.photobomb1.Adapter.Model.RecyclerModel;
import com.example.photobomb1.R;

import java.time.Instant;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecycleViewHolder> {

        Context ctx;
        List<RecyclerModel> recyclerModelList;

        public RecyclerAdapter(Context ctx, List<RecyclerModel> recyclerModelList) {
            this.ctx = ctx;
            this.recyclerModelList = recyclerModelList;
        }

        @NonNull
        @Override
        public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(ctx).inflate(R.layout.main_recycle_item,parent,false);
            return new RecycleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {


            Glide.with(ctx).load(recyclerModelList.get(position).getImageUrl()).into(holder.imageView);

//        holder.imageView.setImageResource(recyclerModelList.get(position).getImageUrl());

        }

        @Override
        public int getItemCount() {
            return recyclerModelList.size();
        }

        public static class RecycleViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            public RecycleViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView=itemView.findViewById(R.id.imageView);
            }
        }

}
