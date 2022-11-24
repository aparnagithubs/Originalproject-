package vTigerOrganizations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTigerGenericLibrary.ExcelFileLibrary;
import vTigerGenericLibrary.JavaLibrary;
import vTigerGenericLibrary.PropertyFileLibrary;
import vTigerGenericLibrary.WebDriverLibrary;

public class PomPracticeForCreateOrganizationWithIndustry {

	public static void main(String[] args) throws IOException  {
		
		//step1: create object for all the libraries
		JavaLibrary jLib=new JavaLibrary();
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		ExcelFileLibrary eLib =new ExcelFileLibrary();
		WebDriverLibrary wLib =new WebDriverLibrary();
		
		//step 2 read all the required data
		String BROWSER= pLib.readDataFromPropertyFile("browser");
		String URL=pLib.readDataFromPropertyFile("url");
		String USERNAME= pLib.readDataFromPropertyFile("username");
		String PASSWORD =pLib.readDataFromPropertyFile("password");
       
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		
		WebDriver driver=null;
		//step3  launch the browser 
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.println(" Invalid Browser name");
		}
		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//step4 login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step5 navigate to organizations link
		HomePage hp= new HomePage(driver);
		hp.clickOrganizationsLnk();
		
		//step6 navigate to create organizations look up image
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		//step7 create new organization and save create new organizations 
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME);
		
		//step8 validate for organization 
		OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
		String orgHeader=oip.getOrgHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization created sucessfully");
		}
		else 
		{
			System.out.println("Organization not created");
		}
		//step 9 navigate to contacts link
		hp.clickContactsLnk();
		
		//step 10 navigate to create contact look up image
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//step 11 create contact with mandatory fields 
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME,ORGNAME,driver);
		
		//step 12 validate for contact
		ContactsInfoPage cip= new ContactsInfoPage(driver);
		String contactHeader =cip.getContactHeader();
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader);
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("fail");
		}
		//step14 logout of the application
		hp.SignOutOfApp(driver);
		}

}
