package com.Annotations;

import org.testng.annotations.Test;

public class Annotations1 {
	
	@Test(priority=0)
	public void launch()
	{
		System.out.println("Firefox Browser launch");
				
	}
	@Test(priority=1)
	public void LogIn()
	{
		System.out.println("Testing login functionality");
				
	}
	@Test(priority=2)
	public void Inbox()
	{
		System.out.println("Testing Inbox functionality");
				
	}
	@Test(priority=3)
	public void Composemail()
	{
		System.out.println("Testing Composemail functionality");
	}

}
