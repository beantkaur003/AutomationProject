package com.test.DemoQA;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Alerts extends SetUp{
     @Test
	public void HandleAlerts() throws InterruptedException
	{   
		driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("alert"))).click();
		
		//simple Alert
		driver.findElement(By.xpath(prop.getProperty("simpleralert"))).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		//Alert after 5 sceonds
		driver.findElement(By.xpath(prop.getProperty("fivesecalert"))).click();
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		
		//confirmation alerts
		driver.findElement(By.xpath(prop.getProperty("confirmalert"))).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(prop.getProperty("conformalert"))).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		
		//Prompt Alerts		
		driver.findElement(By.xpath(prop.getProperty("promtalert"))).click();
		Thread.sleep(1000);
		Alert alertwindow= driver.switchTo().alert();
		String alerttext= alertwindow.getText();
		System.out.println("Text is---"+ alerttext);
		alertwindow.sendKeys("Your Welcome");
		alertwindow.accept();
		
	}
	
}
