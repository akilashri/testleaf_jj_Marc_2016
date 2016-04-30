package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class ViewLead extends OpentapsWrappers{
	
	   public ViewLead(){
		if(!verifyTitle("View Lead | opentaps CRM")){
			Reporter.reportStep("This is NOT View Lead openTaps CRM page", "FAIL");
		}
	   }

		public ViewLead verifyUpdateDetails(String cName){
			verifyTextContainsByXpath((prop.getProperty("ViewLead.IdName.Xpath")), cName);
			return this;
		}
		
		public EditLeadPage clickEditButton(){
			
			clickByXpath(prop.getProperty("ViewLead.Edit.Xpath"));
			return new EditLeadPage();
		}	
		
		public ViewLead EditDetails(String companyName){
			
			verifyTextContainsByXpath(prop.getProperty("ViewLead.IdName.Xpath"), companyName);
			return this;
			
		}
	  	
}
