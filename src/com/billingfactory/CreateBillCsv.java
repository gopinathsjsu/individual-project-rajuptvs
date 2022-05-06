package com.billingfactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.details.BillInfo;

import java.nio.file.Files;



public class CreateBillCsv implements BillHandler {
    private ArrayList<String> content=new ArrayList<String>();
    @Override
    public void writeToFile(ArrayList<String> orderDetails){
    	
        content=orderDetails;
        
    }
    @Override
    public void saveFile(Path filePath, ArrayList<BillInfo> items)throws IOException 
    {
    	
    	File newfile = new File(filePath.toString()+"Outputbill.csv");	
    	FileWriter outputfile = new FileWriter(newfile);
	      StringBuilder string = new StringBuilder();
	      string.append("Item");
	      string.append(',');
	      string.append("Quantity");
	      string.append(',');
	      string.append("Price");
	      string.append(',');
	      string.append("TotalPrice");
	      string.append('\n');
	      int count = 0;
	      
	      double totalprice = 0;
	        for(int i=0;i<items.size();i++)
	        {
	        	totalprice += items.get(i).getItemQuantity() * items.get(i).getPrice();
	        }
	      for(int i=0;i<items.size();i++) {
        	  count++;
        	  string.append(items.get(i).getInvoiceItem().substring(0,1).toUpperCase() + items.get(i).getInvoiceItem().substring(1).toLowerCase());
		      string.append(',');
		      string.append(items.get(i).getItemQuantity());
		      string.append(',');
		      string.append(items.get(i).getPrice());
		      if(count==1) {
		    	  string.append(',');
		    	  string.append(totalprice);
		      }
		      string.append('\n');
          }
	      
	      outputfile.write(string.toString());
	      
	      System.out.println(newfile.getName()+" -> Output file has been created at "+filePath.getParent().toString());
	      
	      
	      outputfile.close();
	      
        
        
        
    }

}
