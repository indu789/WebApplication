package com.Annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class New_Tours_Application_LogIn_Testing {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
	    driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
	}
	@Test
	public void Login()
	{
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	String expected_Title="Find";
	String actual_Title=driver.getTitle();
	if(actual_Title.contains(expected_Title))
	{
	System.out.println("Title matched---Pass");
	
	}
	else
	{
		System.out.println("Title Not matched---Fail");
	}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
