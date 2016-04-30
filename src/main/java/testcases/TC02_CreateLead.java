package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CRMHomePage;
import pages.CreateLeadPage;
import pages.LoginPage;
import pages.ViewLead;
import wrappers.OpentapsWrappers;

public class TC02_CreateLead extends OpentapsWrappers{

	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "chrome";
		dataSheetName 	= "TC02_CreateLead";
		testCaseName 	= "TC02 - CreateLead (POM)";
		testDescription = "Create Lead Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void CreateLeadInCRM(String username,String password,String companyName,String firstName, String lastName) {

	new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCRM();
	
	new CRMHomePage()
	.clickCreateLead();	
	
		
	new CreateLeadPage()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickLeadButton();
	
	new ViewLead()
		.verifyUpdateDetails(companyName);
	}

}
