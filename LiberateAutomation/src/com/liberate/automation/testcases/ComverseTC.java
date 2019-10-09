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
import com.liberate.automation.pom.AccountOffers;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.ComverseTab;
import com.liberate.automation.pom.DashBoard;
import com.liberate.automation.pom.ServiceOperations;

public class ComverseTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;
	static Map<String, String> data = new HashedMap<>();

	static String comverseServiceNumber = "9371147";
	static String comverseServiceNumberTo = "5380777";

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		// comverseServiceNumber = data.get("comverseServiceNumber");
		// comverseServiceNumberTo = data.get("comverseServiceNumberTo");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void getComverseServiceDetails() {
		testCase = "ComverseTC_getComverseServiceDetails";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		service.navigate();
		action.getScreenShot(testCase);
		service.gotoComverseTab();
		action.getScreenShot(testCase);
		comverse.verifyComverseEnquiry();
		action.getScreenShot(testCase);
	}

	@Test
	public static void getHistoricalData() {
		testCase = "ComverseTC_getHistoricalData";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		service.navigate();
		action.getScreenShot(testCase);
		service.gotoComverseTab();
		action.getScreenShot(testCase);
		comverse.verifyComverseEnquiry();
		action.getScreenShot(testCase);
		comverse.getHistoricalData();
		action.getScreenShot(testCase);
	}

	@Test
	public static void verifyBalanceBalance() {
		testCase = "ComverseTC_verifyBalanceBalance";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		service.navigate();
		action.getScreenShot(testCase);
		service.gotoComverseTab();
		action.getScreenShot(testCase);
		comverse.verifyComverseEnquiry();
		action.getScreenShot(testCase);
		comverse.changeBalance();
		action.getScreenShot(testCase);
	}

	@Test
	public static void adjustBalance() {
		testCase = "ComverseTC_adjustBalance";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		service.navigate();
		action.getScreenShot(testCase);
		service.gotoComverseTab();
		action.getScreenShot(testCase);
		comverse.verifyComverseEnquiry();
		action.getScreenShot(testCase);
		comverse.changeBalance1();
		action.getScreenShot(testCase);
		comverse.adjustBalance();
		action.getScreenShot(testCase);
	}

	@Test
	public static void setBalance() {
		testCase = "ComverseTC_setBalance";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		service.navigate();
		action.getScreenShot(testCase);
		service.gotoComverseTab();
		action.getScreenShot(testCase);
		comverse.verifyComverseEnquiry();
		action.getScreenShot(testCase);
		comverse.changeBalance();
		action.getScreenShot(testCase);
		comverse.setBalance();
		action.getScreenShot(testCase);
	}
	
	@Test
	public static void transferBalance() {
		testCase = "ComverseTC_transferBalance";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		service.navigate();
		action.getScreenShot(testCase);
		service.gotoComverseTab();
		action.getScreenShot(testCase);
		comverse.verifyComverseEnquiry1();
		action.getScreenShot(testCase);
		comverse.changeBalance2();
		action.getScreenShot(testCase);
		comverse.transferBalance1(comverseServiceNumberTo);
	}

	@Test
	public static void addNewAccountOffer() {
		testCase = "ComverseTC_addNewAccountOffer";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		AccountOffers accountOffer = new AccountOffers(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(comverseServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);
		accountOffer.navigate();
		action.getScreenShot(testCase);
		accountOffer.addNewAccountOffer1();
		action.getScreenShot(testCase);
	}
}