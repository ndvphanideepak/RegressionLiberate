package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.ExchangeSignoff;

public class ExchangeSignoffTC {

	
	static TestActions action = CommonLogin.action;

	static String TestCase;
	static String TestStatus;

	static Map<String, String> data = new HashedMap<>();
	static String exchangesignoffserviceordernumber;

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();

		// Just an example on how to get data
		exchangesignoffserviceordernumber = data.get("exchangesignoffserviceordernumber"); // Add it in excel
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		TestActions.log("Test Status : " + TestStatus);
		TestActions.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}
	
	
	@Test
	public static void exchangesignoff() {
		TestCase = "exchangesignoff";
		BrowseServiceOrder order = new BrowseServiceOrder(action);
		ExchangeSignoff  exsignoff = new ExchangeSignoff(action);
		
		order.navigate();
		action.getScreenShot(TestCase);
		
		exsignoff.selectDepartmentSite("BOTEX", "WI00209");
		action.getScreenShot(TestCase);
		exsignoff.signoffbutton();
		exsignoff.accept();
		action.getScreenShot(TestCase);
		exsignoff.generalsignoff();
		action.getScreenShot(TestCase);
	
	
	
	
	
	
	}	
	
}
