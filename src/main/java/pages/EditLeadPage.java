package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class EditLeadPage extends OpentapsWrappers{
	
	public EditLeadPage(){
		if(!verifyTitle("opentaps CRM")){
			Reporter.reportStep("This is NOT OpenTaps CRM page", "FAIL");
		}			
	}
	
   	public EditLeadPage editDetails(String companyName){
			enterById(prop.getProperty("EditLeadPage.CompanyName.Id"), companyName);
			return this;
		}
		
    public ViewLead clickUpdate(){
    	
    	clickByName(prop.getProperty("EditLeadPage.Button.Name"));
    	return new ViewLead();
    }

}
	

