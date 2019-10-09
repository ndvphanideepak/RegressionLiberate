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
import com.liberate.automation.pom.PYPOSPayment;

public class POSPaymentTC {
	static TestActions action = CommonLogin.action;

	static Map<String, String> data = new HashedMap<>();

	static String TestCase;
	static String TestStatus;

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		TestActions.log("Test Status : " + TestStatus);
		TestActions.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void posPayment() {
		TestCase = "POSPAYMENT";
		PYPOSPayment pos = new PYPOSPayment(action);
		action.getScreenShot(TestCase);
		pos.navigate();
		action.getScreenShot(TestCase);
		pos.navigateToPOS();
		action.getScreenShot(TestCase);
		pos.searchWithAccountNumber("280009630000");
		action.getScreenShot(TestCase);
		pos.POSPayment();
		action.getScreenShot(TestCase);
		pos.POSAccept();
		action.getScreenShot(TestCase);
		pos.POSSubmit();
		action.getScreenShot(TestCase);
	}
}
