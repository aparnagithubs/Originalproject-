package vTiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrialForSecondTime {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home ");
        driver.manage().window().maximize();
        
       
        driver.findElement(By.id(" "));
        driver.findElement(By.id(""));
	}

}
