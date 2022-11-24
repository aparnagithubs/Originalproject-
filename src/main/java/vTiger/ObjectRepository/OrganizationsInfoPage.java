package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class OrganizationsInfoPage extends WebDriverLibrary  {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Orgheader;
	
	//intialization
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
    //utilization
	public WebElement getOrgheader()
	{ return Orgheader;}
	//Business library
	public String getOrgHeader() {
		return Orgheader.getText();}
	
}
