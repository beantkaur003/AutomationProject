package com.test.DemoQA;

import org.openqa.selenium.By;

public class HandleBrowserWindows extends SetUp {
	
	public void HandleWindow() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("Element"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("links"))).click();
		driver.findElement(By.xpath(prop.getProperty(""))).click();
		
		
	}

}
