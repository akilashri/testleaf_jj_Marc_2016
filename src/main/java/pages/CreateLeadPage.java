package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CreateLeadPage extends OpentapsWrappers {
	
	   String s1 = null;
	   public CreateLeadPage(){
		if(!verifyTitle("Create Lead | opentaps CRM")){
			Reporter.reportStep("This is NOT Create Lead openTaps CRM page", "FAIL");
		}	
		
	   }
	
	
	   // Enter Companyname
		public CreateLeadPage enterCompanyName(String companyName){
			enterById(prop.getProperty("CreateLeadPage.CompanyName.Id"), companyName);
			return this;
		}

		// Enter FirstName
		public CreateLeadPage enterFirstName(String firstName){
			enterById(prop.getProperty("CreateLeadPage.FirstName.Id"), firstName);
			return this;
		}
		
		// Enter Last Name
		public CreateLeadPage enterLastName(String lastName){
			enterById(prop.getProperty("CreateLeadPage.LastName.Id"), lastName);
			return this;
		}
		
		

		// Click Create Lead Button
		public ViewLead clickLeadButton(){
			clickByName(prop.getProperty("CreateLeadPage.Button.Name"));
			return new ViewLead();
		}
		
		public FindLeadsPage clickFindLeads(){
			clickByLink(prop.getProperty("CreateLeadPage.FindLead.LinkText"));
			return new FindLeadsPage();
			
		}
		
		public String getLeadId(){
			s1 = printValue(prop.getProperty("ViewLead.IdName.Xpath"));
			return s1;
		}



}
