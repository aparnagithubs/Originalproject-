package vTiger.Practice;

		import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class CreateOrganizationDDT {

			public static void main(String[] args) throws Exception {
				
				//step -1 read the required data
				FileInputStream file = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				Properties p = new Properties();
				p.load(file);
				
				String BROWSER = p.getProperty("browser");
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				
				WebDriver driver = null;
				//step-2  Launch the browser
				if(BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("=== "+BROWSER+" is launched ===");
				}
				else if(BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println("=== "+BROWSER+" is launched ===");;
				}
				else {
					System.out.println("Invalid driver configuration ");
				}
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				//step-3 load the aplication 
				driver.get(URL);
				
				//step-4 login to the application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//step-5 navigating to organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step-6 create an organization with mandatory fields
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.className("detailedViewTextBox")).sendKeys("QSP");
				
				//step-7 save 
				driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
				
				//step-8 logout from the application
				
				
//				WebElement elemen=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//				
//				WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//a[text()='Sign Out']"), true));
//				Actions act=new Actions(driver);
//				
//				act.moveToElement(elemen).perform();
				
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign Out']")));
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
				//step-8 close the application
				driver.quit();
			}

	}

