package com.billingfactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.details.BillInfo;

public class ModifyBill {
    Path filePath;
    BillHandler fileHandle;
    private ArrayList<String> fileContent = new ArrayList<String>();

    public ModifyBill(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public void readFile(boolean ignoreFirst) throws IOException {
        if (Files.notExists(filePath)) {
            new IOException();
        }
        BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));
        String contentLine = "";
        while ((contentLine = br.readLine()) != null) {
            if (ignoreFirst) {
                ignoreFirst = false;
                continue;
            }
            fileContent.add(contentLine);

        }
    }

    public ArrayList<String> getContent() {
        return fileContent;
    }

    public void writeResults(ArrayList<String> message, boolean checkIfError, ArrayList<BillInfo> itemList) throws IOException 
    {
    	BillFactory billFactory = new BillFactory();
    	BillHandler fileHandle = billFactory.getResult(checkIfError);
        fileHandle.writeToFile(message);
        fileHandle.saveFile(filePath.getParent(), itemList);

    }
}
