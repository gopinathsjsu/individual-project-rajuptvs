package com.billingfactory;

public class BillFactory 
{
	public BillHandler getResult(boolean res)
	{	
	      if(res == false)
	      {
	         return new CreateBillCsv();
	         
	      } else if(res == true)
	      {
	         return new CreateErrorLogs();
	         
	      }
	      
	      return null;
	   }
}
