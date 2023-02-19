package com.exceldata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
	
	@Test
	public void ExcelData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\beant\\OneDrive\\Desktop\\GitCode\\Book1.xlsx");
	
XSSFWorkbook wb = new XSSFWorkbook(fis);//excel sheet is open
XSSFSheet sheet = wb.getSheet("Sheet1");

XSSFRow  row = sheet.getRow(4);
XSSFCell cel = row.getCell(2);
System.out.println(cel);

System.out.println("*****Print line 4*****");
XSSFRow row3 = sheet.getRow(3);
int col = sheet.getRow(3).getLastCellNum();
 for(int c=0; c<col; c++)
 { 
	 XSSFCell cell= row3.getCell(c);
	 System.out.println(cell);
		
 }
 
 System.out.println("*****Print All records*****"); 
  int rows = sheet.getLastRowNum();
 int cols = sheet.getRow(1).getLastCellNum();
 for (int r=0; r<=rows ; r++)
 {
	 XSSFRow rowt= sheet.getRow(r);
	 for(int c=0; c<cols; c++)
	 { 
		 XSSFCell cell= rowt.getCell(c);
		 System.out.print(cell);
		 
		 System.out.print(" - ");
			
	 }
	 System.out.println();
 }
 
 
 
	}
}
