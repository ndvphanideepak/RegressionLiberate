package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class ComverseTab {
	TestActions action = null;
	
	String currentBalance;
	int currentBalanceInt;
	String newBalance;
	
	By adjustBalance_ActionButton = By.xpath("//span[text()='Adjust Balance']");
	By balance_Cell = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']/descendant::td[2]");

	public ComverseTab(TestActions action) {
		this.action = action;
	}
	
	public void verifyComverseEnquiry() {
		action.getScreenShot("ComverseTC_transferBalance");
		By accountID = By.xpath("//*[contains(text(),'Account id')]/following::span[1]");
		By subscriberID = By.xpath("//*[contains(text(),'Subscriber id')]/following::span[1]");
		By currentState = By.xpath("//*[contains(text(),'Current State')]/following::span[1]");
		By previousState = By.xpath("//*[contains(text(),'Previous State')]/following::span[1]");
		
		action.waitFor(accountID, 10, true);
		
		TestActions.log("Account ID : "+action.getTextFromPage(accountID));
		TestActions.log("Subscriber ID : "+action.getTextFromPage(subscriberID));
		TestActions.log("Current State : "+action.getTextFromPage(currentState));
		TestActions.log("Previous State : "+action.getTextFromPage(previousState));
	}
	
	
	public void verifyComverseEnquiry1() {
		By accountID = By.xpath("//*[contains(text(),'Account id')]/following::span[1]");
		By subscriberID = By.xpath("//*[contains(text(),'Subscriber id')]/following::span[1]");
		By currentState = By.xpath("//*[contains(text(),'Current State')]/following::span[1]");
		By previousState = By.xpath("//*[contains(text(),'Previous State')]/following::span[1]");
		action.getScreenShot("ComverseTC_transferBalance");
		action.waitFor(accountID, 10, true);
		action.getScreenShot("ComverseTC_transferBalance");
		TestActions.log("Account ID : "+action.getTextFromPage(accountID));
		TestActions.log("Subscriber ID : "+action.getTextFromPage(subscriberID));
		TestActions.log("Current State : "+action.getTextFromPage(currentState));
		TestActions.log("Previous State : "+action.getTextFromPage(previousState));
	}

	public boolean getHistoricalData() {
		By audits_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Audits']");
		By balanceAudit_Tab = By.xpath("//td[text()='Balance Audit']");
		
		boolean passed = false;
		
		passed = action.waitFor(audits_Tab, 5, true);
		passed = action.clickOn(audits_Tab);
		
		passed = action.waitFor(balanceAudit_Tab, 5, true);
		passed = action.waitFor(CommonPanel.Search_Button, 10, true);
		passed = action.clickOn(CommonPanel.Search_Button);
		action.waitFor(4);
		
		return passed;
	}
	
	public boolean changeBalance() {
		
		
		By balances_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Balances']");
		
		By balance_Row = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']");
				
		boolean passed = false;
		
		passed = action.waitFor(balances_Tab, 5, true);
		passed = action.clickOn(balances_Tab);
				
		passed = action.waitFor(balance_Row, 10, true);
		passed = action.clickOn(balance_Row);
		
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		
		currentBalance = action.getTextFromPage(balance_Cell);
		TestActions.log("Balance : " + currentBalance);

		currentBalance = currentBalance.split("\\.")[0];		
		TestActions.log("Balance for processing :" + currentBalance);
		
		currentBalanceInt = Integer.parseInt(currentBalance);
		TestActions.log("Balance in Integer :" + currentBalanceInt);

		return passed;
	}
public boolean changeBalance2() {
	action.getScreenShot("ComverseTC_transferBalance");
		
		By balances_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Balances']");
		
		By balance_Row = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']");
		action.getScreenShot("ComverseTC_transferBalance");	
		boolean passed = false;
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.waitFor(balances_Tab, 5, true);
		passed = action.clickOn(balances_Tab);
		action.getScreenShot("ComverseTC_transferBalance");	
		passed = action.waitFor(balance_Row, 10, true);
		passed = action.clickOn(balance_Row);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		action.getScreenShot("ComverseTC_transferBalance");
		currentBalance = action.getTextFromPage(balance_Cell);
		TestActions.log("Balance : " + currentBalance);
		action.getScreenShot("ComverseTC_transferBalance");
		currentBalance = currentBalance.split("\\.")[0];		
		TestActions.log("Balance for processing :" + currentBalance);
		action.getScreenShot("ComverseTC_transferBalance");
		currentBalanceInt = Integer.parseInt(currentBalance);
		TestActions.log("Balance in Integer :" + currentBalanceInt);
		action.getScreenShot("ComverseTC_transferBalance");
		return passed;
	}
public boolean changeBalance1() {
		
		action.getScreenShot("ComverseTC_adjustBalance");
		By balances_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Balances']");
		action.getScreenShot("ComverseTC_adjustBalance");
		By balance_Row = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']");
		action.getScreenShot("ComverseTC_adjustBalance");		
		boolean passed = false;
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(balances_Tab, 5, true);
		passed = action.clickOn(balances_Tab);
		action.getScreenShot("ComverseTC_adjustBalance");	
		passed = action.waitFor(balance_Row, 10, true);
		passed = action.clickOn(balance_Row);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		action.getScreenShot("ComverseTC_adjustBalance");
		currentBalance = action.getTextFromPage(balance_Cell);
		TestActions.log("Balance : " + currentBalance);
		action.getScreenShot("ComverseTC_adjustBalance");
		currentBalance = currentBalance.split("\\.")[0];		
		TestActions.log("Balance for processing :" + currentBalance);
		action.getScreenShot("ComverseTC_adjustBalance");
		currentBalanceInt = Integer.parseInt(currentBalance);
		TestActions.log("Balance in Integer :" + currentBalanceInt);
		action.getScreenShot("ComverseTC_adjustBalance");
		return passed;
	}
	
	
	public boolean setBalance() {
		By setBalance_RadioButton = By.xpath("//label[text()='Set Balance?']");
		By amountSet_TextBox = By.xpath("//label[text()='New Balance:']/following::input[contains(@name, 'newBalanceAmount')]");
		By confirm_Button = By.xpath("//input[@value='Confirm']");

		boolean passed = false;
		
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		passed = action.clickOn(adjustBalance_ActionButton);
		
		passed = action.waitFor(setBalance_RadioButton, 10, true);
		passed = action.clickOn(setBalance_RadioButton);
		
		passed = action.waitFor(amountSet_TextBox, 10, true);
		action.waitFor(2);
		passed = action.sendDataTo(amountSet_TextBox, Integer.toString(currentBalanceInt + 1));
		action.waitFor(2);
		
		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 10, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		passed = action.waitFor(confirm_Button, 10, true);
		passed = action.clickOn(confirm_Button);

		passed = action.waitFor(confirm_Button, 10, false);
		action.waitFor(2);
		passed = CommonPanel.popUp.clickOK(action);
		action.waitFor(2);

		newBalance = action.getTextFromPage(balance_Cell).split("//.")[0];
		TestActions.log("New Balance:" + newBalance);
		
		passed = currentBalance.equals(Integer.toString(currentBalanceInt+1));
		
		return passed;
	}
	
	public boolean adjustBalance() {
		action.getScreenShot("ComverseTC_adjustBalance");
		By adjustBalance_RadioButton = By.xpath("//label[text()='Adjust Balance?']");
		By amountAdjusted_TextBox = By.xpath("//label[text()='Amount Adjusted:']/following::input[contains(@name, 'adjustmentAmount')]");
		action.getScreenShot("ComverseTC_adjustBalance");
		By confirm_Button = By.xpath("//input[@value='Confirm']");
		action.getScreenShot("ComverseTC_adjustBalance");
		boolean passed = false;
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		passed = action.clickOn(adjustBalance_ActionButton);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(adjustBalance_RadioButton, 10, true);
		passed = action.clickOn(adjustBalance_RadioButton);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(amountAdjusted_TextBox, 10, true);
		action.waitFor(2);
		passed = action.sendDataTo(amountAdjusted_TextBox, "1.00");
		action.waitFor(2);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 10, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(confirm_Button, 10, true);
		passed = action.clickOn(confirm_Button);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = action.waitFor(confirm_Button, 10, false);
		action.waitFor(2);
		passed = CommonPanel.popUp.clickOK(action);
		action.waitFor(2);
		action.getScreenShot("ComverseTC_adjustBalance");
		newBalance = action.getTextFromPage(balance_Cell).split("//.")[0];
		TestActions.log("New Balance:" + newBalance);
		action.getScreenShot("ComverseTC_adjustBalance");
		passed = currentBalance.equals(Integer.toString(currentBalanceInt+1));
		action.getScreenShot("ComverseTC_adjustBalance");
		return passed;
	}
	
	public boolean newSupplementaryOffer() {
		By supplementaryOffer_ActionButton = By.xpath("//spam[text()='Provide/Cease Supplementary Offers']");
		By next_Button = By.xpath("//input[@value='Next']");
		
		boolean passed = false;
		
		passed = action.waitFor(supplementaryOffer_ActionButton, 10, true);
		passed = action.clickOn(supplementaryOffer_ActionButton);
		
		passed = CommonPanel.selectDepartmentSite(action, "AQSAL", "ANSQ");
		passed = action.clickOn(next_Button);

		return passed;
	}
	
	public boolean provideSupplementaryOffer() {
		//TODO There is a miss match between Comverse and liberate products.
		boolean passed = false;
		return passed;
	}
	
	public boolean transferBalance(String transferTo) {
		By transferBalance_ActionButton = By.xpath("//spam[text()='Transfer Balance']");
		By transferTo_TextBox = By.xpath("//label[text()='Transfer To:']/following::input[1]");
		By transferAmount_TextBox = By.xpath("//label[text()='Transfer Amount:']/following::input[1]");
		By transferBalanceType_Select = By.xpath("//label[text()='Target Balance:']/following::select[1]");

		By transferTo_SearchButton = By.xpath("//label[text()='Transfer To:']//following::input[@type='image']");
		
		By success_Message = By.xpath("//span[text()='The Balance has been transfered successfully.']");
		
		boolean passed = false;
		
		passed = action.waitFor(transferBalance_ActionButton, 10, true);
		passed = action.clickOn(transferBalance_ActionButton);
		
		passed = action.waitFor(transferTo_TextBox, 10, true);
		action.waitFor(2);
		passed = action.sendDataTo(transferTo_TextBox, transferTo);
		action.waitFor(2);
		
		passed = action.clickOn(transferTo_SearchButton);
		action.waitFor(5);
		
		passed = action.selectByPartialText(transferBalanceType_Select, "Core");
		action.waitFor(2);

		passed = action.sendDataTo(transferAmount_TextBox, "1.00");
		action.waitFor(2);
		
		passed = CommonPanel.popUp.clickOK(action);
		
		passed = action.waitFor(success_Message, 26, true);
		passed = CommonPanel.popUp.clickOK(action);

		newBalance = action.getTextFromPage(balance_Cell).split("//.")[0];
		TestActions.log("New Balance:" + newBalance);
		
		passed = newBalance.equals(Integer.toString(currentBalanceInt-1));
		
		return passed;
	}
	
	public boolean transferBalance1(String transferTo) {
		By transferBalance_ActionButton = By.xpath("//spam[text()='Transfer Balance']");
		By transferTo_TextBox = By.xpath("//label[text()='Transfer To:']/following::input[1]");
		By transferAmount_TextBox = By.xpath("//label[text()='Transfer Amount:']/following::input[1]");
		By transferBalanceType_Select = By.xpath("//label[text()='Target Balance:']/following::select[1]");

		By transferTo_SearchButton = By.xpath("//label[text()='Transfer To:']//following::input[@type='image']");
		
		By success_Message = By.xpath("//span[text()='The Balance has been transfered successfully.']");
		action.getScreenShot("ComverseTC_transferBalance");
		boolean passed = false;
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.waitFor(transferBalance_ActionButton, 10, true);
		passed = action.clickOn(transferBalance_ActionButton);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.waitFor(transferTo_TextBox, 10, true);
		action.waitFor(2);
		passed = action.sendDataTo(transferTo_TextBox, transferTo);
		action.waitFor(2);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.clickOn(transferTo_SearchButton);
		action.waitFor(5);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.selectByPartialText(transferBalanceType_Select, "Core");
		action.waitFor(2);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.sendDataTo(transferAmount_TextBox, "1.00");
		action.waitFor(2);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = CommonPanel.popUp.clickOK(action);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = action.waitFor(success_Message, 26, true);
		passed = CommonPanel.popUp.clickOK(action);
		action.getScreenShot("ComverseTC_transferBalance");
		newBalance = action.getTextFromPage(balance_Cell).split("//.")[0];
		TestActions.log("New Balance:" + newBalance);
		action.getScreenShot("ComverseTC_transferBalance");
		passed = newBalance.equals(Integer.toString(currentBalanceInt-1));
		action.getScreenShot("ComverseTC_transferBalance");
		return passed;
	}
}
