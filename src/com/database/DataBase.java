package com.database;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.details.Bill;
import com.details.Items;

public class DataBase {
    //Singleton Pattern Implementation.
    private static DataBase instance;
    private HashMap<String, Items> inventory=new HashMap<String, Items>();
    private HashSet<String> cardsList=new HashSet<String>();
    private ArrayList<Bill> orders=new ArrayList<Bill>();
    private DataBase(){}; 
    //Initiated through static method
    public static DataBase getInstance(){
        if(instance == null)
            instance=new DataBase();
        return instance;
    }
    public HashMap<String, Items> getItems() {
        return inventory;
    }

    public ArrayList<Bill> getOrders() {
        return orders;
    }

    public HashSet<String> getCards() {
        return cardsList;
    }
    
    public void initiateDB()
    {
    	
    	//Items added 
    	inventory.put("shampoo", new Items("Essentials","shampoo",200,10));
    	inventory.put("soap", new Items("Essentials","soap",200,5));
    	inventory.put("clothes", new Items("Essentials","clothes",100,20));
    	inventory.put("milk", new Items("Essentials","milk",100,5));
    	inventory.put("handbag", new Items("Luxury","handbag",75,150));
    	inventory.put("perfume", new Items("Luxury","perfume",50,50));
    	inventory.put("chocolates", new Items("Luxury","chocolates",300,3));
    	inventory.put("wallet", new Items("Luxury","wallet",100,100));
    	inventory.put("bedsheet", new Items("Misc","bedsheet",150,75));
    	inventory.put("footware", new Items("Misc","footware",200,25));
    	inventory.put("homedecorpiece", new Items("Misc","homedecorpiece",100,40));
    	inventory.put("pen", new Items("Misc","pen",400,3));
    	inventory.put("pencil", new Items("Misc","pencil",400,3));
    	
    	//Adding cards to the static DB
    	cardsList.add("5410000000000000");
    	cardsList.add("4120000000000");
    	cardsList.add("341000000000000");
    	cardsList.add("6010000000000000");
    	
    }
}
