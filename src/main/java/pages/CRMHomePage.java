package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CRMHomePage extends OpentapsWrappers {
	
	public CRMHomePage(){
		if(!verifyTitle("My Home | opentaps CRM")){
			Reporter.reportStep("This is NOT OpenTaps CRM page", "FAIL");
		}	
		
	}
	
	
	public CreateLeadPage clickCreateLead(){
		clickByXpath(prop.getProperty("CRMHomePage.LeadButton.Xpath"));
		return new CreateLeadPage();
	}
	
}
