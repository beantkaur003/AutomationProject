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


		
	}

}
