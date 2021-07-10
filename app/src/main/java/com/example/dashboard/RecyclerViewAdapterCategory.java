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

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterCategory extends RecyclerView.Adapter<RecyclerViewAdapterCategory.ViewHolder> {
    private Context context;
    private ArrayList<category_item> List;
    RecyclerViewAdapterCategory(Context context, ArrayList<category_item> list){
        this.context = context;
        this.List = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterCategory.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCategory.ViewHolder holder, int position) {
        category_item current = List.get(position);
        if (position<5){
            holder.categoryName.setText(current.getCategory_name());
        }else{
            holder.viewall.setText("view all");
        }
    }


    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView categoryName;
        private TextView viewall;

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView){
            super(itemView);
           categoryName= itemView.findViewById(R.id.category);
           viewall = itemView.findViewById(R.id.viewAll);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
