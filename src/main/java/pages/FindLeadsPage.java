package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;
import pages.CreateLeadPage;

public class FindLeadsPage extends OpentapsWrappers{

	public FindLeadsPage() {

		if(!verifyTitle("Find Leads | opentaps CRM")){
			Reporter.reportStep("This is NOT FindLead page", "FAIL");
		}

	}
	
	public FindLeadsPage enterLeadId(String value) {

		enterByName(prop.getProperty("FindLeads.LeadId.Name"),value);
		return this;
		
	}
	
	
	public FindLeadsPage clickFindLeads(){
		clickByXpath(prop.getProperty("FindLeads.FindLead.Xpath"));
		return this;
	}
	
	public ViewLead clickId(String s1){
		
		clickByLink(s1);
		return new ViewLead();
	}
	
}
