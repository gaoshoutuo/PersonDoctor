package com.example.a71568.persondoctor.bean;

/**
 * Created by 71568 on 2017/12/10.
 */

public class MenuBean extends BBB{
    private int picId;
    private String menuName;

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MenuBean(int picId, String menuName) {
        this.picId = picId;
        this.menuName = menuName;
    }
}
