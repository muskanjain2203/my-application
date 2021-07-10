package com.example.dashboard;

public class MedicineFragmentCard{
    private int imageId;
    private int discount;
    private String medicine_name;
    private String company_name;
    private int medicine_price;

    public MedicineFragmentCard(String name, int price , int discount, int image){
        this.discount=discount;
        this.medicine_name=name;
        this.company_name=name;
        this.medicine_price = price;
        this.imageId=image;
    }
    public String getMedicine_name(){
        return medicine_name;
    }
    public String getCompany_name(){
        return company_name;
    }
    public int getMedicine_price(){return medicine_price;}
    public int getDiscount(){
        return discount;
    }
}
