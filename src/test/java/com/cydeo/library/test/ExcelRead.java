package com.cydeo.library.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    @Test
     public void readFromExcelFile() throws IOException {
        String path="SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Employees");

        System.out.println(sheet.getRow(1).getCell(0));

        System.out.println(sheet.getRow(3).getCell(2));
        //Return the count of used cells only
        //Start counting from1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Return the number from top cell to bottom cell
        //It doesn't care if the cell is empty or not
        //Start counting from 0

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        //TODO: Create a logic to print Vincent's name
        for (int rowNum = 0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vincent")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }

        }
        //TODO: Create a logic to print out Helen's Job_ID
        for (int rowNum=0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Helen")){
                System.out.println("Helen's Job ID is "+sheet.getRow(rowNum).getCell(2));
            }
        }
    }
}
