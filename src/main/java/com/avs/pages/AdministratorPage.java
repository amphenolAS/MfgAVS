package com.avs.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;

public class AdministratorPage extends BaseClass {

	// AdministratorPage element variable declaration definition
	WebElement UM_tab = null;


	private void initializeEelements() {
		UM_tab = driver.findElementByAccessibilityId("UserManagementButton");
	}

	AdministratorPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		UM_tab = null;
		//Hardware_Btn = null;
		//Setup_Btn = null;
	}

	// Check the presence of Hardware page header title
	public boolean UMTab_state() {
		return IsElementVisibleStatus(UM_tab);
	}
	
	// Click the UM tab Button to navigate to UM page
	public UserManagementPage click_UMTab() throws InterruptedException, IOException {
		clickOn(UM_tab);
		Thread.sleep(1000);
		return new UserManagementPage();
	}


}
