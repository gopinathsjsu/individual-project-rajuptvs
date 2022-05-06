package com.billingfactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.details.BillInfo;

public  interface BillHandler 
{
    public void writeToFile(ArrayList<String> content);
    public void saveFile (Path path, ArrayList<BillInfo> itemList) throws IOException;
    

}
