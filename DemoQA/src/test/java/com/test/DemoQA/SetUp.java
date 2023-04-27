package com.test.DemoQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetUp {
	Properties prop = new Properties();
	FileInputStream fis;
	WebDriver driver;
	
	@BeforeClass
	public void Initalization() throws IOException
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
		prop.load(fis);
		 driver = new ChromeDriver();
		driver.get(prop.getProperty("QA_Url"));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		//driver.findElement(By.xpath(prop.getProperty("Element"))).click();
		
	}
	
	@AfterClass
	public void Cleanup() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
