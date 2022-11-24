package vTigerGenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	// create objects of all generic libraries so that we use 
	public PropertyFileLibrary pLib= new PropertyFileLibrary();
	public ExcelFileLibrary eLib= new ExcelFileLibrary();
	public JavaLibrary jLib =new JavaLibrary();
	public WebDriverLibrary wLib = new WebDriverLibrary();
	public WebDriver driver=null;
	public static WebDriver sDriver;//to use this in other classes 
	
   
	@BeforeSuite(groups= {"smokeSuite","regressionSuite"})
    public void bsConfig()
    {
    	System.out.println("---database connection successful aparna ");
    }
    //@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups={"smokeSuite","regressionSuite"})
    public void bcConfig(/*String BROWSER*/) throws IOException//launch the browser
    { 
    	String BROWSER= pLib.readDataFromPropertyFile("browser");//wrote this method in property lib
    	String URL= pLib.readDataFromPropertyFile("url");
    	
    	if (BROWSER.equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		 driver = new ChromeDriver();
        	System.out.println("--Browser launched successful ");
        }
    	else if (BROWSER.equalsIgnoreCase("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    	}
    	else
    	{ System.out.println("invalid browser");}
    	sDriver=driver;
    	wLib.maximiseWindow(driver);
    	wLib.waitForPageLoad(driver);
    	driver.get(URL);
    }
    @BeforeMethod(groups= {"smokeSuite","regressionSuite"})
    public void bmConfig() throws IOException 
    {
    	String USERNAME = pLib.readDataFromPropertyFile("username");
        String PASSWORD= pLib.readDataFromPropertyFile("password");
        LoginPage lp=new LoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);
        System.out.println("login is successful");
    }
    @AfterMethod(groups= {"smokeSuite","regressionSuite"})
    public void amConfig() 
    {
    	HomePage hp=new HomePage(driver);
    	hp.SignOutOfApp(driver);
    }
    @AfterSuite(groups= {"smokeSuite","regressionSuite"})
    public void asConfig()
    {
    	System.out.println("--database connection closed successful");
    }
    
    
}
