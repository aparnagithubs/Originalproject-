package vTigerOrganizations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTigerGenericLibrary.BaseClass;

public class CreateOrgTest extends BaseClass{
	
	@Test(groups="regressionSuite")
	public void createOrg() throws EncryptedDocumentException, IOException
	{
		//read data from excel
		String ORGNAME= eLib.readDataFromExcel("Organization",1,2)+jLib.getRandomNumber();
		
		//step4 navigate organization link
		HomePage hp= new HomePage(driver);
		hp.clickOrganizationsLnk();
	 
		//enter mandatory fields and save 
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
	    System.out.println("  organizationnnnn");
	    			
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
	}
	@Test
	public void createwithLead1()
	{
		System.out.println("shiva");
	}
	@Test
	public void createwithLead52()
	{
		System.out.println("Parvati");
	}
}
