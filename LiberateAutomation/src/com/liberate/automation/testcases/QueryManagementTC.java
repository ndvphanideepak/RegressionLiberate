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
import com.liberate.automation.pom.CRMaintainQuery;

/***
 * Class with all Query Management Test Cases
 * 
 * @author Nikhil
 *
 */
public class QueryManagementTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	
	//TestData
		static Map<String, String> dataMap = new HashedMap<>();

		static String queryAccountNumber = "100002500400";
		static String manageQueryNumber = "C00001C";
		static String nonAccountQuery = "C00014I";
		

	
	/**
	 * Private constructor to disable creation of object
	 */
	private QueryManagementTC() {
	}

	@BeforeClass
	public static void loadTestData() {
		dataMap = ExcelDataDriver.loadData();
		
		queryAccountNumber = dataMap.get("queryAccountNumber");
		manageQueryNumber = dataMap.get("manageQueryNumber");
		nonAccountQuery = dataMap.get("nonAccountQuery");
	}

	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 0)
	public static void raiseQueryAccount() {
		testCase = "QueryManagement_raiseQueryAccount";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount(queryAccountNumber);
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 1)
	public static void amendQuery() {
		testCase = "QueryManagement_amendQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber("C00011I");
		action.getScreenShot(testCase);
		//mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.amendQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void addNoteQuery() {
		testCase = "QueryManagement_addNoteQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber("C00006F");
		action.getScreenShot(testCase);
//		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.addNote1("Additional Note");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 3)
	public static void progressQuery() {
		testCase = "QueryManagement_progressQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(manageQueryNumber);
		action.getScreenShot(testCase);
//		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 4)
	public static void signOffQuery() {
		testCase = "QueryManagement_signOffQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount(queryAccountNumber);
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.signOffQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 5)
	public static void raiseAndAuthoriseAdjustment() {
		testCase = "QueryManagement_raiseAndAuthoriseAdjustment";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount(queryAccountNumber);
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.raiseAdjustment();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.authoriseAdjustment();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 6)
	public static void verifyBills() {
		testCase = "QueryManagement_verifyBills";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber("ZK00015");
		action.getScreenShot(testCase);
//		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.verifyBills();
		action.getScreenShot(testCase);
		mq.navigateBackFromBillView();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 7)
	public static void raiseQueryNonAccount() {
		testCase = "QueryManagement_raiseQueryNonAccount";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		nonAccountQuery = mq.QueryNumber;
		action.getScreenShot(testCase);
	}

	@Test(priority = 8)
	public static void amendQueryNonAccount() {
		testCase = "QueryManagement_amendQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(nonAccountQuery);
		action.getScreenShot(testCase);
//		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.amendQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 9)
	public static void signOffQueryNonAccount() {
		testCase = "QueryManagement_signOffQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(nonAccountQuery);
		action.getScreenShot(testCase);
		//mq.raiseAccountQuery();
		//action.getScreenShot(testCase);
		//mq.verifyQuery();
		//action.getScreenShot(testCase);

		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.signOffQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

}
