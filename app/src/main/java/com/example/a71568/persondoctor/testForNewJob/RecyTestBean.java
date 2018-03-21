package com.example.a71568.persondoctor.testForNewJob;

/**
 * Created by 71568 on 2018/3/20.
 */

public class RecyTestBean {
    private String recyText;
    private int inageId;

    public String getRecyText() {
        return recyText;
    }

    public void setRecyText(String recyText) {
        this.recyText = recyText;
    }

    public int getInageId() {
        return inageId;
    }

    public void setInageId(int inageId) {
        this.inageId = inageId;
    }

    public RecyTestBean(String recyText, int inageId) {
        this.recyText = recyText;
        this.inageId = inageId;
    }
}
