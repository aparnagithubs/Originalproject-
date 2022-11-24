package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  
	//rule1  create a separate java class for every webpage
	
	//rule2 identify the elements using @FindBy,@FindAll,@FindBys
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindAll({@FindBy(name="user_password")})
    private WebElement passwordEdt;
	
//	@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
//	private WebElement passwordEdt; syn for @FindBys annotations
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule 3create a constructor initialise these variables
	public LoginPage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);	
	}
	//rule4 provide getter method access these variables
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	/**
	 * business library
	 * this method will perform login operation
	 * param username
	 * param password
	 */
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
