package com.example.dashboard;

public class category_item {
    private int imageId;
    private int discount;
    private String category_name;

    public category_item(String name, int discount, int image){
        this.discount=discount;
        this.category_name=name;
        this.imageId=image;
    }
    public String getCategory_name(){
        return category_name;
    }
    public int getDiscount(){
        return discount;
    }
}
