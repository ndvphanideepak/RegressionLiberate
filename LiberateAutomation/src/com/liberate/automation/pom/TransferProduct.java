package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class TransferProduct {

	TestActions action = null;

	By ToServiceNumber_Input = By.xpath("//*[@id = 'transferProduct:toServiceNumber']");

	By Search_Button = By.xpath("//*[@id = 'transferProduct:prodcutSearch']");

	By Transfer_checkbox = By.xpath("(//input[@type='checkbox'])[1]");

	By Apply_Button = By.xpath("//input[@value = 'Apply']");

	public TransferProduct(TestActions action) {
		this.action = action;
	}

	public boolean sendDataToServiceNumber(String TransferServiceNumber) {
		boolean passed = false;
		passed = action.waitFor(ToServiceNumber_Input, 4, true);
		action.getScreenShot("TransferProductTC");
		passed = action.sendDataTo(ToServiceNumber_Input, TransferServiceNumber);
		action.getScreenShot("TransferProductTC");
		return passed;

	}

	public boolean clickonsearchbutton() {
		boolean passed = false;
		action.getScreenShot("TransferProductTC");
		passed = action.waitFor(Search_Button, 4, true);
		action.getScreenShot("TransferProductTC");
		passed = action.clickOn(Search_Button);
		action.getScreenShot("TransferProductTC");
		return passed;
	}

	public boolean SelectTransferCheckbox() {
		boolean passed = false;
		action.getScreenShot("TransferProductTC");
		passed = action.waitFor(Transfer_checkbox, 4, true);
		action.getScreenShot("TransferProductTC");
		passed = action.clickOn(Transfer_checkbox);
		action.getScreenShot("TransferProductTC");
		return passed;
	}

	public boolean clickonapplybutton() {
		action.getScreenShot("TransferProductTC");
		boolean passed = false;
		action.getScreenShot("TransferProductTC");
		passed = action.waitFor(Apply_Button, 4, true);
		action.getScreenShot("TransferProductTC");
		passed = action.clickOn(Apply_Button);
		action.getScreenShot("TransferProductTC");
		action.waitFor(20);
		action.getScreenShot("TransferProductTC");
		action.clickOn(Search_Button);
		action.getScreenShot("TransferProductTC");
		return passed;

	}
}