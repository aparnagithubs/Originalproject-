package vTiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import vTigerGenericLibrary.BaseClass;

public class CreateContact extends BaseClass {

	@Test
	public void createContactTest()
	  {
		
        		
        		//step-4 nagivate to contacts link
        		driver.findElement(By.linkText("Contacts")).click();
        		
        		//step-5 create contact with mandatory fields
        		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        		driver.findElement(By.name("lastname")).sendKeys("chatra");
        		
        		//step-6 save
        		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
        		
        		//step-7 logout from application
        		WebElement elemen=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        		
        		Actions act=new Actions(driver);
        		act.moveToElement(elemen).perform();
        		
        		driver.findElement(By.linkText("Sign Out")).click();
        		
        		//step-8 close the application
        		driver.quit();
        	}

      }
        
        
		

