package com.liberate.automation.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.AllocateRouteServiceOrder;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.MSOAddRemoveServiceCharge;
import com.liberate.automation.pom.MSOAddSpecialInstructions;
import com.liberate.automation.pom.MSOAssign;
import com.liberate.automation.pom.MSOCancelServiceOrder;
import com.liberate.automation.pom.MSOEnquiry;
import com.liberate.automation.pom.MSOManualWaitlistRelease;
import com.liberate.automation.pom.MSORedirect;
import com.liberate.automation.pom.MSOReject;
import com.liberate.automation.pom.MSORelease;
import com.liberate.automation.pom.MSOSignoff;
import com.liberate.automation.pom.MSOSplit;
import com.liberate.automation.pom.MSOSuspend;
import com.liberate.automation.pom.MSOWaitlist;
import com.liberate.automation.pom.PEP_RouteAllocationPOM;

/***
 * Class with Manage Service Order Test Case
 * 
 * @author Nikhil
 *
 */
public class ManageServiceOrderTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static Map<String, String> dataMap = new HashedMap<>();

	static String SOEnquire = "WK00039";
	static String SalesDepartment;
	static String GeneralDepartment = "RSNET";
	static String AccountsDepartment = "BOTEX";
	static String RouteSO;
	static String RedirectSO;
	static String BrowseSO;
	static String AssignSO;
	static String SplitSO ="TK00588";
	static String SuspendSO = "WI00433";
	static String ManualWaitlistSO = "WI00433";
	static String WaitlistSO = "WI00433";
	static String RejectSO = "B00206J";
	static String AccountSO = "WH00759";
	static String GeneralSO = "WL00278";
	static String CancelSO = "WK00039";
	static String ReleaseSO = "WH00780";
	
	static String plantDP;
	static String plantCAB;
	static String plantMDF;
	static String terminal;

	/**
	 * Private constructor to disable creation of object
	 */
	private ManageServiceOrderTC() {
	}

	@BeforeClass
	public static void loadData() {
		dataMap = ExcelDataDriver.loadData();

		SOEnquire = dataMap.get("SOEnquire");
		SalesDepartment = dataMap.get("SalesDepartment");
		GeneralDepartment = dataMap.get("GeneralDepartment");
		AccountsDepartment = dataMap.get("AccountsDepartment");
		RouteSO = dataMap.get("RouteSO");
		RedirectSO = dataMap.get("RedirectSO");
		BrowseSO = dataMap.get("BrowseSO");
		AssignSO = dataMap.get("AssignSO");
		SplitSO = dataMap.get("SplitSO");
		SuspendSO = dataMap.get("SuspendSO");
		ManualWaitlistSO = dataMap.get("ManualWaitlistSO");
		WaitlistSO = dataMap.get("WaitlistSO");
		RejectSO = dataMap.get("RejectSO");
		AccountSO = dataMap.get("AccountSO");
		GeneralSO = dataMap.get("GeneralSO");
		CancelSO = dataMap.get("CancelSO");
		ReleaseSO = dataMap.get("ReleaseSO");
		
		plantDP = dataMap.get("plantDP");
		plantCAB = dataMap.get("plantCAB");
		plantMDF = dataMap.get("plantMDF");
		terminal = dataMap.get("terminal");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 0)
	public static void soEnquiry() {
		testCase = "ManageServiceOrder_soEnquiry";

		MSOEnquiry msr = new MSOEnquiry(action);

		msr.navigate();
		action.getScreenShot(testCase);
		msr.searchServiceOrder(SOEnquire);
		action.getScreenShot(testCase);
		msr.verifyServiceOrderDetails(SOEnquire);
		action.getScreenShot(testCase);
	}

	@Test(priority = 1)
	public static void addSpecialInstructions() {
		testCase = "ManageServiceOrder_addSpecialInstructions";

		MSOAddSpecialInstructions mso = new MSOAddSpecialInstructions(action);
		MSOEnquiry mse = new MSOEnquiry(action);

		action.getScreenShot(testCase);
		mso.navigate();
		action.getScreenShot(testCase);
		mso.searchServiceOrder(SOEnquire);
		action.getScreenShot(testCase);
		mso.verifyServiceOrderDetails();
		action.getScreenShot(testCase);
		mso.addSpecialInstruction();
		action.getScreenShot(testCase);
		mso.clickOnOKpopup();
		action.getScreenShot(testCase);

		mse.navigate();
		action.getScreenShot(testCase);
		mse.searchServiceOrder(SOEnquire);
		action.getScreenShot(testCase);
		mse.verifyServiceOrderDetails(SOEnquire);
		action.getScreenShot(testCase);
		mse.verifySepcialInstructions1(mso.SpecialInstruction);
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void addServiceCharge() {
		testCase = "ManageServiceOrder_addServiceCharge";

		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);

		msr.navigate();
		action.getScreenShot(testCase);
		msr.searchServiceOrder("RSNET", SOEnquire);
		action.getScreenShot(testCase);
		msr.verifyServiceOrderDetails();
		action.getScreenShot(testCase);
		msr.addServiceCharge1();
		action.getScreenShot(testCase);
		msr.verifyServiceCharge(msr.ServiceCharge, true);
		action.getScreenShot(testCase);
	}

	@Test(priority = 3)
	public static void removeServiceCharge() {
		testCase = "ManageServiceOrder_removeServiceCharge";

		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);

		msr.navigate();
		action.getScreenShot(testCase);
		msr.searchServiceOrder("RSNET", SOEnquire);
		action.getScreenShot(testCase);
		msr.verifyServiceOrderDetails();
		action.getScreenShot(testCase);
		msr.deleteServiceCharge1();
		action.getScreenShot(testCase);
		msr.verifyServiceCharge(msr.ServiceCharge, false);
		action.getScreenShot(testCase);
	}

	@Test(priority = 4) 
	public static void cancelServiceOrder() {
		testCase = "ManageServiceOrder_cancelServiceOrder";

		MSOCancelServiceOrder msc = new MSOCancelServiceOrder(action);
		MSOEnquiry mse = new MSOEnquiry(action);

		msc.navigate();
		action.getScreenShot(testCase);
		msc.searchServiceOrder("RSNET", CancelSO);
		action.getScreenShot(testCase);
		msc.verifyServiceOrdeDetails(msc.ServiceOrderNumber);
		action.getScreenShot(testCase);
		msc.cancelServiceOrder();
		action.getScreenShot(testCase);
		msc.clickOnOKButton1();
		action.getScreenShot(testCase);

		mse.navigate();
		action.getScreenShot(testCase);
		mse.searchServiceOrder(msc.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mse.verifyDepartmentCirculation();
		action.getScreenShot(testCase);
		mse.getCurrentServiceOrderStatus1();
		action.getScreenShot(testCase);
	}

	@Test(priority = 5)
	public static void generalSignOffServiceOrder() {
		testCase = "ManageServiceOrder_generalSignOffServiceOrder";

		MSOSignoff mss = new MSOSignoff(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(GeneralDepartment, GeneralSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.generalSignOff();
		action.getScreenShot(testCase);
	}

	@Test(priority = 6)
	public static void accountSignOffServiceOrder() {
		testCase = "ManageServiceOrder_accountSignOffServiceOrder";

		MSOSignoff mss = new MSOSignoff(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(AccountsDepartment, AccountSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.accountSignOff();
		action.getScreenShot(testCase);
	}

	@Test(priority = 7)
	public static void rejectServiceOrder() {
		testCase = "ManageServiceOrder_rejectServiceOrder";

		MSOReject mss = new MSOReject(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder("AQSOF", RejectSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.reject();
		action.getScreenShot(testCase);
	}

	@Test(priority = 9)
	public static void releaseServiceOrder() {
		testCase = "ManageServiceOrder_releaseServiceOrder";

		MSORelease mss = new MSORelease(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(AccountsDepartment, ReleaseSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.releaseServiceOrder();
		action.getScreenShot(testCase);
	}

	@Test(priority = 10)
	public static void waitlistServiceOrder() {
		testCase = "ManageServiceOrder_waitlistServiceOrder";

		MSOWaitlist mss = new MSOWaitlist(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(AccountsDepartment, WaitlistSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.waitlistServiceOrder();
		action.getScreenShot(testCase);
	}

	@Test(priority = 11)
	public static void manualWaitlistReleaseServiceOrder() {
		testCase = "ManageServiceOrder_manualWaitlistReleaseServiceOrder";

		MSOManualWaitlistRelease mss = new MSOManualWaitlistRelease(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(AccountsDepartment, ManualWaitlistSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.manualWaitlistRelease();
		action.getScreenShot(testCase);
	}

	@Test(priority = 8)
	public static void suspendSeviceOrder() {
		testCase = "ManageServiceOrder_suspendSeviceOrder";

		MSOSuspend mss = new MSOSuspend(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(AccountsDepartment, SuspendSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.suspendServiceOrder();
		action.getScreenShot(testCase);
	}

	@Test(priority = 12)
	public static void splitServiceOrder() {
		testCase = "ManageServiceOrder_splitServiceOrder";

		MSOSplit mss = new MSOSplit(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder(AccountsDepartment, SplitSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.splitServiceOrder();
		action.getScreenShot(testCase);
	}

	@Test(priority = 13)
	public static void assignServiceOrder() {
		testCase = "ManageServiceOrder_assignServiceOrder";

		MSOAssign mss = new MSOAssign(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder1(AccountsDepartment, AssignSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.assignServiceOrder1();
		action.getScreenShot(testCase);
	}

	@Test(priority = 14)
	public static void browseSO() {
		testCase = "ManageServiceOrder_browseSO";

		BrowseServiceOrder mss = new BrowseServiceOrder(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder1(GeneralDepartment, BrowseSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails1(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
	}

	@Test(priority = 15)
	public static void redirectSO() {
		testCase = "ManageServiceOrder_redirectSO";

		MSORedirect mss = new MSORedirect(action);

		mss.navigate();
		action.getScreenShot(testCase);
		mss.searchServiceOrder("BGCNG", RedirectSO);
		action.getScreenShot(testCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(testCase);
		mss.redirectServiceOrder();
		action.getScreenShot(testCase);
		mss.validateMessage();
		action.getScreenShot(testCase);
	}

	@Test(priority = 16)
	public static void allocateCopperRoute() {
		testCase = "ManageServiceOrder_allocateCopperRoute";

		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot(testCase);
		arso.searchServiceOrder("RSNET", RouteSO);
		action.getScreenShot(testCase);
		arso.allocateAuto(CommonData.PlantItemType.CopperDP, "DP900");
		action.getScreenShot(testCase);
		arso.verifyAutoAllocateRoute();
		action.getScreenShot(testCase);
	}
	
	@Test(priority = 17)
	public static void allocateCopperRouteManual() {
		testCase = "ManageServiceOrder_allocateCopperRoute";

		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot(testCase);
		arso.searchServiceOrder("RSNET", "WK00226");
		action.getScreenShot(testCase);
		arso.allocateManual(plantDP, plantCAB, plantMDF, terminal);
		action.getScreenShot(testCase);
		arso.verifyManualAllocateRoute();
		action.getScreenShot(testCase);
	}
	
	public static void allocatePEPRouteAuto() {
		testCase = "ManageServiceOrder_AutoAllocateRoutePEP";

		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);
		PEP_RouteAllocationPOM pep = new PEP_RouteAllocationPOM(action);
		
		arso.navigate();
		action.getScreenShot(testCase);
		arso.searchServiceOrder("RSNET", "B00583A");
		action.getScreenShot(testCase);
		pep.allocateRoutePEPLEG11("DP-DISTRIBUTION POINT", "DP950");
		action.getScreenShot(testCase);
		pep.clickingOnValidateButton();
		action.getScreenShot(testCase);
		pep.allocateRoutePEPLEG21("DP-DISTRIBUTION POINT", "370");
		action.getScreenShot(testCase);
		pep.clickingOnFinalAcceptButton1();
		action.getScreenShot(testCase);
		pep.verifyAutoAllocateRoute1();
		action.getScreenShot(testCase);
		
	}

	@Test(enabled = false)
	public static void allocateFiberRoute() {
		testCase = "ManageServiceOrder_allocateFiberRoute";

		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot(testCase);
		arso.searchServiceOrder("BGNET", RouteSO);
		action.getScreenShot(testCase);
		arso.allocateAuto(CommonData.PlantItemType.FiberDP, "FDP2");
		action.getScreenShot(testCase);
		arso.verifyAutoAllocateRoute();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void signOffCompletely(String ServiceOrder) {
		testCase = "ManageServiceOrder_signOffCompletely";

		List<String> Department = new ArrayList<String>();

		MSOEnquiry enquiry = new MSOEnquiry(action);
		MSOSignoff signoff = new MSOSignoff(action);

		enquiry.navigate();
		enquiry.searchServiceOrder(ServiceOrder);
		enquiry.verifyDepartmentCirculation();
		Department = enquiry.getCurrentDepartments();

		signoff.navigate();
		for (int i = 0; i < Department.size(); i++) {
			CommonPanel.ServiceOrder.Search(action, Department.get(i), ServiceOrder);
			signoff.accountSignOff();
		}
	}
	
	//test method used in alterServiceNumberPCLServiceCharge()
	@Test(enabled = false)
	public static void signOffCompletely1(String ServiceOrder) {
		testCase = "ManageServiceOrder_signOffCompletely";

		List<String> Department = new ArrayList<String>();
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		MSOEnquiry enquiry = new MSOEnquiry(action);
		MSOSignoff signoff = new MSOSignoff(action);
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		enquiry.navigate();
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		enquiry.searchServiceOrder(ServiceOrder);
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		enquiry.verifyDepartmentCirculation();
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		Department = enquiry.getCurrentDepartments();
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		signoff.navigate();
		action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		for (int i = 0; i < Department.size(); i++) {
			action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
			CommonPanel.ServiceOrder.Search(action, Department.get(i), ServiceOrder);
			action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
			action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
			action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
			signoff.accountSignOff();
			action.getScreenShot("CustomerCareTC_alterServiceNumberPCLServiceCharge");
		}
	}
}
