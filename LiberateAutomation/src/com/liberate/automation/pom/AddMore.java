package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AddMore {
	TestActions action = null;
	
	By ServicePackage_ActionButton = By.xpath("//span[text()='Service Package']");
	By ADSL_ActionButton = By.xpath("//span[text()='ADSL']");
	
	public AddMore(TestActions action)
	{
		this.action = action;
	}
	
	public boolean addServicePackage()
	{
		 boolean passed = false;
		 
		 passed = action.waitFor(ServicePackage_ActionButton, 5, true);
		 passed = action.clickOn(ServicePackage_ActionButton);
		 
		 return passed;
	}
	
	public boolean addADSL()
	{
		 boolean passed = false;
		 
		 if(action.countOf(ADSL_ActionButton) > 0)
		 {	
			 action.waitFor(4);
			 passed = action.waitFor(ADSL_ActionButton, 5, true);
			 passed = action.clickOn(ADSL_ActionButton);
		 }
		 else
		 {
			 action.waitFor(4);
			 passed = action.waitFor(ServicePackage_ActionButton, 5, true);
			 passed = action.clickOn(ServicePackage_ActionButton);
			 action.waitFor(4);
		 }
		 
		 return passed;
	}
}
