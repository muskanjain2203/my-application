package com.example.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<medicine_card> itemList;
    RecyclerViewAdapter(Context context, ArrayList<medicine_card> list){
        this.context = context;
        this.itemList = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_item,parent,false);
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        medicine_card medicineInfo = itemList.get(position);
        holder.medicineName.setText(medicineInfo.getMedicine_name());
        holder.discount.setText(medicineInfo.getDiscount() + "%off");
        int textColor = ContextCompat.getColor(context,R.color.green);
        holder.price.setTextColor(textColor);
        holder.price.setText("Rs"+ medicineInfo.getMedicine_price());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView medicineName;
        private final TextView price;
        private final TextView discount;
        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            medicineName= itemView.findViewById(R.id.medicine_name);
            price= itemView.findViewById(R.id.medicine_price);
            discount=itemView.findViewById(R.id.discount_text);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
