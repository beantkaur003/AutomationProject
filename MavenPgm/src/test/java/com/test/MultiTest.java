package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {
	
	WebDriver driver;
	
 @BeforeClass
 public void Initalization()
 {
	driver = new ChromeDriver();
		
		driver.get("https://amazon.com");
		
		driver.manage().window().maximize();
 }
	
	@Test(priority=1)
	public void MouseHovering() throws InterruptedException
	{

		
	WebElement  accountlist = 	driver.findElement(By.xpath("//span[text()='Account & Lists']"));
	
	Actions act = new Actions(driver);
	
	act.moveToElement(accountlist).perform();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[text()='Account']")).click();
	
	
	}
	
	@Test(priority=2)
	public void AdvanceDropDown() throws InterruptedException
	{
		
		 Thread.sleep(2000);
		 
		 WebElement dropdwn = driver.findElement(By.id("searchDropdownBox"));
		 
		 Select sel = new Select(dropdwn);
		 
		 List<WebElement> li = sel.getOptions();
		 
		 System.out.println(li.size());
		 
		 for(int i= 0 ; i<li.size();i++)
		 {
			 li.get(i).click();
			 System.out.println(li.get(i).getText());
		 }
		 

	}
	
	@AfterClass
	public void CleanUp()
	{
driver.quit();
	}

}
