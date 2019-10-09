package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.RandomDataCUG;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.AlterServiceNumber;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRMaintainQuery;
import com.liberate.automation.pom.CUG_POM;
import com.liberate.automation.pom.CeaseService;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.MaintainDepositReason;
import com.liberate.automation.pom.ManageFault;
import com.liberate.automation.pom.NewCustomer;
import com.liberate.automation.pom.PYSinglePayment;
import com.liberate.automation.pom.RaiseFault;
import com.liberate.automation.pom.Reports_POM;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class SanityTestCases 
{
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	//TestData
	static Map<String, String> dataMap = new HashedMap<>();
	static String Sanity_serviceASN;
	static String Sanity_salesDepartment;
	static String Sanity_site;
	static String Sanity_raiseFaultServiceNumber;
	static String Sanity_faultNumber;
	static String Sanity_serviceCease;
	static String Sanity_queryAccountNumber;
	static String Sanity_manageQueryNumber;
	static String sanity_CUGPCLWorkingServiceNum;
	static String LiberateCurrentDate;
	
	
	
	@BeforeClass
	public static void loadData() {
		dataMap = ExcelDataDriver.loadData();
		Sanity_serviceASN = dataMap.get("Sanity_serviceASN");
		Sanity_salesDepartment = dataMap.get("Sanity_salesDepartment");
		Sanity_site = dataMap.get("Sanity_Site");
		Sanity_raiseFaultServiceNumber = dataMap.get("Sanity_raiseFaultServiceNumber");
		Sanity_faultNumber = dataMap.get("Sanity_faultNumber");
		Sanity_serviceCease = dataMap.get("Sanity_serviceCease");
		Sanity_queryAccountNumber = dataMap.get("Sanity_queryAccountNumber");
		Sanity_manageQueryNumber = dataMap.get("Sanity_manageQueryNumber");
		sanity_CUGPCLWorkingServiceNum = dataMap.get("sanity_CUGPCLWorkingServiceNum");
		LiberateCurrentDate = dataMap.get("LiberateCurrentDate");
	}
	/**
	 * Private constructor to disable creation of object
	 */
	private SanityTestCases() {
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 1)
	public static void newCustomerPCLPostpaid() {
		testCase = "Sanity_NewCustomerPCLPostpaid";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,	"PCL", "LIME_POST");
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
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.clickProceedButton();
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
	}
	
	@Test(priority = 16)
	public static void newCustomerPELandPDL() {
		testCase = "Sanity_PELandPDL";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,	"PEL", "ETFT");
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
		ce.provideADSL();
		action.getScreenShot(testCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
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
	}
	
	@Test(priority = 2)
	public static void alterServiceNumberPCL() {
		testCase = "CustomerCareTC_alterServiceNumberPCL";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterServiceNumber asn = new AlterServiceNumber(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(Sanity_serviceASN);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.clickOnAlterServiceNumber();
		action.getScreenShot(testCase);

		asn.selectDepartmentSite(Sanity_salesDepartment, Sanity_site);
		action.getScreenShot(testCase);
		asn.alterServiceNumber(false);
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		Sanity_serviceASN = sales.ServiceNumber;
		sales.signOff();
		action.getScreenShot(testCase);

		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(testCase);
	}
	
	
	
	@Test(priority = 3)
	public static void createNewDepositReason() {
		testCase = "DepositReason_createNewDepositReason";

		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		action.getScreenShot(testCase);
		assertEquals(mdr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot(testCase);
		action.waitFor(By.xpath("//span[@class='iceMsgInfo']"), 2, true);
		String x = action.getTextFromPage(By.xpath("//span[@class='iceMsgInfo']"));
		action.getScreenShot(testCase);
		System.out.println(x);
	}
	
	@Test(priority = 4)
	public static void raiseFault() {
		testCase = "FaultManagement_raiseFault";

		RaiseFault rf = new RaiseFault(action);

		assertEquals(rf.navigate(), true);
		action.getScreenShot(testCase);
		action.waitFor(5);

		assertEquals(rf.enterServiceNumber(Sanity_raiseFaultServiceNumber), true);
		action.getScreenShot(testCase);
		assertEquals(rf.clickonRaiseFaultbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(rf.enterDataInFieldsToRaiseFault(), true);
		action.getScreenShot(testCase);
		assertEquals(rf.clickonAccepttbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(rf.raisedFaultNumber(), true);
		action.getScreenShot(testCase);
	}

	@Test(priority = 5)
	public static void manageFaultAddNotes() {
		testCase = "FaultManagement_manageFaultAddNotes";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber(Sanity_faultNumber), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonMaintainFaultnotesactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonAddNotesbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.enterDataInAddNotestextfield("Test"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonAddNotesApplybutton(), true);
		action.getScreenShot(testCase);
	}

	@Test(priority=6)
	public static void assignFault() {
		testCase = "FaultManagement_assignFault";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

//		assertEquals(mf.enterFaultNumber(Sanity_faultNumber), true);
		assertEquals(mf.enterFaultNumber("C00009E"), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonAssignFaultactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectDepartmentDropdown(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonAssignFaultAssignbutton(), true);
		action.getScreenShot(testCase);
	}

	@Test(priority = 7)
	public static void signoffFault() {
		testCase = "FaultManagement_signoffFault";

		ManageFault mf = new ManageFault(action);

		assertEquals(mf.navigate(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.enterFaultNumber(Sanity_faultNumber), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSearchbutton(), true);
		action.getScreenShot(testCase);

		assertEquals(mf.clickonSignOffactionbutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.selectSignoffDropDowns(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.clickonSignOffApplybutton(), true);
		action.getScreenShot(testCase);
		assertEquals(mf.statusOfFaultNumber(), "Cleared");
		action.getScreenShot(testCase);
	}
	
	@Test(priority = 8)
	public static void ceaseServiceNumberPCL() {
		testCase = "CustomerCareTC_ceaseServiceNumberPCL";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CeaseService cease = new CeaseService(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
//		search.searchByServiceNumber(Sanity_serviceCease);
		search.searchByServiceNumber("9292108");
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.clickOnCeaseService();
		action.getScreenShot(testCase);

//		cease.selectDepartmentSite(Sanity_salesDepartment, Sanity_site);
		cease.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		cease.ceaseService();
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		sales.signOff();
		action.getScreenShot(testCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(testCase);
	}

	@Test(priority = 9)
	public static void raiseQueryAccount() {
		testCase = "QueryManagement_raiseQueryAccount";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount(Sanity_queryAccountNumber);
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 10)
	public static void amendQuery() {
		testCase = "QueryManagement_amendQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(Sanity_manageQueryNumber);
		action.getScreenShot(testCase);
		//mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.amendQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 11)
	public static void addNoteQuery() {
		testCase = "QueryManagement_addNoteQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(Sanity_manageQueryNumber);
		action.getScreenShot(testCase);
//		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.addNote("Additional Note");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 12)
	public static void progressQuery() {
		testCase = "QueryManagement_progressQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(Sanity_manageQueryNumber);
		action.getScreenShot(testCase);
//		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 13)
	public static void signOffQuery() {
		testCase = "QueryManagement_signOffQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount(Sanity_queryAccountNumber);
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
	
	@Test(priority = 14)
	public static void singlePaymentAccountNumber() {
		testCase = "PaymentsTC_singlePaymentAccountNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot(testCase);
		sp.doSinglePayment("10.00");
		action.getScreenShot(testCase);
		sp.verifySuccessMessage();
		action.getScreenShot(testCase);
	}
	
	@Test(priority = 15)
	public static void sanityCUG_Test() 
	{
		testCase = "CUGTesting_Sanity";

		CUG_POM cug = new CUG_POM(action);
		RandomDataCUG random = new RandomDataCUG();
		
		cug.navigation_CUG();
		action.getScreenShot(testCase);
		cug.newCUG_Click();
		action.getScreenShot(testCase);
		String x = random.nextString().substring(1);
		assertEquals(cug.provideCUGDetails(x), true);
		action.getScreenShot(testCase);
		cug.CUGNewSuccessMsg();
		action.getScreenShot(testCase);
		cug.searchCreatedCUG(x);
		action.getScreenShot(testCase);
		cug.clickServiceTab();
		action.getScreenShot(testCase);		
		cug.provideServiceForCreatedCUG(sanity_CUGPCLWorkingServiceNum);
//		cug.provideServiceForCreatedCUG("9290789");
		action.getScreenShot(testCase);
		cug.clickOkButton();
		action.getScreenShot(testCase);
		cug.verifyService(sanity_CUGPCLWorkingServiceNum);
				
	}
	
	@Test(priority = 15)
	public static void sanityReports_Test() 
	{
		testCase = "CUGTesting_Sanity";

		Reports_POM reports = new Reports_POM(action);
		
		reports.navigateToGenerateReport();
		action.getScreenShot(testCase);
		reports.provideDetails();
		action.getScreenShot(testCase);
		reports.clickonAcceptButton();
		action.getScreenShot(testCase);
		reports.navigateBrowseReports();
		action.getScreenShot(testCase);
		reports.provideReportIdToSearch();
		action.getScreenShot(testCase);
		reports.clickingOnSearch();
		action.getScreenShot(testCase);
		reports.selectGenaratedReport();
		action.getScreenShot(testCase);
		reports.reportDateValidation(LiberateCurrentDate); // need to provide current liberate date in excel
//		reports.reportDateValidation("30-05-2018");
		action.getScreenShot(testCase);
		
	}
	
	
}
