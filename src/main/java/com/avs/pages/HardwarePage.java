package com.avs.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;

public class HardwarePage extends BaseClass {

	// HardwarePage element variable declaration definition
	WebElement HardwarePageTitle = null;
	//WebElement Hardware_Btn = null;
	//WebElement Setup_Btn = null;

	private void initializeEelements() {
		HardwarePageTitle = driver.findElementByName("Hardware");
		//Hardware_Btn = driver.findElementByAccessibilityId("btnHardware");
		//Setup_Btn = driver.findElementByAccessibilityId("btnCriteria");
	}

	HardwarePage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		HardwarePageTitle = null;
		//Hardware_Btn = null;
		//Setup_Btn = null;
	}

	// Check the presence of Hardware page header title
	public boolean HardwarePageTitle_state() {
		return IsElementVisibleStatus(HardwarePageTitle);
	}


}
