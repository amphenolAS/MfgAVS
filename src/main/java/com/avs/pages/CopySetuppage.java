/**
* @author manoj.ghadei
*
*/

package com.avs.pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avs.base.BaseClass;
import com.avs.utility.TestUtilities;

public class CopySetuppage extends BaseClass {

	// Page element variable declaration definition
	WebElement SelectAll_ChkboxField = null;
	WebElement Copysetup_btn = null;
	WebElement CopySetupTitle = null;
	WebElement CopySetup_Back_Btn = null;

	// Page element Initialize method
	private void initElements() {
		SelectAll_ChkboxField = driver.findElementByAccessibilityId("chkSelectAll");
		Copysetup_btn = driver.findElementByAccessibilityId("CopySetupButton");
		CopySetupTitle = driver.findElementByName("Copy Setup");
		CopySetup_Back_Btn = driver.findElementByAccessibilityId("BackButton");

	}

	// Constructor for initializing the page elements
	CopySetuppage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		SelectAll_ChkboxField = null;
		Copysetup_btn = null;
		CopySetupTitle = null;
		CopySetup_Back_Btn = null;
	}

	// Click on Copy Setup Back button
	public assetDetailsPage Click_Back_Btn() throws InterruptedException, IOException {
		clickOn(CopySetup_Back_Btn);
		Thread.sleep(2000);
		return new assetDetailsPage();
	}

	// Verify copy successful message displayed
	public boolean CopySetupPage_Title() {
		return IsElementVisibleStatus(CopySetupTitle);
	}

	public void Click_Selectall_chkbox() {
		clickOn(SelectAll_ChkboxField);
	}

	// Click on copy button
	public void click_copy_Btn() throws InterruptedException {
		clickOn(Copysetup_btn);
		Thread.sleep(2000);
	}

	// click on yes or No btn in the alert message
	public void select_alertOption(String choice) {

		WebElement Yes_Alert_btn = driver.findElementByName("Yes");
		WebElement No_Alert_btn = driver.findElementByName("No");
		if (choice.equalsIgnoreCase("Yes")) {
			clickOn(Yes_Alert_btn);
		} else {
			clickOn(No_Alert_btn);
		}
	}

	// Verify copy successful message displayed
	public boolean copysuccessfulmessage() {
		WebElement dmt = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return IsElementVisibleStatus(dmt);
	}

}
