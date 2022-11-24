package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//declaration 
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	//initialization
	public  ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
//utilization
	public WebElement getContactHeaderText()
	{
		return ContactHeaderText;
		}
	//BusinessLibrary this method returns the header text and return it to the caller
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}

}
