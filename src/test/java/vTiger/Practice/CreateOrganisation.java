package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation {

		public static void main(String[] args) throws Throwable {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8888/index.php?action=Login&module=Users");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("root");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys("rajini");
			driver.findElement(By.name("button")).click();
			Thread.sleep(5000);
			Alert a=driver.switchTo().alert();
			a.accept();
			
			Actions ac=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
			ac.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			driver.close();
			

	}

}
