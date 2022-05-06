package com.details;

import java.util.HashSet;

public class Bill {
private double totalPrice;
private HashSet<Items> itemList= new HashSet<Items>();
public Bill(){};

    public HashSet<Items> getItemList() {
        return itemList;
    }

    public void setItemList(HashSet<Items> itemList) {
        this.itemList = itemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
