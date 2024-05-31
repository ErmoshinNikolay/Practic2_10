package com.mirea.kt.practica2_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder>{
    private ArrayList<Phone> phones;

    public PhoneAdapter (ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView modelView;
        private final TextView priceView;
        ViewHolder(View view) {
            super(view);
            modelView = view.findViewById(R.id.tvModel);
            priceView = view.findViewById(R.id.tvPrice);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phone phone = phones.get(position);
        holder.modelView.setText(String.format("%s %s",phone.getModel(),phone.getSerial_number()));
        holder.priceView.setText(String.format("%d руб",phone.getPrice()));
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }


}
