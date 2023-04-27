package com.test.DemoQA;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpClientConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinks extends SetUp
{
   @Test
   
   public void VerifyLinks() throws MalformedURLException,IOException, InterruptedException 
   {
	   driver.findElement(By.xpath(prop.getProperty("Element"))).click();
	   driver.findElement(By.xpath(prop.getProperty("BrokeImage"))).click(); 
	   Thread.sleep(2000);
	List <WebElement>links =driver.findElements(By.tagName("a"));
	
	System.out.println(links.size());
	
	for(int i=0;i<links.size();i++) 
	{
	 WebElement element= links.get(i);
	 String Url= element.getAttribute("href");
	 
	 URL link= new URL(Url);
	 
	 HttpsURLConnection httpcon= (HttpsURLConnection)link.openConnection();
	 Thread.sleep(2000);
	 httpcon.connect();
		int rescode= httpcon.getResponseCode();
		
		if(rescode>=400)
		{
			System.out.println(Url+"-"+"Broken link");
		}
		else
		
			{
				System.out.println(Url+"-"+"Vaild link");
			}
		
	}
	   
	   
   }
	
}
