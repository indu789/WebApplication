package com.Annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations2 {
	@BeforeTest
	public void AppLaunchAndLogIn()
	{
		System.out.println("Open Application and LogIn");
	}
	@Test(priority=0)
	public void Inbox()
	{
		System.out.println("Testing Inbox functionality");
				
	}
	@Test(priority=1)
	public void Composemail()
	{
		System.out.println("Testing Composemail functionality");
	}
	@AfterTest
	
	public void ApplicationClose()
	{
		System.out.println("Application Close");
				
	}

	

}
