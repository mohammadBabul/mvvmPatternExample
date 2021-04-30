package com.babul.mvvm.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.babul.mvvm.R;
import com.babul.mvvm.model.data.Shop;
import com.bumptech.glide.Glide;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.viewHolder> {

    ArrayList<Shop> arrayList;
    Context mContext;

    public ShopAdapter(Context mContext, ArrayList<Shop> arrayList) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder viewHolder, int position) {
        viewHolder.name.setText(arrayList.get(position).getShopName());
        Glide.with(mContext)
                .load(arrayList.get(position).getShopImage())
                .placeholder(R.drawable.home)
                .into(viewHolder.image);

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
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);

        }
    }
}