package com.test.DemoQA;


import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebTableTestCase_001 extends SetUp{
	
	 public int invalidImageCount;
	 
	// @BeforeTest
	 public void Elements()
	 {
	 
	 }
	@Test
	
	public void TextBox() throws InterruptedException
	{ 
		//driver.findElement(By.xpath(prop.getProperty("Element"))).click();
	  driver.findElement(By.xpath(prop.getProperty("Element"))).click();
	  Thread.sleep(2000);	
	  driver.findElement(By.xpath(prop.getProperty("textbox"))).click();
	  driver.findElement(By.xpath(prop.getProperty("fullname"))).sendKeys("Beant Kaur Matyar");
	  driver.findElement(By.xpath(prop.getProperty("Email"))).sendKeys("Beantkaur003@gmail.com");
	  String Caddress= "3345 red river rd\n ontrio\n PostalCode-K3W1S2";
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(prop.getProperty("currentaddress"))).sendKeys(Caddress);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(prop.getProperty("permanentaddress"))).sendKeys(Caddress);
	  Thread.sleep(1000);
      driver.findElement(By.xpath(prop.getProperty("Submit"))).click();
	  
	}
	 
	 
	@Test
	public void WebTableTestCase() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(prop.getProperty("WebTables"))).click();
		driver.findElement(By.xpath(prop.getProperty("Add"))).click();
		driver.findElement(By.xpath(prop.getProperty("Firstname"))).sendKeys("Beant");
		driver.findElement(By.xpath(prop.getProperty("Lastname"))).sendKeys("Kaur");
		driver.findElement(By.xpath(prop.getProperty("Email"))).sendKeys("bkaur@gmail.com");
		driver.findElement(By.xpath(prop.getProperty("Age"))).sendKeys("27");
		driver.findElement(By.xpath(prop.getProperty("Salary"))).sendKeys("25000");
		driver.findElement(By.xpath(prop.getProperty("Department"))).sendKeys("Software Testing");
		driver.findElement(By.xpath(prop.getProperty("Submit"))).click();
		driver.findElement(By.xpath(prop.getProperty("Edit"))).click();
		driver.findElement(By.xpath(prop.getProperty("Editname"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Editname"))).sendKeys("Alex");
		String classname =driver.findElement(By.xpath(prop.getProperty("Submit"))).getAttribute("class");
System.out.println(classname);



		
	}
	
	@Test
	public void BrokenImage()
	{
		int invalidImageCount=0;
		driver.findElement(By.xpath(prop.getProperty("BrokeImage"))).click();
		try {
			
			List<WebElement> imagesList = driver.findElements(By.xpath("//div/img"));
			System.out.println("Total no. of images are " + imagesList.size());
			
			System.out.println(imagesList.get(0).getAttribute("src"));
			System.out.println(imagesList.get(1).getAttribute("src"));
			//System.out.println(imagesList.get(0).getAttribute("src"));
			for (WebElement imgElement : imagesList)
			{                      
				
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(imgElement.getAttribute("src"));
				HttpResponse response = client.execute(request);
				
				System.out.println("response of image"+response);
				// verifying response code he HttpStatus should be 200 if not,
				// increment as invalid images count
				if (response.getStatusLine().getStatusCode() != 200)
					
					System.out.println(imagesList.get(invalidImageCount).getText());
					invalidImageCount++;
			
			}	
	//		System.out.println(invalidImageCount++);
			} 
			catch (Exception e) 
		    {
				e.printStackTrace();
			}
    	}
	
	@Test
	public void VerifyCheckbox()
	
	{
		driver.findElement(By.xpath(prop.getProperty("checkbox"))).click();
		driver.findElement(By.xpath(prop.getProperty("Expandhome"))).click();
		driver.findElement(By.xpath(prop.getProperty("homeclick"))).click();
		//WebElement checkbox1 = driver.findElement(By.xpath(prop.getProperty("homeselected")));
		
		
		String Expectedclassname =driver.findElement(By.xpath(prop.getProperty("homeselected"))).getAttribute("class");
		System.out.println(Expectedclassname);
		Assert.assertEquals(Expectedclassname, "rct-icon rct-icon-check"); //true

		/* Check if the CheckboxSelected
		if (checkbox1.isSelected()) {
		    System.out.println("Checkbox is already selected");
		} else {
		    // If the checkboxnotselected
		    checkbox1.click();
		    System.out.println("Checkbox is now selected");
		}*/
		
		}
	@Test
	public void VerifyRadioButton() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("Radiobutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Clickradio"))).click();	
		String radiotext2 =driver.findElement(By.xpath(prop.getProperty("Getradioname"))).getText();
		String radiotext1 =driver.findElement(By.xpath(prop.getProperty("GetradiotextY"))).getText();
		//System.out.println(radiotext1);
		
		Assert.assertEquals(radiotext1, radiotext2);
		
	}
	
	@Test
	public void Buttons() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("buttons"))).click();
		WebElement Button= driver.findElement(By.xpath(prop.getProperty("doubleclick")));
		Thread.sleep(1000);
		Actions action= new Actions(driver);
		action.doubleClick(Button).perform();
		Thread.sleep(1000);
		WebElement ClickR= driver.findElement(By.xpath(prop.getProperty("rightclick")));
		action.contextClick(ClickR).perform();
		driver.findElement(By.xpath(prop.getProperty("clickme"))).click();
		Thread.sleep(1000);
		
	}
	@Test
	public void uploaddownload() throws InterruptedException
	
	{ driver.findElement(By.xpath(prop.getProperty("Element"))).click();
	 //upload a file
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
	
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("updownfile"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("choosefile"))).sendKeys("C:\\Users\\beant\\OneDrive\\Pictures\\Planet9");
		driver.findElement(By.xpath(prop.getProperty("download"))).click();
		Thread.sleep(2000);
	}
	
}
