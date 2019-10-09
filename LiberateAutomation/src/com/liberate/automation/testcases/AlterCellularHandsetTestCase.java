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
import com.liberate.automation.pom.AlterCellularHandsetPOM;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.ServiceOperations;

public class AlterCellularHandsetTestCase {

	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;
	
	static String alterhandsetservicenumber = "9179845";
	
	static String department = "AQSAL";
	static String site = "ANSQ";
	static String salesperson;
	static String applicationsource ;
	
	static Map<String, String> data = new HashedMap<>();
	
	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		alterhandsetservicenumber = data.get("alterhandsetservicenumber");
		department = data.get("SalesDepartment");
		salesperson = data.get("salesperson");
		applicationsource = data.get("applicationsource");
		site = data.get("Site");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}
	
	@Test
	public static void altercellularhandset() {
		testCase = "Alter Cellular Handset";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations CS = new ServiceOperations(action);
		ExistingCustomer EC = new ExistingCustomer(action);
		AlterCellularHandsetPOM ACH = new AlterCellularHandsetPOM(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(alterhandsetservicenumber);
		action.getScreenShot(testCase);

		CS.navigate();
		action.getScreenShot(testCase);
		CS.verifyServicesScreen();
		action.getScreenShot(testCase);
		CS.clickonchangehandset();
		action.getScreenShot(testCase);
       
		EC.selectDepartmentSite(department, site);
		 EC.applicationsource();
		action.getScreenShot(testCase);
		ACH.alterhandsetaccept();
		action.getScreenShot(testCase);
		
		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
	}


}
