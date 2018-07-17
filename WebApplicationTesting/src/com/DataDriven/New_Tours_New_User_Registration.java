package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New_Tours_New_User_Registration 
{
		
		FirefoxDriver driver;
		@BeforeTest
		public void setup() 
		{
		 driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		}
		
		  @Test(priority = 0)
		  public void register()
		    {
			//Register
			//<a href="mercuryregister.php">REGISTER</a>
		    driver.findElement(By.linkText("REGISTER")).click() ;
		    System.out.println("Check register functionality");
		    }
		  @Test(priority=1)
		   public void UserRegistration() throws IOException 
		   {
			  FileInputStream file = new FileInputStream("C:\\Users\\Indumathi\\Desktop\\InduSelenium\\WebApplicationTesting\\src\\com\\DataDriven\\NewtoursRegMultipleData.xlsx");
		       XSSFWorkbook wb = new XSSFWorkbook(file);
		       XSSFSheet Sheet = wb.getSheet("Sheet1");
		      int RowCount = Sheet.getLastRowNum();
		      
		      for ( int i=1;i<RowCount;i++)
		      {
		       
		    	Row  r=Sheet.getRow(i);
		   driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());

		   driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
		  // double d=r.getCell(2).getNumericCellValue();
		   //  Long x=(long)d;
		   // String phone =Long.toString(x);//
		  
		   driver.findElement(By.name("phone")).sendKeys(r.getCell(2).getStringCellValue());

		   driver.findElement(By.id("userName")).sendKeys(r.getCell(3).getStringCellValue());
		   
			driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
		    
			driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
		      
			driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
			   
			driver.findElement(By.name("postalCode")).sendKeys(r.getCell(7).getStringCellValue());
		   
			driver.findElement(By.name("country")).sendKeys(r.getCell(8).getStringCellValue());
		      
			driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
		     
			driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
		      
			driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
		   
			driver.findElement(By.name("register")).click();
		String  expected_UserName =r.getCell(9).getStringCellValue(); 	
	     String actual_RegisterdText = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	     
	     if(actual_RegisterdText.contains(expected_UserName))
	     {
	     System.out.println("User Register Sucsessfully---PASS");
	     r.createCell(12).setCellValue("User Register Sucsessfully---PASS");
	     }
	     else
	      {
	  	 System.out.println("User Register fail---FAIL"); 
	  	 r.createCell(12).setCellValue("User Register fail---FAIL");
	       }
	     FileOutputStream file1 =new FileOutputStream("C:\\Users\\Indumathi\\Desktop\\InduSelenium\\WebApplicationTesting\\src\\com\\ApplicationTestResultsFiles\\userregestrationresults.xlsx");
	      wb.write(file1);
	     driver.navigate().back();
		   }
		   }
		  
	 	@AfterTest
	 	public void teardown() 
	 	{
	 		driver.quit();
	 		
	 	}
		  
		     
	}
	


