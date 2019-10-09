package com.liberate.automation.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.AddMore;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.NewCustomer;
import com.liberate.automation.pom.SalesSignOff;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

/***
 * Class with Service Provisioning Test Cases
 * 
 * @author Nikhil
 *
 */
public class ServiceProvisioningTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String arnServiceNumber = "78902566";
	
	//TestData
			static Map<String, String> dataMap = new HashedMap<>();

			static String PDLServicePackage;

	/**
	 * Private constructor to disable creation of object
	 */
	ServiceProvisioningTC() {
	}

	@BeforeClass
	public static void loadTestData() {
		dataMap = ExcelDataDriver.loadData();
		
		PDLServicePackage = dataMap.get("PDLServicePackage");
	}

	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(enabled=true,priority = 1)
	
	public static void newCustomerPEL() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_newCustomerPEL";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", "ServiceProvisioningTC_newCustomerPEL.mp4", false);
		recorder.start();

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "TESTPEL");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "PEL_TEST");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		
		recorder.stop();
	}

	@Test(enabled=false,priority = 2)
	public static void existingCustomerPEL() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_existingCustomerPEL";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", "ServiceProvisioningTC_existingCustomerPEL", false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280015150000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "AAAbsolute-Deepak(PEL)");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 3)
	public static void existingCustomerPCLPostpaid() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_existingCustomerPCLPostpaid";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();
		

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280007070000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST-LIME_POST_PAID(PCL)");
		// ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
			ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCB", "SMPR");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 4)
	public static void newCustomerPCLPostpaid() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_newCustomerPCLPostpaid";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.MobilepostpaidResidential, CommonData.CustomerType.Residential,
				"PCL", "LIME_POST-LIME_POST_PAID(PCL)");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.Address1();
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		cp.billstatusarea();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
	
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST-LIME_POST_PAID(PCL)");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCB", "SMPR");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 5)
	public static void newCustomerPCLCreditLimit() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_newCustomerPCLCreditLimit";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.MobilepostpaidResidential, CommonData.CustomerType.Residential,
				"PCL", "PCL_Automa");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 6)
	public static void existingCustomerPDL() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_existingCustomerPDL";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.skipLinkedServices();
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipLinkedServices();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 8)
	public static void existingCustomerPTV() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_existingCustomerPTV";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PTV - ", "CableTV");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 9)
	public static void existingCustomerIPTV() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_existingCustomerIPTV";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PTI - ", "IPTVBasic");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 10)
	public static void existingCustomerARN() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_existingCustomerARN";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectNonPackage("ARN");
		action.getScreenShot(testCase);

		ce.processServiceNoScreen(arnServiceNumber);
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 11)
	public static void newCustomerPELandPDL() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_newCustomerPELandPDL";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "TESTPEL");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		ce.address_change();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();

		action.getScreenShot(testCase);
		ce.provideADSL();
		action.getScreenShot(testCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled=true,priority = 12)
	public static void addMorePELandPDL() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_addMorePELandPDL";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.addMore();
		action.getScreenShot(testCase);

		addmore.addADSL();
		action.getScreenShot(testCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}

	@Test(enabled = true, priority = 13)
	public static void addMorePELandPCL() throws ATUTestRecorderException {
		testCase = "ServiceProvisioningTC_addMorePELandPCL";
		ATUTestRecorder recorder = new ATUTestRecorder("VideoScreenshot", testCase, false);
		recorder.start();

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.addMore();
		action.getScreenShot(testCase);

		addmore.addServicePackage();
		action.getScreenShot(testCase);

		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		// ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
		recorder.stop();
	}
}
