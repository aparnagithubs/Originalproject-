package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary{
	//declaration
	@FindBy(name="lastname") 
	private WebElement lastNameEdt;
	
	@FindBy(name="leadsource") 
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@name='account_name']/followintsibling::img[@title='select']")
	private WebElement organizationImg;
	@FindBy(name="search_text")
	private WebElement searchEdt;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") 
	private WebElement saveBtn;
  
	//Initialzation
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//utilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Businesslibrary this method will create new contacct with lastname 
	//param lastname
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
	}
	
	public void createNewContact(String lastName,String ORGNAME,WebDriver driver)
	{
		lastNameEdt.sendKeys(lastName);
		organizationImg.click();
		switchToWindow(driver,"Accounts");		
		searchEdt.sendKeys(ORGNAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME +"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
	/**
	 * this will create new contact with lead source dropdown 
	 * @author Family
	 * @param lastname
	 * @param leadSourceValue
	 * */
public void CreateNewContact(String lastName,String leadSourceValue)
{
	lastNameEdt.sendKeys(lastName);
	handleDropDown(leadSourceDropDown,leadSourceValue);
	saveBtn.click();
}
}
