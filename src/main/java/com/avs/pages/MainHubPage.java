/**
 * @author manoj.ghadei
 *
 */

package com.avs.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.avs.base.BaseClass;

public class MainHubPage extends BaseClass {

	// Main Hub Page Element definition
	WebElement MainUILoggedinUserTitle = null;
	WebElement MainUILoggedinUserName = null;
	WebElement MainUIAdminTile = null;
	WebElement AssetCountInfoInAsstTile = null;
	WebElement MainUIPageTitle = null;
	WebElement MainUIEquipmentTitle = null;
	WebElement FileManagementTitle = null;
	WebElement AuditTitle = null;
	WebElement DiscoverTile = null;

	private void initElements() {
		// Main Hub Page Page Element definition
		MainUILoggedinUserTitle = driver.findElementByAccessibilityId("UserDesignationTextBlock");
		MainUILoggedinUserName = driver.findElementByAccessibilityId("UserNameTextBlock");
		MainUIAdminTile = driver.findElementByName("Admin");
		AssetCountInfoInAsstTile = driver.findElementByAccessibilityId("TitleCountTextBlock");
		MainUIPageTitle = driver.findElementByName("Advanced Validation System");
		MainUIEquipmentTitle = driver.findElementByName("Equipment");
		FileManagementTitle = driver.findElementByName("File Management");
		AuditTitle = driver.findElementByName("Audit");
		DiscoverTile = driver.findElementByName("Discover");
	}

	public MainHubPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		MainUILoggedinUserTitle = null;
		MainUILoggedinUserName = null;
		MainUIAdminTile = null;
		AssetCountInfoInAsstTile = null;
		MainUIPageTitle = null;
		MainUIEquipmentTitle = null;
		FileManagementTitle = null;
		AuditTitle = null;
		DiscoverTile = null;
		// System.out.println("Login Page elements memory released");
	}

	// Verify the Main Hub Page title name
	public boolean mainPageTitle() {
		return IsElementVisibleStatus(MainUIPageTitle);
	}

	// Is UserDesignation text Block Presence

	public boolean IsUserDesigBlockPresence() {
		WebElement UserDesigTextBlock = driver.findElementByAccessibilityId("UserDesignationTextBlock");
		return IsElementEnabledStatus(UserDesigTextBlock);
	}

	// Verify the Logged in User credentials
	public String LoggedinUserName() {
		return FetchText(MainUILoggedinUserName);
	}

	//
	public String UserNameText() {
		WebElement UserNameText = driver.findElementByAccessibilityId("UserNameTextBlock");
		return FetchText(UserNameText);
	}

	// Sign out Operation
	public LoginPage UserSignOut() throws InterruptedException, IOException {
		clickOn(MainUILoggedinUserName);
		Thread.sleep(500);
		WebElement MainUISignOut = driver.findElementByName("Sign out");
		clickOn(MainUISignOut);
		Thread.sleep(1000);
		return new LoginPage();
	}
	
	// Click the Admin Tile to go to default Administrator page
	public AdministratorPage Click_AdminTile() throws InterruptedException, IOException {
		clickOn(MainUIAdminTile);
		Thread.sleep(500);

		return new AdministratorPage();
	}

	// Click the Admin Tile to directly go to UM page
	public UserManagementPage ClickAdminTile_UMpage() throws InterruptedException, IOException {
		clickOn(MainUIAdminTile);
		Thread.sleep(500);

		return new UserManagementPage();
	}

	// Click the Admin Tile when SuperVisor does not have default access privilege
	public void ClickAdminTile() throws InterruptedException {
		clickOn(MainUIAdminTile);
		Thread.sleep(500);
	}

	// Fetch the alert message when Supervisor is unable to access Archive data
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}

	// Click the Asset Tile
	public assetHubPage ClickAssetTile() throws InterruptedException, IOException {
		WebElement MainUIAssetTile = driver.findElementByName("Assets");
		clickOn(MainUIAssetTile);
		Thread.sleep(500);
		return new assetHubPage();
	}

	// Fetch the Asset count data in the Asset Tile
	public String AssetCountInAssetTileOfMainHubPage() throws InterruptedException {
		String AstCnt = FetchText(AssetCountInfoInAsstTile);
		// System.out.println("AstCnt in Main Hub Page: "+AstCnt);
		return AstCnt;
	}

	// Click the Equipment Tile
	public EquipmentHubPage ClickEquipmentTile() throws InterruptedException, IOException {
		clickOn(MainUIEquipmentTitle);
		Thread.sleep(500);
		return new EquipmentHubPage();
	}

	// Click the Equipment Tile
	public FileManagementPage ClickFileManagementTitle() throws InterruptedException, IOException {
		clickOn(FileManagementTitle);
		Thread.sleep(500);
		return new FileManagementPage();
	}

	// Click the Audit Tile
	public AuditPage ClickAuditTitle() throws InterruptedException, IOException {
		clickOn(AuditTitle);
		Thread.sleep(500);
		return new AuditPage();
	}

	// Click the Audit Tile
	public void Alert_AuditTitle() throws InterruptedException {
		clickOn(AuditTitle);
		Thread.sleep(500);
	}
	
	// Click the Discover Tile
	public SelectBaseStationPage Click_DiscoverTile() throws InterruptedException, IOException {
		clickOn(DiscoverTile);
		Thread.sleep(500);
		return new SelectBaseStationPage();
	}
}
