package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class CUG_POM 
{
	TestActions action = null;
	
	By New_ActionButton = By.xpath("//*[text()='New']");
	By CUGID_InputBox = By.xpath("//*[text()='CUG ID']/following::input[1]");
	By CUGDescription_InputBox = By.xpath("//*[text()='Description:']/following::input[1]");
	By CUGType_SelectServiceType = By.xpath("(//*[text()='CUG Type:']/following::input[@type='radio'])[2]");
	By ChargeGroup_dropdown = By.xpath("//*[text()='Charge Group']/following::select[1]");
	By InternationalChargeGroup_dropdown = By.xpath("//*[text()='International Charge Group']/following::select[1]");
	By MaxServices_testBox = By.xpath("//*[text()='Max No of Services']/following::input[1]");
	By ServCallType_Dropdown = By.xpath("//*[text()='Call Type']/following::select[1]");
	
	
	By Accept_Button = By.xpath("//*[@value='Accept']");
	By Cancel_Button = By.xpath("//*[@value='Cancel']");
	
	By SuccessMsg_test = By.xpath("//*[@class='icePnlGrp']/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/span[1]");
	By CUG_Search = By.xpath("//*[text()='CUG Search']");
	By CUGStartingWith_radio = By.xpath("(//*[text()='CUG Search']/following::input[@type='radio'])[2]");
	By CUGStartingWith_inputBox = By.xpath("(//*[text()='CUGs Starting with']/following::input)[1]");
	
	By Search_Button = By.xpath("//*[@value='Search']");
	By Service_tab = By.xpath("(//*[text()='Service'])[1]");
	
	By ServiceNumber_Input =By.xpath("//*[text()='Service No:']/following::input[1]");
	By ValidateCUGNum_Button = By.xpath("//*[@value='Validate CUG No.']");
	
	By Ok_Button = By.xpath("//*[@value='OK']");
	
	
	
	
	
	
	public CUG_POM(TestActions action) {
		/***
		 * The passed TestAction class object should be assigned to the local variable
		 */
		this.action = action;
	}
	
	public boolean navigation_CUG()
	{
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);
		passed = action.waitFor(LiberateCommon.CustomerCare.AdditionalCustomerInformation, 4, true);
		passed = action.clickOn(LiberateCommon.CustomerCare.AdditionalCustomerInformation);
		passed = action.waitFor(LeftLink.AdditionalCustomerInformation.CUGSearch, 4, true);
		passed = action.clickOn(LeftLink.AdditionalCustomerInformation.CUGSearch);
		
		action.waitFor(2);
		
		return passed;
	}
	
	public boolean newCUG_Click()
	{
		boolean passed = false;
		
		action.scrollUp();
		action.waitFor(2);
		
		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);
		
		return passed;
	}
	
	public boolean provideCUGDetails(String CUGID)
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(CUGID_InputBox, 4, true);
		passed = action.sendDataTo(CUGID_InputBox, CUGID);
		passed = action.waitFor(CUGDescription_InputBox, 4, true);
		passed = action.sendDataTo(CUGDescription_InputBox, "Testing CUG");
		passed = action.waitFor(CUGType_SelectServiceType, 2, true);
		passed = action.clickOn(CUGType_SelectServiceType);
		passed = action.waitFor(MaxServices_testBox, 2, true);
		passed = action.sendDataTo(MaxServices_testBox, "5");
		passed = action.waitFor(ChargeGroup_dropdown, 4, true);
		passed = action.selectBy(ChargeGroup_dropdown, 2);
		passed = action.waitFor(CUGType_SelectServiceType, 4, true);
		passed = action.selectByPartialText(ServCallType_Dropdown, "CE");
		passed = action.waitFor(3);
		passed = action.waitFor(Accept_Button, 4, true);
		passed = action.clickOn(Accept_Button);
		passed = action.waitFor(4);		
		
		return passed;
	}

	public boolean CUGNewSuccessMsg()
	{
		boolean passed = false;
		
		String SuccessMsg = "CUG created successfully.";
		String ActualMsg = "";
		By x = By.xpath("//*[@class='icePnlTbSetCnt commonPanelTabTableSetCnt']/div[1]/div[2]/span[1]");
		
		ActualMsg = action.getTextFromPage(x);
		
		passed = ActualMsg.contains(SuccessMsg);		
		
		return passed;
	}
	
	public boolean searchCreatedCUG(String CUGID)
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(LeftLink.AdditionalCustomerInformation.CUGSearch, 4, true);
		passed = action.clickOn(LeftLink.AdditionalCustomerInformation.CUGSearch);
		
		
		action.waitFor(2);
		
		passed = action.waitFor(CUGStartingWith_radio, 4, true);
		passed = action.clickOn(CUGStartingWith_radio);
		action.waitFor(4);
		if(action.countOf(CUGStartingWith_inputBox)>0)
		{
			passed = action.waitFor(CUGStartingWith_inputBox, 4, true);
			passed = action.sendDataTo(CUGStartingWith_inputBox, CUGID);
			passed = action.waitFor(Search_Button, 4, true);
			passed = action.clickOn(Search_Button);
			passed = action.waitFor(4);					
		}
		
		return passed;
	}
	
	public boolean clickServiceTab()
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		By CUG_ColumnSelect = By.xpath("(//*[text()='Result']/following::span)[15]");
		
		if(action.countOf(CUG_ColumnSelect)>0)
		{
			action.waitFor(4);
			passed = action.waitFor(CUG_ColumnSelect, 4, true);
			passed = action.clickOn(CUG_ColumnSelect);
			if(action.countOf(CUG_ColumnSelect) > 0)
				action.clickOn(CUG_ColumnSelect);
		}
		passed = action.waitFor(4);
		passed = action.waitFor(Service_tab, 4, true);
		passed = action.clickOn(Service_tab);
		
		return passed;
	}
	
	
	public boolean provideServiceForCreatedCUG(String PCLWorkingService)
	{
		
		action.waitFor(2);
		boolean passed = false;
		
		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);
		
		passed = action.waitFor(ValidateCUGNum_Button, 4, true);
		passed = action.sendDataTo(ServiceNumber_Input, PCLWorkingService);
		
		passed = action.waitFor(ValidateCUGNum_Button, 4, true);
		passed = action.clickOn(ValidateCUGNum_Button);
		
		return passed;
	}
	
	public boolean clickOkButton()
	{
		
		action.scrollUp();
		action.waitFor(4);
		boolean passed = false;
		
		passed = action.waitFor(Ok_Button, 4, true);
		passed = action.clickOn(Ok_Button);
		
		return passed;
				
	}
	
	public boolean verifyService(String PCLWorkingService)
	{
		action.scrollUp();
		action.waitFor(4);
			
		boolean passed = false;
		
		String AddedServ = "Displaying 1 to";
		String ActualCountofServ = "";
		By x = By.xpath("//*[@class='icePnlTbSetCnt commonPanelTabTableSetCnt']/div[1]/table[2]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[4]/td[1]/span");
		By AddedServiceNumber = By.xpath("//*[text()='Service No:']/following::input[1]");
		By Go_Button = By.xpath("//*[text()='GO']");
		
		passed = action.waitFor(AddedServiceNumber, 4, true);
		passed = action.sendDataTo(AddedServiceNumber, PCLWorkingService);
		passed = action.waitFor(Go_Button, 3, true);
		passed = action.clickOn(Go_Button);
		
		ActualCountofServ = action.getTextFromPage(x);
		passed = ActualCountofServ.contains(AddedServ);
		
		return passed;
		
	}


}


