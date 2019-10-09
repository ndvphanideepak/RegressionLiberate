package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class Reports_POM 

{

	TestActions action = null;
	
	By ExchangeId_Dropdown = By.xpath("//*[text()='Exchange ID :']/following::select[1]");
	By SuspenceReason_Dropdown = By.xpath("//*[text()='Suspense Reason :']/following::select[1]");
	
	By Accept_Button = By.xpath("//*[@value='Accept']");
	
	By ActualResultRepGen_Msg = By.xpath("(//*[@class='icePnlGrp']/span)[2]");
	
	String ExpectedMsg = "Report has been requested";
	
	By ReportNum_input = By.xpath("//*[text()='Report No:']/following::input[1]");
	By Search_Button = By.xpath("//*[@value='Search']");
	By ReportSelection_Column = By.xpath("//*[text()='CIR394G02']");
	By ReportCreationDate_Column = By.xpath("(//*[text()='SUMM'])[1]//following::span[1]");
	

	public Reports_POM(TestActions action) {
		this.action = action;
	}
	
	
	public boolean navigateToGenerateReport() 
	{
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;
				
		passed = action.waitFor(LiberateCommon.LevelOne.Admin, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Admin);
		passed = action.waitFor(LiberateCommon.Admin.WithdrawnItems, 4, true);
		passed = action.clickOn(LiberateCommon.Admin.WithdrawnItems);
		passed = action.waitFor(LeftLink.WithdrawnItems.RequestSuspensebyExchangeIdReport, 4, true);
		passed = action.clickOn(LeftLink.WithdrawnItems.RequestSuspensebyExchangeIdReport);
		passed = action.waitFor(4);

		return passed;
				
	}
	
	public boolean provideDetails()
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(ExchangeId_Dropdown, 4, true);
		passed = action.selectBy(ExchangeId_Dropdown, 3);
		passed = action.waitFor(SuspenceReason_Dropdown, 4, true);
		passed = action.selectBy(SuspenceReason_Dropdown, 4);
		passed = action.waitFor(2);
		
		return passed;
	}
	
	public boolean clickonAcceptButton()
	{
		action.scrollUp();
		action.waitFor(2);
		 boolean passed = false;
		 By ActualResultRepGen_Msg = By.xpath("(//*[@class='icePnlGrp']/span)[2]");
		 
		 String ExpectedMsg = "Report has been requested";
		 String x = action.getTextFromPage(ActualResultRepGen_Msg);
		 
		 passed = action.waitFor(Accept_Button, 4, true);
		 passed = action.clickOn(Accept_Button);		 
		 
		 passed = x.contains(ExpectedMsg);
		 return passed;
		
	}
	
	public boolean navigateBrowseReports()
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(LiberateCommon.LevelOne.Home, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Home);
		passed = action.waitFor(LiberateCommon.Home.Reports, 4, true);
		passed = action.clickOn(LiberateCommon.Home.Reports);
		
		return passed;
		
	}
	
	public boolean provideReportIdToSearch()
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(ReportNum_input, 4, true);
		passed = action.sendDataTo(ReportNum_input, "CIR394G02");
		
		return passed;
	}
	
	public boolean clickingOnSearch()
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(Search_Button, 4, true);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	public boolean selectGenaratedReport()
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		passed = action.waitFor(ReportSelection_Column, 4, true);
		passed = action.clickOn(ReportSelection_Column);
		
		return passed;
	}
	
	public boolean reportDateValidation(String LiberateCurrentDate)
	{
		action.scrollUp();
		action.waitFor(2);
		
		boolean passed = false;
		
		String repDat = action.getTextFromPage(ReportCreationDate_Column);
		
		passed = action.waitFor(4);
		passed = repDat.contains(LiberateCurrentDate);
		
		return passed;
	}
	 
	
	
	
	
	
	
	
	
	
	
	
}
