package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class Amend_CreditLimit_ExistingCustomer_POM {

	TestActions action = null;
	By ServiceDetails_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Service Details')]]");
	By CreditControl_actionbutton = By.xpath("//*[text()='Change service details']");
	By CallMonitorDetails_radiobutton = By.xpath("//*[text()='Use Customer-selected Call Limit:']//following::label[1]");
	By CustomerCallLimit_Textfield = By.xpath("//input[@id='amendServiceDetails:amendServiceTabManagerSet:0:amendGeneralDetailsId:sclCreditLimit']");
	By CustomerselectedOverride_Textfield = By.xpath("//input[@id='amendServiceDetails:amendServiceTabManagerSet:0:amendGeneralDetailsId:sclCreditLimitOverride']");
	By Customerselectedupdated_Dropdown = By.xpath("//select[@id='amendServiceDetails:amendServiceTabManagerSet:0:amendGeneralDetailsId:sclUpdateType']");
	By Customerselectedbartype_Dropdown = By.xpath("//select[@id='amendServiceDetails:amendServiceTabManagerSet:0:amendGeneralDetailsId:sclBarType']");
	By Accept_button = By.xpath("//input[@value='Accept']");
	By Liberatepopup_text = By.xpath("//*[text()='Do you want to remove the bar on the service?']");
	By Liberatepopup_button = By.xpath("//input[@value='No']");
	By validation_text= By.xpath("//*[text()='Successfully Updated']");
	
	public Amend_CreditLimit_ExistingCustomer_POM(TestActions action) {
		this.action = action;
	}
	
	public boolean amendcreditlimit() {
		boolean passed = false;
		
		action.moveMouseAwayFromScreen();

		passed= action.waitFor(ServiceDetails_ActionButton, 5, true);
		action.clickOn(ServiceDetails_ActionButton);
		action.waitFor(1);
		
		passed = action.waitFor(CreditControl_actionbutton, 5, true);
		passed = action.clickOn(CreditControl_actionbutton);
		passed = action.waitFor(5);

		passed = action.waitFor(CallMonitorDetails_radiobutton, 5, true);
		passed = action.clickOn(CallMonitorDetails_radiobutton);
		passed = action.waitFor(5);
		
		passed = action.waitFor(CustomerCallLimit_Textfield, 5, true);
		passed = action.sendDataTo(CustomerCallLimit_Textfield, "1.0");
		passed = action.waitFor(1);
		
		passed = action.waitFor(CustomerselectedOverride_Textfield, 5, true);
		passed = action.sendDataTo(CustomerselectedOverride_Textfield, "1.0");
		passed = action.waitFor(1);
		
		passed = action.waitFor(Customerselectedupdated_Dropdown, 5, true);
		passed = action.selectBy(Customerselectedupdated_Dropdown, 1);
		passed = action.waitFor(1);
		
		passed = action.waitFor(Customerselectedbartype_Dropdown, 5, true);
		passed = action.selectBy(Customerselectedbartype_Dropdown, 1);
		passed = action.waitFor(1);
		
		
		
		passed = action.waitFor(Accept_button, 5, true);
		passed = action.clickOn(Accept_button);
		passed = action.waitFor(1);
		
		if(action.countOf(Liberatepopup_text)>0) {
			passed = action.waitFor(Liberatepopup_button, 5, true);
			passed = action.clickOn(Liberatepopup_button);
			passed = action.waitFor(1);
		}
		
		return passed;
	}
	
	
	
	public boolean Accept()
	
	{
		boolean passed = false;
		By Acceptclick = By.xpath("//*[@value = 'Accept']");
		By calllimit = By.xpath("//*[text() = 'Customer-selected Call Limit:']//following::input[1]");
		action.sendDataTo(calllimit, "2");
		action.clickOn(Acceptclick);
		action.Alertaccept();
		action.waitFor(2);
		action.clickOn(Acceptclick);
		return passed;
	}
	public boolean validation()
	{
		boolean passed = false;
		if(action.countOf(validation_text)>0)
			passed=true;
		return passed;
			
	}
}
