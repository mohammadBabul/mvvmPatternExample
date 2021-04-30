package com.babul.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.babul.mvvm.R;
import com.babul.mvvm.model.data.Brand;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.viewHolder> {

    ArrayList<Brand> brandArrayList;
    Context mContext;

    public BrandAdapter(Context mContext, ArrayList<Brand> arrayList) {
        this.brandArrayList = arrayList;
        this.mContext = mContext;
    }

    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.brand_list_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder viewHolder, int position) {
        viewHolder.name.setText(brandArrayList.get(position).getName());
        Glide.with(mContext)
                .load(brandArrayList.get(position).getImageUrl())
                .placeholder(R.drawable.home)
                .into(viewHolder.image);


    }

    @Override
    public int getItemCount() {
        return brandArrayList.size();
    }
    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public viewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            image =itemView.findViewById(R.id.image);
        }
    }
}