package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTigerGenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
	//declaration
	@FindBy(linkText="Organizations")
    private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getOrganizationsLnk()
	{
		return OrganizationsLnk;
	}
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}
	public WebElement getProductsLnk() {
		return ProductsLnk;
	}
	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	/**this method will click on Organizations link
	 * 
	 */
	public void clickOrganizationsLnk()
	{
		OrganizationsLnk.click();
	}
	/*this method will click on contacts
	 * 
	 */
	public void clickContactsLnk()
	{
		ContactsLnk.click();
	}
	public void SignOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver,AdministratorImg);
		SignOutLnk.click();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
