/**
 * @author manoj.ghadei
 *
 */

package com.avs.testcases;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.avs.base.BaseClass;
import com.avs.pages.AdministratorPage;
import com.avs.pages.LoginPage;
import com.avs.pages.MainHubPage;
import com.avs.pages.MonitoringPage;
import com.avs.pages.SelectBaseStationPage;
import com.avs.pages.UserManagementPage;
import com.avs.utility.TestUtilities;
import com.avs.utility.setupCreationUtility;
import com.avs.utility.userManagementUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest extends BaseClass{
	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExtentReports extent;
	public ExtentTest extentTest;
	TestUtilities tu = new TestUtilities();
	
	//Initialization of pages
	LoginPage LoginPage;
	MainHubPage MainHubPage;
	AdministratorPage AdministratorPage;
	UserManagementPage UserManagementPage;
	SelectBaseStationPage SelectBaseStationPage;
	MonitoringPage MonitoringPage;
	
	//Before All the tests are conducted
	@BeforeClass
	//@BeforeTest
	private void PreSetUp() throws IOException, InterruptedException, AWTException {
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ER"+"_LoginTest"+".html",true);
		extent.addSystemInfo("TestSuiteName", "LoginTest");
		extent.addSystemInfo("User Name", prop.getProperty("User_Name1"));
		System.out.println("Login Test in Progress..");
		
		
		//Rename the User file (NgvUsers.uxx) if exists
		renameFile("C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles\\AppData", "NgvUsers.uux");
		// Rename the VRT folder if exists
		renameFile("C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles", "Setups");
		renameFile("C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles", "Assets");
		renameFile("C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles\\", "Cache");
		renameFile("C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles", "Equipments");

		//Launch AVS app
		LaunchApp("Kaye.NextGenValidator_tdxctrh6k91jc!App");
		
		LoginPage = new LoginPage();
		String AVSappVer =  LoginPage.get_SWVersion_About_Text();
		System.out.println(AVSappVer);
		extent.addSystemInfo("AVS Version", AVSappVer);
		UserManagementPage = LoginPage.DefaultLogin();
		LoginPage = UserManagementPage.FirstUserCreation("User1", getUID("adminFull"), getPW("adminFull"),
				getPW("adminFull"), "FullAdmin", "12345678", "abc@gmail.com");
		MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));
		AdministratorPage = MainHubPage.Click_AdminTile();
		UserManagementPage = AdministratorPage.click_UMTab();
		UserManagementPage.clickAnyUserinUserList("User1");

		UserManagementPage.clickPrivRunQual();
		UserManagementPage.clickPrivCreateEditAsset();
		UserManagementPage.clickPrivCreateEditSetup();
		UserManagementPage.clickPrivRunCal();

		UserManagementPage.ClickNewUserSaveButton();
		UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
		MainHubPage = UserManagementPage.ClickBackButn();

		AppClose();
		Thread.sleep(1000);
		
	}
	
	//After All the tests are conducted
	//@AfterTest
	@AfterClass
	public void endReport(){
		extent.flush();
		extent.close();
		System.out.println("Login Test Completed.");
	}
	
	//Before Test
	@BeforeMethod(alwaysRun=true)
	public void Setup() throws InterruptedException, IOException {
		//LaunchApp("Kaye.ValProbeRT_racmveb2qnwa8!App");
		LaunchApp("Kaye.NextGenValidator_tdxctrh6k91jc!App");
		Thread.sleep(1000);
		LoginPage = new LoginPage();
		MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));
	}

	@AfterMethod(alwaysRun=true)
	public void Teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS # "+result.getName()+" #"); //to add name in extent report
			// TearDown of the App
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS # "+result.getThrowable()+" #"); //to add error/exception in extent report
			
			String screenshotPath1 = TestUtilities.getFailedTCScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath1)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS # " + result.getName()+" #");
			//String screenshotPath2 = TestUtilities.getPassTCScreenshot(driver, result.getName());
			//extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath2)); //to add screenshot in extent report
		}		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		LoginPage.resetWebElements();
		driver.quit();
		driver = null;
	}
	
	
	/********
	Test Cases
	*********/
	
	
	//installation with default provided credentials
	@Test(groups = {"Regression"}, description="LOGIN_001- Verify if user can log "
			+ "into the Kaye Application after installation with default provided credentials")
	public void LOGIN_001() throws InterruptedException, IOException {
		extentTest = extent.startTest("LOGIN_001- Verify if user can log into the Kaye Application"
				+ " after installation with default provided credentials");

		SoftAssert sa = new SoftAssert();
		SelectBaseStationPage = MainHubPage.Click_DiscoverTile();
		sa.assertEquals(SelectBaseStationPage.SelectBaseStationTitle_state(), true, "FAIL: Didnt land in Select BS Page");
		SelectBaseStationPage.click_DiscoverBtn();
		//SelectBaseStationPage.click_USBTile(); //Click the docking USB tile
		SelectBaseStationPage.click_AVSTile();
		MonitoringPage = SelectBaseStationPage.click_ConnectBtn();
		sa.assertEquals(MonitoringPage.MonitoringPageTitle_state(), true, "FAIL: Didnt land in Select BS Page");
		//MonitoringPage.get_SWVersion_About_Text();
		sa.assertAll();
	}
	
	
}
