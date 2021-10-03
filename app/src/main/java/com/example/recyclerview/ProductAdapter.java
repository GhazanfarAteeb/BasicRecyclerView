package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ArrayList<Product> productList;
    Context context;
    public ProductAdapter(ArrayList<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.list_item_view,parent,false);
        return new ViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        TextView barcode = holder.barcode;
        TextView name = holder.productName;
        TextView quantity = holder.productQuantity;
        TextView price = holder.productPrice;
        TextView shortDescription = holder.shortDescription;
        ImageView image = holder.productImage;

        barcode.setText(String.format(Locale.getDefault(),"%d", product.getId()));
        name.setText(product.getName());
        shortDescription.setText(product.getShortDescription());
        quantity.setText(String.format(Locale.getDefault(),"%d", product.getQuantity()));
        price.setText(String.format(Locale.getDefault(),"%.2f", (product.getPrice() * product.getQuantity())));
        image.setImageResource(R.drawable.product);

        holder.position = holder.getAdapterPosition();
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView barcode;
        public TextView productName;
        public TextView productQuantity;
        public TextView productPrice;
        public TextView shortDescription;
        public ImageView productImage;
        public int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            barcode = itemView.findViewById(R.id.barcode);
            productName = itemView.findViewById(R.id.name);
            productQuantity = itemView.findViewById(R.id.quantity);
            productPrice = itemView.findViewById(R.id.price);
            shortDescription = itemView.findViewById(R.id.short_description);
            productImage = itemView.findViewById(R.id.image);
        }
    }
}
