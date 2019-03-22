package com.example.a71568.persondoctor.bean;

import java.io.Serializable;

public class CommonMedicineBean implements Serializable {
    private double price;
    private String medicineName;
    private int medicineImage;
    private int medicineCount;



    public int getMedicineCount() {
        return medicineCount;
    }

    public void setMedicineCount(int medicineCount) {
        this.medicineCount = medicineCount;
    }

    public CommonMedicineBean(double price, String medicineName, int medicineImage, int medicineCount) {
        this.price = price;
        this.medicineName = medicineName;
        this.medicineImage = medicineImage;
        this.medicineCount = medicineCount;
    }

    public CommonMedicineBean() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(int medicineImage) {
        this.medicineImage = medicineImage;
    }
}

