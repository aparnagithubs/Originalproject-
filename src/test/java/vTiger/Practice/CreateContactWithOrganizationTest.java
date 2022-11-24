package vTiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTigerGenericLibrary.BaseClass;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
	//step 2 read all the required data
	String LASTNAME =eLib.readDataFromExcel("Contacts", 4, 2);
	String ORGNAME= eLib.readDataFromExcel(LASTNAME, 4, 3)+jLib.getRandomNumber();
	
	//step 5 navigate to Organizations link
	HomePage hp= new HomePage(driver);
	hp.clickOrganizationsLnk();
	
	//step6. navigate to create Organizations lookup image
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgImg();
	
    // step 7 create new organization and save
	CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
	cnop.createNewOrg(ORGNAME);
	
	//step 8 validate for Organization
	/*OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
	String orgHeader =oip.getOrgHeader();
	if(orgHeader.contains(ORGNAME))
	{
		System.out.println(orgHeader);
		System.out.println("Organization created successfully");
	}
	else
	{
		System.out.println("Organization not created");
	}*/
	OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
	String orgHeader = oip.getOrgHeader();
	Assert.assertTrue(orgHeader.contains(ORGNAME), "Organization created");
	
	//step 9 navigate to contacts link
	hp.clickContactsLnk();
	//step10 navigate to create contact look up image
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactImg();
	
	//step 11 create contact with mandatory details
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.createNewContact(LASTNAME, ORGNAME, driver);
	
	//step12 validate for contact
	/*ContactsInfoPage cip= new ContactsInfoPage(driver);
	String contactHeader= cip.getContactHeader();//bug
	if(contactHeader.contains(LASTNAME))
	{
		System.out.println(contactHeader);
		System.out.println("pass");
	}
	else 
	{ System.out.println("fail");}
	
	}*/
	ContactsInfoPage cip = new ContactsInfoPage(driver);
	String contactHeader = cip.getContactHeader(); //bug
	Assert.assertTrue(contactHeader.contains(LASTNAME), "contact created");
	}
}
