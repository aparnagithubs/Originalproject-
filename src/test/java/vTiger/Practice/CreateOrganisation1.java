package vTiger.Practice;

        import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

		public class CreateOrganisation1 {

			public static void main(String[] args) throws Exception {
				//step-1 launch the browser
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				//step-2  creating file stream object to get properties file.
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				
				//step-3 load properties file from file stream
				Properties p=new Properties();
				p.load(fis);
								
				//step-4 load the application
				driver.get(p.getProperty("url"));
								
				//step-5 login to application
				driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
				driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
				driver.findElement(By.id("submitButton")).click();

			}

		}




