package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class PEP_RouteAllocationPOM 
{
	TestActions action = null;
	
	// Route Allocation page
		By allocateAuto_ActionButton = By.xpath("//*[text ( ) = 'Allocate Auto']");
		By allocateManual_ActionButton = By.xpath("//*[text ( ) = 'Allocate Manual']");

		By releaseRoute_ActionButton = By.xpath("//span[text()='Release Route']");
		
	//**********
		
	By exchangeAreaLEG1_Select = By.xpath("(//*[text()='Exchange Area :'])[1]//following::select[1]");
	By exchangeAreaLEG2_Select = By.xpath("(//*[text()='Exchange Area :'])[2]//following::select[1]");
	By plantItemTypeLEG1_Select = By.xpath("(//*[text()='Plant Item Type:'])[1]//following::select[1]");
	By plantItemTypeLEG2_Select = By.xpath("(//*[text()='Plant Item Type:'])[2]//following::select[1]");
	By plantItemNoLEG1_Input = By.xpath("(//*[text()='Plant Item No:'])[1]//following::input[1]");
	By plantItemNoLEG2_Input = By.xpath("(//*[text()='Plant Item No:'])[2]//following::input[1]");
	
	
	By validate_Button = By.xpath("//*[@value='Validate ']");	
	By accept_Button = By.xpath("//input[@value = 'Accept']");
	
	//************
	
	By successMsgXPath = By.xpath("//*[@class='icePnlGrp']/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span");
	
	String expectedSuccessMsg = "Auto route created Successfully.";
	
	//*************
	
	
	By allocate_Button = By.xpath("//input[@value = 'Allocate']");
	By release_Button = By.xpath("//input[@value='Release']");
	By addMore_Button = By.xpath("//input[@value='Add more...']");

	By serviceNumber_Value = By
			.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[1]/td[3]//span");
	By routeAllocatedState_Value = By
			.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[1]/td[5]//span");
	By selected_Row = By.xpath("//tr[contains(@class,'ui-selected')]");

	By routingTableTerminal_Header = By.xpath("//*[text()='Terminal']");
	
	

	public PEP_RouteAllocationPOM(TestActions action) {
		this.action = action;
	}

	
	public boolean releaseRoute() {
		boolean passed = false;

		passed = action.waitFor(releaseRoute_ActionButton, 4, true);
		passed = action.clickOn(releaseRoute_ActionButton);

		passed = action.waitFor(release_Button, 4, true);
		passed = action.clickOn(release_Button);

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpYes_Button);

		return passed;
	}

	public boolean verifyRelease() {
		action.scrollUp();
		action.scrollUp();

		boolean passed = false;

		if (action.countOf(CommonPanel.popUp.popUpYes_Button) > 0)
			action.waitFor(2);

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim()
				.equals("Route released Successfully") ? true : false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}
	
	
	public boolean allocateRoutePEPLEG1(String LEG1PlantItemType, String LEG1PlantItemNumber) {
		boolean passed = false;

		passed = action.waitFor(selected_Row, 4, true);
		if (!action.getTextFromPage(routeAllocatedState_Value).trim().equals("N")) {
			releaseRoute();
			verifyRelease();
		}

		action.scrollUp();
		action.waitFor(4);

		passed = action.clickOn(allocateAuto_ActionButton);
		passed = action.waitFor(validate_Button, 4, true);
		passed = action.selectByPartialText(exchangeAreaLEG1_Select, "BOT");
		passed = action.waitFor(2);
		passed = action.selectByPartialText(plantItemTypeLEG1_Select, LEG1PlantItemType);
		passed = action.waitFor(3);
		passed = action.sendDataTo(plantItemNoLEG1_Input, LEG1PlantItemNumber);
		
		return passed;
	}
	
	//ManageServiceOrder_AutoAllocateRoutePEP
	
	public boolean allocateRoutePEPLEG11(String LEG1PlantItemType, String LEG1PlantItemNumber) {
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		boolean passed = false;
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(selected_Row, 4, true);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		if (!action.getTextFromPage(routeAllocatedState_Value).trim().equals("N")) {
			releaseRoute();
			verifyRelease();
		}
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		action.scrollUp();
		action.waitFor(4);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");

		passed = action.clickOn(allocateAuto_ActionButton);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(validate_Button, 4, true);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.selectByPartialText(exchangeAreaLEG1_Select, "BOT");
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(2);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.selectByPartialText(plantItemTypeLEG1_Select, LEG1PlantItemType);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(3);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.sendDataTo(plantItemNoLEG1_Input, LEG1PlantItemNumber);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		
		return passed;
	}
	
	
	
	public boolean clickingOnValidateButton()
	{
		boolean passed = false;
		
		passed = action.waitFor(3);
		passed = action.clickOn(validate_Button);
		
		return passed;
	}
	
	
	public boolean clickingOnValidateButton1()
	{action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		boolean passed = false;
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(3);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.clickOn(validate_Button);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		
		return passed;
	}
	public boolean allocateRoutePEPLEG2(String LEG2PlantItemType, String LEG2PlantItemNumber) 
	{
		boolean passed = false;
		
		passed = action.waitFor(4);
		passed = action.selectByPartialText(exchangeAreaLEG2_Select, "BOT");
		passed = action.waitFor(2);
		passed = action.selectByPartialText(plantItemTypeLEG2_Select, LEG2PlantItemType);
		passed = action.waitFor(2);
		passed = action.sendDataTo(plantItemNoLEG2_Input, LEG2PlantItemNumber);
		passed = action.waitFor(2);
		passed = action.clickOn(accept_Button);
		
		return passed;
	}
	
	
	public boolean allocateRoutePEPLEG21(String LEG2PlantItemType, String LEG2PlantItemNumber) 
	{action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		boolean passed = false;
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(4);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.selectByPartialText(exchangeAreaLEG2_Select, "BOT");
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(2);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.selectByPartialText(plantItemTypeLEG2_Select, LEG2PlantItemType);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(2);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.sendDataTo(plantItemNoLEG2_Input, LEG2PlantItemNumber);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(2);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.clickOn(accept_Button);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		
		return passed;
	}
	public boolean clickingOnFinalAcceptButton()
	{
		boolean passed = false;
		
		passed = action.waitFor(3);
		passed = action.clickOn(accept_Button);
		
		return passed;
	}
	
	
	public boolean clickingOnFinalAcceptButton1()
	{action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		boolean passed = false;
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(3);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.clickOn(accept_Button);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		
		return passed;
	}
	public boolean verifyAutoAllocateRoute() {
		boolean passed = false;

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim().contains(expectedSuccessMsg) ? true : false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}
	public boolean verifyAutoAllocateRoute1() {
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		boolean passed = false;
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim().contains(expectedSuccessMsg) ? true : false);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		action.getScreenShot("ManageServiceOrder_AutoAllocateRoutePEP");
		return passed;
	}
}
