package vTigerOrganizations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTigerGenericLibrary.ExcelFileLibrary;
import vTigerGenericLibrary.JavaLibrary;
import vTigerGenericLibrary.PropertyFileLibrary;
import vTigerGenericLibrary.WebDriverLibrary;

public class CreateMultipleOrganizationWithIndustryTest {
	
	// Step 1: Create Object of all the libraries
				JavaLibrary jLib = new JavaLibrary();
				PropertyFileLibrary pLib = new PropertyFileLibrary();
				ExcelFileLibrary eLib = new ExcelFileLibrary();
				WebDriverLibrary wLib = new WebDriverLibrary();

				//create a dataprovider 
				 
				@Test(dataProvider = "MultipleOrganizations")
				public void createMultipleOrgTest(String orgName,String indType) throws IOException 
				{
					String Org= orgName+jLib.getRandomNumber();
					
				
				// Step 2: read all the required data
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");

				WebDriver driver = null;

				// Step 3: launch the browser
				if (BROWSER.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} 
				else {
					System.out.println("invalid browser name");
				}

				wLib.maximiseWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(URL);

				// Step 4: Login to Application
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME,PASSWORD);
				
		     	//Step 5: Navigate to Organizations link
			    HomePage hp= new HomePage(driver);
			    hp.clickOrganizationsLnk();
							
				//Step 6: Navigate to create Organizations look up image
			    OrganizationsPage op= new OrganizationsPage(driver);
			    op.clickOnCreateOrgImg();
			    
			    //Step 7: Create new organization and save
			    CreateNewOrganizationPage cnop =new CreateNewOrganizationPage(driver);
			    cnop.createNewOrg(orgName,indType);//failed exception
			    
			    //step8 validate 
			    OrganizationsInfoPage oip= new OrganizationsInfoPage(driver);
			     String orgHeader =oip.getOrgHeader();
			    if(orgHeader.contains(Org))
			    {
			    	System.out.println(orgHeader);
			    	System.out.println("pass");
			    }
			    else
			    {
			    	System.out.println("Fail");
			    }
			    //step 9 logout
			    hp.SignOutOfApp(driver);
			}
				
				@DataProvider(name="MultipleOrganizations")
				public Object[][] getData() throws EncryptedDocumentException, IOException 
				{
					Object[][] data=eLib.readMultipleData("MultipleOrganization");
					return data;
				}
}
