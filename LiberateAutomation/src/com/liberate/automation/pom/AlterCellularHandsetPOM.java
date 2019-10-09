package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AlterCellularHandsetPOM {
	public TestActions action = null;
	
	By ceaseReason_select= By.xpath("//select[@id='alterForm:creason']");
	By productcode_select = By.xpath("//select[@id='alterForm:productID']");
	By accept_button = By.xpath("//*[@value='Accept']");
	By success_message = By.xpath("//*[text()='Cellular Handset Successfully Altered']");
	By currenthandset_text = By.xpath("//*[text()='Current handset:']/following::span[1]");
	By productcodeselected_text = By.xpath("//*[text()='Product:']/following::select[1]");
	public AlterCellularHandsetPOM(TestActions action) {
		this.action = action;
	}
	
	public boolean alterhandsetaccept() {
		boolean passed = false;
		passed = action.waitFor(ceaseReason_select, 4, true);
		passed = action.selectBy(ceaseReason_select, 1);
				
		String handsetnumbertext=action.getTextFromPage(currenthandset_text);
		String handsetnumber= handsetnumbertext.split("-")[0];
		
		passed = action.waitFor(productcode_select, 4, true);
		passed = action.selectBy(productcode_select, 1);
		String productcodeselected=action.getTextFromPage(productcodeselected_text);
		String productcode= productcodeselected.split("-")[0];
		
		/*if(handsetnumber.equals(productcode)) {
		passed = action.selectBy(productcode_select, 2);
		passed = action.waitFor(accept_button,4,true);
		passed = action.clickOn(accept_button);
		}
		
		else {*/
		passed = action.waitFor(accept_button,4,true);
		passed = action.clickOn(accept_button);
		//}
		
		passed = action.waitFor(success_message,20,true);
		return passed;
		
	}
}
