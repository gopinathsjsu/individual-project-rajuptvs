package com.details;

public class Items {
    private String category;
    private String itemName;
    private double itemPrice;
    private int availableQuantity;

    public Items(String category, String itemName, int availableQuantity, double itemPrice) {
        this.category = category;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.availableQuantity = availableQuantity;
    }
    public Items(String name,int quantity){
        this.itemName=name;
        this.availableQuantity=quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}

