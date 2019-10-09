package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;

public class CRAccountDetails {
	TestActions action = null;

	public String CreatedAccount = "";

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By AccountDetails_Tab = By.xpath("//*[text()='Account Details']");

	By CloneCustomer_ActionButton = By.xpath("//span[text()='Clone Customer']");
	By CloneAccount_ActionButton = By.xpath("//span[text()='Clone Account']");
	By CreateSubAccount_ActionButton = By.xpath("//span[text()='Create Sub Account']");

	// Clone Customer
	By CustomerType_Select = By.xpath("(//*[text()='Customer Type:']//following::select)[1]");
	By MarketingCategory_Select = By.xpath("(//*[text()='Marketing Category:']//following::select)[1]");
	By Company_Select = By.xpath("(//*[text()='Company:']//following::select)[1]");
	By AccountType_Select = By.xpath("(//*[text()='Account Type:']//following::select)[1]");
	By BillFrequency_Select = By.xpath("(//*[text()[contains(.,'Bill Frequency:')]]//following::select)[1]");
	By RentalPeriod_Select = By.xpath("(//*[text()[contains(.,'Rental Period:')]]//following::select)[1]");
	By PrimaryDayOfBilling_Select = By
			.xpath("(//*[text()[contains(.,'Primary Day Of Billing:')]]//following::select)[1]");

	// Account Details Edit
	By BillStatusArea_Select = By.xpath("(//*[text()[contains(.,'Bill Status Area:')]]//following::select)[1]");
	By SortCode_Select = By.xpath("(//*[text()[contains(.,'Sort Code')]]//following::select)[1]");
	By AddressType = By.xpath("(//*[text()[contains(.,'Address Type:')]]//following::select)[1]");

	By Submit_Button = By.xpath("//input[@value='Submit']");

	By AccountCreated_Message = By.xpath("//*[text()[contains(.,'Account created successfully.')]]");
	By CreatedAccount_Value = By.xpath("//*[text()[contains(.,'Account created successfully.')]]//following::span[1]");
	
	By CloneAccountLocation_Dropdown = By.xpath("(//*[text()='Location:']/following::select)[1]");
	By BillSortCodeStartingwith_dropdown = By.xpath("(//*[text()='Starting With:']/following::select)[1]");


	public CRAccountDetails(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(AccountDetails_Tab, 4, true);
		passed = action.clickOn(AccountDetails_Tab);

		passed = action.waitFor(CloneCustomer_ActionButton, 4, true);

		return passed;
	}

	public boolean cloneAccount() {

		boolean passed = false;
		action.waitFor(3);
		action.getScreenShot("CustomerCareTC_cloneAccount");
		passed = action.clickOn(CloneAccount_ActionButton);
		action.waitFor(3);
		// action.selectBy(Location_Select, 1);
		action.selectBy(CloneAccountLocation_Dropdown, 2);
		action.waitFor(2);
		action.selectBy(BillSortCodeStartingwith_dropdown, 2);
		action.waitFor(2);
		action.getScreenShot("CustomerCareTC_cloneAccount");
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		action.getScreenShot("CustomerCareTC_cloneAccount");
		return passed;
	}

	public boolean cloneCustomer() {
		By Startingwith_Select = By.xpath("//*[text() = 'Starting With']//following::select[1]");
		By town_Input = By.xpath("//*[text() = 'test codes one']//following::input[2]");

		boolean passed = false;
		action.waitFor(3);
		passed = action.waitFor(CloneCustomer_ActionButton, 8, true);
		passed = action.clickOn(CloneCustomer_ActionButton);

		passed = action.waitFor(CustomerType_Select, 4, true);

		if (action.getSelectedOption(CustomerType_Select).contains("Select"))
			action.selectByPartialText(CustomerType_Select, "R - ");

		if (action.getSelectedOption(MarketingCategory_Select).contains("Select"))
			action.selectByPartialText(MarketingCategory_Select, "99000");

		if (action.getSelectedOption(Company_Select).contains("Select"))
			action.selectByPartialText(Company_Select, "CYN");

		if (action.getSelectedOption(AccountType_Select).contains("TP"))
			action.selectByPartialText(CustomerType_Select, "R - ");

		if (action.getSelectedOption(CustomerType_Select).contains("Select"))
			action.selectByPartialText(CustomerType_Select, "R - ");

		if (action.getSelectedOption(RentalPeriod_Select).contains("Select"))
			action.selectBy(RentalPeriod_Select, 1);

		if (action.getSelectedOption(PrimaryDayOfBilling_Select).contains("Select"))
			action.selectBy(PrimaryDayOfBilling_Select, 1);

		passed = action.clickOn(CommonPanel.Accept_Button);
		passed = action.waitFor(CommonPanel.Accept_Button, 4, false);

		action.selectBy(BillStatusArea_Select, "BOT-BOT - Bodden Town");
		action.waitFor(3);
		action.selectBy(Startingwith_Select, 2);
		action.waitFor(3);
		action.sendDataTo(town_Input, "Hyderabad");
		action.waitFor(2);
		action.clickOn(Submit_Button);
		action.waitFor(5);
		passed = fillCustomerDetails();

		return passed;
	}

	public boolean createSubAccount() {
		By SurName_Input = By.xpath("//*[text() = 'Surname:']//following::input[1]");
		By Location_Select = By.xpath("//*[text() = 'Location:']//following::select[1]");
		By CustomerType_Select = By.xpath("//*[text() = 'Customer Type:']//following::select[1]");
		By CompanyName_Input = By.xpath("//*[text() = 'Company Name:']//following::input[1]");
		By TOSCategory_Select = By.xpath("//*[text() = 'TOS Category:']//following::select[1]");

		By IDValue_Input = By.xpath("//*[text()[contains(.,'ID Value')]]//following::input[1]");

		RandomData random = new RandomData();

		boolean passed = false;

		action.waitFor(3);
		action.getScreenShot("CustomerCareTC_createSubAccount");
		action.clickOn(CreateSubAccount_ActionButton);
		action.getScreenShot("CustomerCareTC_createSubAccount");
		action.waitFor(SurName_Input, 6, true);

		action.clickOn(SurName_Input);
		action.waitFor(2);
		action.clickOn(SurName_Input);
		action.sendDataTo(SurName_Input, random.nextString());

		action.selectBy(Location_Select, 1);
		action.waitFor(2);
		action.sendDataTo(IDValue_Input, random.nextString().substring(0, 10));
		action.waitFor(2);
		action.selectBy(CustomerType_Select, 1);
		action.waitFor(2);
		action.sendDataTo(CompanyName_Input, random.nextString());
		action.waitFor(2);
		action.selectBy(TOSCategory_Select, 1);
		action.getScreenShot("CustomerCareTC_createSubAccount");
		action.clickOn(CommonPanel.popUp.popUpOK_Button);
		action.getScreenShot("CustomerCareTC_createSubAccount");

		return passed;
	}

	private boolean fillCustomerDetails() {
		boolean passed = false;

		NewCustomer address = new NewCustomer(action);

		if (action.getSelectedOption(BillStatusArea_Select).contains("Select"))
			action.selectByPartialText(BillStatusArea_Select, "BOT");
		if (action.getSelectedOption(SortCode_Select).contains("Select"))
			action.selectBy(SortCode_Select, 1);

		passed = address.fillStandardAddress();

		action.clickOn(Submit_Button);

		return passed;
	}

	public boolean verifySuccessMessage() {
		boolean passed = false;

		passed = action.waitFor(AccountCreated_Message, 4, true);
		this.CreatedAccount = action.getTextFromPage(CreatedAccount_Value);

		TestActions.log("Created Account : " + this.CreatedAccount);
		action.getScreenShot("CustomerCareTC_cloneAccount");
		passed = CommonPanel.popUp.clickOK(action);
		action.getScreenShot("CustomerCareTC_cloneAccount");

		action.scrollUp();

		return passed;
	}



public boolean verifySuccessMessage1() {
	boolean passed = false;

	passed = action.waitFor(AccountCreated_Message, 4, true);
	this.CreatedAccount = action.getTextFromPage(CreatedAccount_Value);

	TestActions.log("Created Account : " + this.CreatedAccount);
	action.getScreenShot("CustomerCareTC_createSubAccount");
	passed = CommonPanel.popUp.clickOK(action);
	action.getScreenShot("CustomerCareTC_createSubAccount");

	action.scrollUp();

	return passed;
}
}
