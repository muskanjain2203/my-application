package com.example.dashboard;

public class medicine_card {
    private int imageId;
    private int discount;
    private String medicine_name;
    private int medicine_price;

    public medicine_card(String name, int price , int discount, int image){
        this.discount=discount;
        this.medicine_name=name;
        this.medicine_price = price;
        this.imageId=image;
    }
    public String getMedicine_name(){
        return medicine_name;
    }
    public int getMedicine_price(){return medicine_price;}
    public int getDiscount(){
        return discount;
    }
}
