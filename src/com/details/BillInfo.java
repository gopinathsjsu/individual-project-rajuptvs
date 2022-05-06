package com.details;

public class BillInfo {
    private String invoiceItem;
    private int itemQuantity;
    private String cardDetails;
    private double price;

    public BillInfo(String invoiceItem, int itemQuantity, String cardDetails, double price) {
        this.invoiceItem = invoiceItem;
        this.itemQuantity = itemQuantity;
        this.cardDetails = cardDetails;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(String invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getCards() {
        return cardDetails;
    }

    public void setCards(String cardDetails) {
        this.cardDetails = cardDetails;
    }

	@Override
	public String toString() {
		return "InvoiceItems [invoiceItem=" + invoiceItem + ", itemQuantity=" + itemQuantity
				+ ", cardDetails=" + cardDetails + ", price=" + price + "]";
	}


    

}
