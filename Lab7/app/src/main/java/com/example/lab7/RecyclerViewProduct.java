package com.example.lab7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewProduct extends RecyclerView.Adapter<RecyclerViewProduct.MyViewHolder> {

    int[] images;
    String[] names;
    String[] prices;


    public RecyclerViewProduct(int[] images, String[] names, String[] prices) {
        this.images = images;
        this.names = names;
        this.prices = prices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
        holder.textName.setText(names[position]);
        holder.textPrice.setText(prices[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    // Inner class to initialize variables for a Product instance's name, price, and image
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textPrice;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.productName);
            textPrice = itemView.findViewById(R.id.productPrice);
            image = itemView.findViewById(R.id.productImage);
        }

    }
}
