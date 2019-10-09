package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class ExchangeSignoff {

	TestActions action = null;
	
	By department_Select = By.xpath("//*[text()='Department:']//following::select[1]"); // pass it from excel
	
	By change_button = By.xpath("//*[@value = 'Change']");
	
	By Serviceorder_input = By.xpath("//*[text()='Service Order:']//following::input[1]"); // pass value from excel
	
	By Search_button = By.xpath("//*[@value = \"Search\"]");
	
	By Signoff_button = By.xpath("//*[text( ) = 'Sign off']");
	
	
	By Department_Select = By.xpath("//*[text()='Department:']/following::select[1]");
	By DepartmentDisabled_Select = By.xpath("//*[text()='Department:']/following::select[@disabled='disabled'][1]");
	By ChangeDepartment_Button = By.xpath("//input[@value='Change']");
	By ServiceOrder_Input = By.xpath("//*[text()='Service Order:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");

	By SiteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
	By Site_Select = By.xpath("//*[text()='Site:']//following::select[1]");

	
	
	
	//Alert box after clicking on "Sign off"
	
	By Accept_button = By.xpath("//*[@value = 'Accept']");
	
	By GeneralSignoff_Accept_button = By.xpath("//*[@value = 'Accept']");
	
	public ExchangeSignoff(TestActions action) {
		this.action = action;
	}
	
	
	public boolean selectDepartmentSite(String department, String ServiceOrderNumber ) {
		boolean passed = false;
		
	
		passed = action.waitFor(Department_Select, 4, true);

		if (!action.getSelectedOption(Department_Select).contains(department)) {
			passed = action.clickOn(ChangeDepartment_Button);
			passed = action.waitFor(DepartmentDisabled_Select, 4, false);

			passed = action.selectByPartialText(Department_Select, department);
			passed = action.waitFor(DepartmentDisabled_Select, 4, true);

			passed = action.waitFor(1);
			
			passed = action.waitFor(Serviceorder_input, 4, false);
			passed = action.sendDataTo(Serviceorder_input, ServiceOrderNumber );
			
			action.clickOn(Search_button);
		}

		
		return passed;
	}
	
	
	public boolean signoffbutton() {
		boolean passed = false;

		passed = action.waitFor(Signoff_button, 4, true);		
		
		passed = action.clickOn(Signoff_button);
		
		return passed;
	}
	

	//Alert box code
	
	
	public boolean accept() {
		boolean passed = false;

				
		passed = action.waitFor(Accept_button, 4, true);
		passed = action.clickOn(Accept_button);
		
		return passed;
	}
	
	public boolean generalsignoff() {
		boolean passed = false;

		passed = action.waitFor(GeneralSignoff_Accept_button, 4, true);	
		action.waitFor(4);
		passed = action.clickOn(GeneralSignoff_Accept_button);
		action.getScreenShot("exchangesignoff6");
		
		action.waitFor(4);
		
		return passed;
	}
	
	
	
}
