package com.example.lab1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {


    private final LayoutInflater inflater;
    private final List<Item> items;

    public RecyclerViewAdapter(Context context, List<Item> items) {
        // получаем LayoutInflater из контекста для создания View для каждого элемента списка
        inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public RecyclerViewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // создаем View для каждого элемента списка
        return new ItemViewHolder(inflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ItemViewHolder holder, int position) {
        // заполняем данными каждый элемент списка
        Item item = items.get(position);

        // следующие 5 строк взяты из примера к лабе
        Glide.with(inflater.getContext())
                .load(item.getImageUrl())
                .centerCrop()
                .crossFade()
                .into(holder.imageView);


        holder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
