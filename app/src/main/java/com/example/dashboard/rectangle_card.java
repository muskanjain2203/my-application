package com.example.dashboard;

import java.util.ArrayList;

public class rectangle_card {

    private String medicine_name;
    private  String company_name;
    private  int discount_price;
    private String description;
    private int actual_price;
    private int reduced_price;
    private  int discountPercent;
    private ArrayList<Integer> images = new ArrayList<>();
    private  int tabletPacks;


    public rectangle_card(String name , String companyName ,  int discount ,ArrayList<Integer> images,int discountPercent,int tabletsPack, String description, int actualPrice,  int reducedPrice   ){
        this.medicine_name = name;
        this.company_name=companyName;
        this.discount_price = discount;
        this.description = description;
        this.images = images;
        this.actual_price = actualPrice;
        this.tabletPacks=tabletsPack;
        this.reduced_price = reducedPrice;
        this.discountPercent = discountPercent;

    }
    public String getMedicine_name(){return medicine_name; }
    public String getCompany_name(){return company_name;}
    public int getDiscount_price(){return discount_price;}
    public String getDescription(){return description;}
    public int getActual_price(){return  actual_price;}
    public int getTabletPacks() {return tabletPacks;}
    public int getReduced_price(){return reduced_price;}
    public int getDiscountPercent(){return discount_price;}
    public ArrayList<Integer> getImages(){return images;}
}
