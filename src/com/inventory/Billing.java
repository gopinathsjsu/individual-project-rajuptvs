package com.inventory;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.controller.Orders;
import com.database.DataBase;

public class Billing {
	
    public static void main(String args[])throws IOException{
        Billing bill=new Billing();
        bill.initiateBilling(args);
    }
    private void initiateBilling(String[] args){
        
    	DataBase db = DataBase.getInstance();
    	db.initiateDB();
    	System.out.println("Data has been loaded");

        	Scanner sc=new Scanner(System.in);
            System.out.println("Please enter the input file path");
            String inputPath="";
            try{
                inputPath=sc.next();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            initiateTransaction(inputPath);
        
        
    }
    private void initiateTransaction(String filePath){
        Orders Orders=new Orders(filePath);
        Path path = Paths.get(filePath);
        if(Orders.startOrder()){
            if(Orders.validateOrder()) {
                Orders.calcTotalPrice();
                Orders.checkoutTransaction();
                System.out.println("Your order has been placed successfully.");

            }else{
            		
                    System.out.println("There is an issue with the order, Please check the error logs located in the below location");
                    Orders.retrieveOutput();
                    System.out.println(path.getParent().toString());
                    
                }
            }
            else{
                System.out.println("Invalid Path !!!");
            }
        }

    }




