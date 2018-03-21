package com.example.a71568.persondoctor.bean;

/**
 * Created by 71568 on 2017/12/23.
 */

public class DoctorInfo extends BBB{
    public String picUrl;
    public String doctorIntelligence;

    public DoctorInfo(String picUrl, String doctorIntelligence) {
        this.picUrl = picUrl;
        this.doctorIntelligence = doctorIntelligence;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getDoctorIntelligence() {
        return doctorIntelligence;
    }

    public void setDoctorIntelligence(String doctorIntelligence) {
        this.doctorIntelligence = doctorIntelligence;
    }
}
