package vTiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTigerGenericLibrary.BaseClass;

@Listeners(vTigerGenericLibrary.ListenerImplemantationLibrary.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = "smokeSuite")
	public void createContactTest() throws EncryptedDocumentException, IOException 
	{
		//step 2 read all the required data
		String LASTNAME= eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		
		//step 5 navigate to contacts link
		HomePage hp= new HomePage(driver);
		hp.clickContactsLnk();
		
		//step6 navigate to create contact look up image
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		//step 7 create contact with mandatory details n save
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		
     }
}
