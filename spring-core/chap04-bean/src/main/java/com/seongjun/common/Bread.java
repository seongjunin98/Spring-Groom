package com.seongjun.common;

import java.util.Date;

public class Bread extends Product {

    private java.util.Date bakeDate;

    public Bread()  {
        super();
    }

    public Bread(String name, int price, Date bakeDate) {
        super(name, price);
        this.bakeDate = bakeDate;
    }

    public Date getBakeDate() {
        return bakeDate;
    }

    public void setBakeDate(Date bakeDate) {
        this.bakeDate = bakeDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + bakeDate;
    }
}
