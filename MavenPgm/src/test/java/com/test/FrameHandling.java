package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FrameHandling {
	
	@Test

	public void Frame() throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriver driver = new ChromeDriver();
		
		driver.get("https://yatra.com");
		
		driver.manage().window().maximize();
		
		WebElement  Support = 	driver.findElement(By.xpath("//a[text()='Support ']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(Support).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Talk To Us']")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("iframeChatBot");
		
		driver.findElement(By.xpath("//button[text()='Cancellation']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("chatbot_close_button")).click();
		
		driver.quit();

	}

}
