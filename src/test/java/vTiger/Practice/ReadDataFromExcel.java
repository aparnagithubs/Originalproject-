package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromExcel {

	
		public static void main(String[] args) throws IOException {
			//step1: read the required data from common Data 
			FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\commonData.properties ");
			Properties pobj= new Properties();
			pobj.load(fis);
			
			String BROWSER= pobj.getProperty("browser");
			String URL = pobj.getProperty("url");
			String USERNAME=pobj.getProperty("username");
			String PASSWORD=pobj.getProperty("password");
			
			//step2: read from the xl sheet
	        FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb= WorkbookFactory.create(fis1);
			Sheet sh=wb.getSheet("Contacts");
			Row rw= sh.getRow(1);
			Cell cl=rw.getCell(2);
			
			String lastname=cl.getStringCellValue();
			WebDriver driver=null;
			//step 3 launch the browser Run time polymorphism
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				System.out.println("{{{{{"+BROWSER+"}}}}}}IS LAUNCHED" );
		    }
			
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				System.out.println("{{{{{"+BROWSER+"}}}}}}}IS LAUNCHED" );
		    }
				
			else
				{System.out.println("Invalid browser name");}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			//step3 login to application
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("root");
			driver.findElement(By.id("submitButton")).click();
			
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
