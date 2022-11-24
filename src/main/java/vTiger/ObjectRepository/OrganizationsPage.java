package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class OrganizationsPage extends WebDriverLibrary{
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getCreateOrgImg()
	{
		return createOrgImg;
	}
	//business library 
	/**this method will click onn create organization look up image
	  */
	public void clickOnCreateOrgImg()
	{
		createOrgImg.click();
	}
}
