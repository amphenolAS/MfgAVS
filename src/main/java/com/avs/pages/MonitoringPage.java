package com.avs.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;

public class MonitoringPage extends BaseClass {

	// Monitoring Page element variable declaration definition
	WebElement MonitoringPageTitle = null;
	WebElement Hardware_Btn = null;
	WebElement Setup_Btn = null;

	private void initializeEelements() {
		MonitoringPageTitle = driver.findElementByAccessibilityId("LiveDataHeaderTextBlock");
		Hardware_Btn = driver.findElementByAccessibilityId("btnHardware");
		Setup_Btn = driver.findElementByAccessibilityId("btnCriteria");
	}

	MonitoringPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		MonitoringPageTitle = null;
		Hardware_Btn = null;
		Setup_Btn = null;
	}

	// Check the presence of Monitoring page header title
	public boolean MonitoringPageTitle_state() {
		return IsElementVisibleStatus(MonitoringPageTitle);
	}

	// Click the Hardware button
	public HardwarePage click_HardwareBtn() throws InterruptedException, IOException {
		clickOn(Hardware_Btn);
		Thread.sleep(1000);
		return new HardwarePage();
	}
	
	/*// Get the all About window info like Sw version, FMW ver, Daq, Sbc ver etc.
	public String[] get_About_Text() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();

		WebElement bottomMenu_About_Icon = driver.findElementByAccessibilityId("AboutAppBarButton");
		clickOn(bottomMenu_About_Icon);
		Thread.sleep(500);
		WebElement SWVersion_About_info = driver.findElementByAccessibilityId("SoftwareVersion");
		WebElement FMWVersion_About_info = driver.findElementByAccessibilityId("SbcFmwVerTextBlock");

		String[] SWVer = FetchText(SWVersion_About_info).split(":");
		String[] FMWVer = FetchText(SWVersion_About_info).split(":");
		
		String abt_info = SWVer[1];

		return SWVer[1];
	}*/

}
