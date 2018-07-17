package com.KeyWord;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_LoginTest {
	FirefoxDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
	driver.get("http://newtours.demoaut.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
	}
	@Test
	public void LogIn() throws IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Indumathi\\Desktop\\InduSelenium\\WebApplicationTesting\\NewToursApp.properties");
		Properties pr = new Properties();
		pr.load(file);
		driver.findElement(By.name(pr.getProperty("Uname"))).sendKeys("sath");
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys("Feltham089");
		driver.findElement(By.name(pr.getProperty("SignIn"))).click();
		
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
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
