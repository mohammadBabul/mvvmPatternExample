package com.babul.mvvm.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.babul.mvvm.R;
import com.babul.mvvm.model.data.Product;
import com.bumptech.glide.Glide;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHolder> {

    ArrayList<Product> arrayList;
    Context mContext;

    public ProductAdapter(Context mContext, ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_item, viewGroup, false);
                return new viewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels / 2;
        int deviceheight = displaymetrics.heightPixels / 4;
        holder.itemView.getLayoutParams().width = devicewidth;
        holder.itemView.getLayoutParams().height = deviceheight;

        holder.name.setText(arrayList.get(position).getName());
        Glide.with(mContext)
                .load(arrayList.get(position).getImageUrls().get(0))
                .placeholder(R.drawable.home)
                .centerCrop()
                .override(300, 200)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        public viewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }
}