package com.example.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterFragment extends RecyclerView.Adapter<RecyclerViewAdapterFragment.ViewHolder>
    implements View.OnLongClickListener
{
    View.OnLongClickListener onLongClickListener;

    private final Context context;
    private final ArrayList<rectangle_card> itemList;
    RecyclerViewAdapterFragment(Context context, ArrayList<rectangle_card> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterFragment.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent , int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.medicine_fragment_item,parent,false);
        ViewHolder view = new ViewHolder(listItem);
        listItem.setOnLongClickListener(this);
        return view;

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterFragment.ViewHolder holder, int position) {
       rectangle_card medicineInfo = itemList.get(position);
        holder.medicineName.setText(medicineInfo.getMedicine_name());
        holder.companyName.setText(medicineInfo.getCompany_name());
        holder.discount.setText(medicineInfo.getDiscountPercent() + "%off");
        holder.reducePrice.setText("Rs" + medicineInfo.getReduced_price());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public  boolean onLongClickListener(View.OnLongClickListener onLongClickListener)
    {
        this.onLongClickListener = onLongClickListener;
        return  true;
    }
    @Override
    public boolean onLongClick(View v) {
        onLongClickListener.onLongClick(v);
        return true;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public  TextView medicineName;
        public  TextView companyName;
        public  TextView reducePrice;
        public  TextView discount;
        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            companyName = itemView.findViewById(R.id.Company_name);
            medicineName= itemView.findViewById(R.id.medicine_name);
            reducePrice= itemView.findViewById(R.id.medicine_price);
            discount=itemView.findViewById(R.id.discount_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }
    }
}
