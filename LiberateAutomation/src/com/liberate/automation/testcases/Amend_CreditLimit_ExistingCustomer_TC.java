package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.Amend_CreditLimit_ExistingCustomer_POM;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.ServiceOperations;

public class Amend_CreditLimit_ExistingCustomer_TC {

	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String AmendCreditLimitServicenumber = "78902481";
	static Map<String, String> data = new HashedMap<>();

	private Amend_CreditLimit_ExistingCustomer_TC() {
	}

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		AmendCreditLimitServicenumber = data.get("AmendCreditLimitServicenumber");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void amendcalllimit() {
		testCase = "Amend Call limit for existing Customer";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations CS = new ServiceOperations(action);
		Amend_CreditLimit_ExistingCustomer_POM Cl= new Amend_CreditLimit_ExistingCustomer_POM(action);
		

		search.navigate();
		search.searchByServiceNumber(AmendCreditLimitServicenumber);
		action.getScreenShot(testCase);

		CS.navigate();
		action.getScreenShot(testCase);
		CS.verifyServicesScreen();
		action.getScreenShot(testCase);
		
		Cl.amendcreditlimit();
		action.getScreenShot(testCase);
		action.Alertaccept();
		Cl.validation();
		action.getScreenShot(testCase);
	}
	
}
