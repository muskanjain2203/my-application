package com.example.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     private RecyclerViewAdapter recyclerViewAdapter;
     private RecyclerViewAdapterCategory categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = new Intent(this,ShopByCategory.class);
        startActivity(intent);



        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_bar);
        progressDialog.setCanceledOnTouchOutside(false);
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();



        ArrayList<medicine_card> medicines  = new ArrayList<>();
        medicines.add(new medicine_card("medicine name",20, 10,0));
        medicines.add(new medicine_card("medicine name",60, 20,0));
        medicines.add(new medicine_card("medicine name",110, 50,0));
        medicines.add(new medicine_card("medicine name",100, 30,0));
        medicines.add(new medicine_card("medicine name",20, 10,0));
        medicines.add(new medicine_card("medicine name",30, 10,0));
        medicines.add(new medicine_card("medicine name",20, 20,0));

        ArrayList<category_item> category = new ArrayList<>();
        for (int i = 0 ; i<6 ; i++){
            int temp = i+1;
            category.add(new category_item("Category "+temp,20,0));
        }


        RecyclerView shopByCategoryRecyclerView = (RecyclerView) findViewById(R.id.shopByCategoryRecyclerView);
        GridLayoutManager layoutManagerCategory = new GridLayoutManager(this,3);
        shopByCategoryRecyclerView.setHasFixedSize(true);
        shopByCategoryRecyclerView.setLayoutManager(layoutManagerCategory);
        categoryAdapter = new RecyclerViewAdapterCategory(this, category);
        shopByCategoryRecyclerView.setAdapter(categoryAdapter);


        RecyclerView mostPurchasedRecyclerView = (RecyclerView) findViewById(R.id.mostPurchasedRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mostPurchasedRecyclerView.setHasFixedSize(true);
        mostPurchasedRecyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this,medicines);
        mostPurchasedRecyclerView.setAdapter(recyclerViewAdapter);


        RecyclerView headacheRecyclerView = (RecyclerView) findViewById(R.id.headacheRecyclerView);
        LinearLayoutManager layoutManagerHeadache = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        headacheRecyclerView.setHasFixedSize(true);
        headacheRecyclerView.setLayoutManager(layoutManagerHeadache);
        recyclerViewAdapter = new RecyclerViewAdapter(this,medicines);
        headacheRecyclerView.setAdapter(recyclerViewAdapter);


        RecyclerView gastricPainRecyclerView = (RecyclerView) findViewById(R.id.gastricPainRecyclerView);
        LinearLayoutManager layoutManagerGastric = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        gastricPainRecyclerView.setHasFixedSize(true);
        gastricPainRecyclerView.setLayoutManager(layoutManagerGastric);
        recyclerViewAdapter = new RecyclerViewAdapter(this,medicines);
        gastricPainRecyclerView.setAdapter(recyclerViewAdapter);


        RecyclerView coughRecyclerView = (RecyclerView) findViewById(R.id.coughRecyclerView);
        LinearLayoutManager layoutManagerCough = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        coughRecyclerView.setHasFixedSize(true);
        coughRecyclerView.setLayoutManager(layoutManagerCough);
        recyclerViewAdapter = new RecyclerViewAdapter(this,medicines);
        coughRecyclerView.setAdapter(recyclerViewAdapter);
    }


}