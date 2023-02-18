package com.example.jsonretrofitplaceholder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.jsonretrofitplaceholder.R;
import com.example.jsonretrofitplaceholder.network.PhotosResults;


import java.util.List;

public class RvRetrofitAdapter extends RecyclerView.Adapter<RvRetrofitAdapter.RvHolderRetrofit> {

    Context context;
    List<PhotosResults> photosResults;

    public RvRetrofitAdapter(Context context, List<PhotosResults> photosResults) {
        this.context = context;
        this.photosResults = photosResults;

    }

    @NonNull

    @Override
    public RvRetrofitAdapter.RvHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_photo_items, parent, false);
        return new RvHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvRetrofitAdapter.RvHolderRetrofit holder, int position) {
        holder.tvTitle.setText(photosResults.get(position).getTitle());
        Glide.with(context).load(photosResults.get(position).getThumbnail())
                .fitCenter()
                .error(R.drawable.placeholder)
                .into(holder.ivImage);



    }

    @Override
    public int getItemCount() {
        return photosResults.size();
    }


    public class RvHolderRetrofit extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivImage;

        public RvHolderRetrofit(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
