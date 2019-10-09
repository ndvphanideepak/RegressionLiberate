package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AccountOffers {
	TestActions action = null;

	By accountOffers_Tab = By.xpath("//td[text()='Account Offers']");
	By comverseDetails_Tab = By.xpath("//td[text()='Comverse Details']");

	// Action Button
	By addNewAccountOffer_ActionButton = By.xpath("//span[text()='Add New Account Offer']");
	By amendComverse_ActionButton = By.xpath("//span[text()='Amend Comverse']");
	By voucherRecharge_ActionButton = By.xpath("//span[text()='Voucher Recharge']");

	public AccountOffers(TestActions action) {
		this.action = action;
	}

	public void navigate() {
		action.waitFor(accountOffers_Tab, 5, true);
		action.clickOn(accountOffers_Tab);
	}

	public void verifyAccountOffers() {
		By accountID = By.xpath("//span[text()='Account id:']//following::span[1]");
		By accountState = By.xpath("//span[text()='Account State:']//following::span[1]");

		action.waitFor(accountID, 10, true);

		TestActions.log("Account ID : " + action.getTextFromPage(accountID));
		TestActions.log("Account State : " + action.getTextFromPage(accountState));
	}

	public void addNewAccountOffer() {
		By accoutOffer_Select = By.xpath("//span[text()='Account Offers']//following::select[1]");
		
		action.waitFor(addNewAccountOffer_ActionButton, 5, true);
		action.clickOn(addNewAccountOffer_ActionButton);
		
		action.waitFor(addNewAccountOffer_ActionButton, 20, true);
		action.selectBy(accoutOffer_Select, 1);
		
		//TODO Complete after Account offers are available.
	}
	
	public void addNewAccountOffer1() {
		By accoutOffer_Select = By.xpath("//span[text()='Account Offers']//following::select[1]");
		action.getScreenShot("ComverseTC_addNewAccountOffer");
		action.waitFor(addNewAccountOffer_ActionButton, 5, true);
		action.getScreenShot("ComverseTC_addNewAccountOffer");
		action.clickOn(addNewAccountOffer_ActionButton);
		action.getScreenShot("ComverseTC_addNewAccountOffer");
		action.waitFor(addNewAccountOffer_ActionButton, 20, true);
		action.selectBy(accoutOffer_Select, 1);
		action.getScreenShot("ComverseTC_addNewAccountOffer");
		//TODO Complete after Account offers are available.
	}
}
