package com.example.a71568.persondoctor.bean;

import java.io.Serializable;

public class MedicineInfoBean implements Serializable {
    private String mName;
    private String imageName;
    private int price;
    private int cost;
    private int profit;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public MedicineInfoBean() {


    }

    public MedicineInfoBean(String mName, String imageName, int price, int cost, int profit) {
        this.mName = mName;
        this.imageName = imageName;
        this.price = price;
        this.cost = cost;
        this.profit = profit;
    }
}
