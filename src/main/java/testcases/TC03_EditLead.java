package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CRMHomePage;
import pages.CreateLeadPage;
import pages.EditLeadPage;
import pages.FindLeadsPage;
import pages.LoginPage;
import pages.ViewLead;
import wrappers.OpentapsWrappers;

public class TC03_EditLead extends OpentapsWrappers{

	
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "chrome";
		dataSheetName 	= "TC03_EditLead";
		testCaseName 	= "TC03 - EditLead (POM)";
		testDescription = "Edit Lead Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void EditLeadInCRM(String username,String password,String cName,String firstName,String leadId) throws InterruptedException {

	new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCRM();
	
	new CRMHomePage()
	.clickCreateLead();	
	
	new CreateLeadPage()
	  .clickFindLeads();	  
	
	Thread.sleep(5000);
	
	new FindLeadsPage()
	.enterLeadId(leadId)
	.clickFindLeads()
	.clickId(leadId);	
	
	new ViewLead()
	 .clickEditButton();
	
	Thread.sleep(10000);
	
	new EditLeadPage()
	 .editDetails(cName)
	 .clickUpdate();
	
	new ViewLead()
	 .verifyUpdateDetails(cName);

		
	}

}
