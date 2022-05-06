package com.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.billingfactory.ModifyBill;
import com.database.DataBase;
import com.details.Bill;
import com.details.BillInfo;
import com.details.Items;

public class Orders {
    private DataBase database=DataBase.getInstance();
    private ModifyBill file;
    private ArrayList<String> finalResult=new ArrayList<String>();
    private HashSet<String> card=new HashSet<String>();
    private ArrayList<BillInfo> itemList=new ArrayList<BillInfo>();
    

	

	private Bill currentInvoice=new Bill();
    private double totalAmount=0;
    public Orders(String filePath){
        file=new ModifyBill(filePath);
    }
    

	public boolean startOrder(){
        try{
            file.readFile(true);
        }catch(Exception e){
            return false;
        }
        getItems(file.getContent());
        return true;
    }
    public boolean validateOrder(){
        checkQuantities();
        checkMaxCategory();
        return finalResult.isEmpty();
    }
    public void calcTotalPrice(){
        itemList.forEach((item)->{
            totalAmount+= item.getItemQuantity()*item.getPrice();
        
        });
        currentInvoice.setTotalPrice(totalAmount);
    }



    public void checkoutTransaction(){
        database.getOrders().add(currentInvoice);
        for(BillInfo currentItem:itemList){
            Items item=database.getItems().get(currentItem.getInvoiceItem());
            item.setAvailableQuantity(item.getAvailableQuantity()-currentItem.getItemQuantity());

        }
        for(String creditCard:card){
            if(!database.getCards().contains(creditCard)){
                database.getCards().add(creditCard);
                System.out.println("Card : "+creditCard+" has been added to the database");
            }
        }
       
        retrieveOutput();
    }

    private void getItems(ArrayList<String> message){
    	String firstLine = message.get(0);
        String[] firstItem = firstLine.split(",");
        for(String contentLine:message) {
            String[] item = contentLine.split(",");
            if (database.getItems().containsKey(item[0].toLowerCase())) {
            	double priceItem = database.getItems().get(item[0].toLowerCase()).getItemPrice();

            	try
            	{
            		itemList.add(new BillInfo(item[0].toLowerCase(), Integer.parseInt(item[1]), firstItem[2].replaceAll("\\s+", ""), priceItem));
            	}
            	catch(Exception e)
            	{
            		System.out.println("Error Occured, please check error log under files folder for more details");
            		finalResult.add("Invalid File format");
            		break;
            	}
                
            } else {
                finalResult.add("'" + item[0] + "' Does not exists in the database please retry");
            }

        }
        if(!finalResult.isEmpty()){
            itemList.clear();
        }
        
        
    }
    private boolean checkQuantities(){
        StringBuilder string=new StringBuilder();
        for(BillInfo currentItem:itemList){
            Items item=database.getItems().get(currentItem.getInvoiceItem());
            if(item.getAvailableQuantity()<currentItem.getItemQuantity()){
                if(string.length()>0)
                    string.append("\n");
                string.append("Enough quantities of " +currentItem.getInvoiceItem().substring(0,1).toUpperCase() + currentItem.getInvoiceItem().substring(1).toLowerCase()+" not available in the inventory to process your order.");
            }
            else{
                currentItem.setPrice(item.getItemPrice());
                if(!card.contains(currentItem.getCards()))
                    card.add(currentItem.getCards());
            }
        }
        if(string.length()>0){
            
            finalResult.add(string.toString());
        }

        return (string.length()==0);



    }
    private boolean checkMaxCategory(){
    	final int essentialCap = 3;
    	final int luxuryCap = 4;
        final int miscCap = 6;
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        DataBase database = DataBase.getInstance();
        for(BillInfo orderItem:itemList){
            hm.put(database.getItems().get(orderItem.getInvoiceItem()).getCategory(),hm.getOrDefault(database.getItems().get(orderItem.getInvoiceItem()).getCategory(),0)+orderItem.getItemQuantity());
        }

        if(hm.getOrDefault("Essentials",0)>essentialCap){
            finalResult.add("Maximum limit for 'Essentials' category has been reached");
            return false;
        }
        

        else if(hm.getOrDefault("Luxury",0)>luxuryCap){
            finalResult.add("Maximum limit for 'Luxury' category has been reached");
            return false;
        }

        else if(hm.getOrDefault("Misc",0)>miscCap){
            finalResult.add("Maximum limit for 'Miscellaneous' category has been reached");
            return false;
        }

        return true;
    }

    public void retrieveOutput(){
        if(finalResult.isEmpty()){
            finalResult.add("Payment Successful !!");
            finalResult.add("Amount Paid:="+ Double.toString(currentInvoice.getTotalPrice()));
            try{
            	
                file.writeResults(finalResult,false, itemList);
            }catch(Exception e){
               e.printStackTrace();
            }


        }else{
            try{
                file.writeResults(finalResult,true, itemList);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }



}
