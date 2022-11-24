package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassPractice {
	@BeforeClass 
	public void bcConfig()
	{
	  System.out.println(" before class");	
	}
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method");
	}
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("beforesuite--");
		
	}
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class$$$");
	}
   @AfterMethod
   public void amConfig()
   {
	   System.out.println("after mmmmethod");
   }
   @AfterSuite
   public void asConfig()
   {
	   System.out.println("after sssuite");
   }
}