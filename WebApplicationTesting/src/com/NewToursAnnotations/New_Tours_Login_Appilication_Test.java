package com.NewToursAnnotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class New_Tours_Login_Appilication_Test {
	
	FirefoxDriver driver;
	@BeforeMethod
	 public void setup() {
	    driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.newtours.demoaut.com");
	}
	@Test
	public void LogIn() {
	
	driver.findElement(By.name("userName")).sendKeys("tutorial");
	driver.findElement(By.name("password")).sendKeys("tutorial");
	driver.findElement(By.name("login")).click();

	 String expected_Title = "Find";
	 String actual_Title = driver.getTitle();
	 
	   if (actual_Title .contains(expected_Title))
	   {
		 System.out.println("Title matched ........Pass");
		
	   }
	   else
	   {
		 System.out.println("Title not matched ........Fail");
	   }
	   
	   }
	 @AfterMethod
	   public void tearDown()
	   {
	   driver.close();
	   }
	 
}
