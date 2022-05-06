package com.billingfactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.details.BillInfo;

public class CreateErrorLogs implements BillHandler {
    private ArrayList<String> content;
    @Override
    public void writeToFile(ArrayList<String>errorMessage){
        content=errorMessage;
    }
    @Override
    public void saveFile(Path filePath, ArrayList<BillInfo> itemList)throws IOException{
        FileWriter errorFile=new FileWriter(filePath.toString()+"/error_log.txt");
        for(String contentLine:content)
            errorFile.write(contentLine+"\n");
        errorFile.close();
    }


}
