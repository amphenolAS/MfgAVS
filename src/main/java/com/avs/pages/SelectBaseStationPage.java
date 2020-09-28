package com.avs.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;

public class SelectBaseStationPage extends BaseClass {

	// SelectBaseStationPage page element variable declaration definition
	WebElement SelectBaseStationTitle = null;
	WebElement Discover_Btn = null;
	WebElement USB_Tile = null;
	WebElement Connect_Btn = null;

	private void initializeEelements() {
		SelectBaseStationTitle = driver.findElementByName("Select AVS");
		Discover_Btn = driver.findElementByAccessibilityId("DiscoverIOBoxButton");
		USB_Tile = driver.findElementByAccessibilityId("textUsbIp");
		Connect_Btn = driver.findElementByAccessibilityId("btnConnect");
	}

	SelectBaseStationPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		SelectBaseStationTitle = null;
		Discover_Btn = null;
		USB_Tile = null;
		Connect_Btn = null;
	}

	// Check the presence of Select Base Station header title
	public boolean SelectBaseStationTitle_state() {
		return IsElementVisibleStatus(SelectBaseStationTitle);
	}

	// Click the Discover button
	public void click_DiscoverBtn() throws InterruptedException {
		clickOn(Discover_Btn);
		Thread.sleep(15000);
	}
	
	// Click the docking USB_Tile
	public void click_USBTile() throws InterruptedException {
		clickOn(USB_Tile);
		Thread.sleep(15000);
	}
	
	// Click the AVS tile based on the S/N user input
	public void click_AVSTile() throws InterruptedException {
		WebElement AVS_sn = driver.findElementByName("AVS SNo.-- 16020001");
		clickOn(AVS_sn);
		Thread.sleep(500);
	}
	
	// Click the Connect Button
	public MonitoringPage click_ConnectBtn() throws InterruptedException, IOException {
		clickOn(Connect_Btn);
		Thread.sleep(30000);
		return new MonitoringPage();
	}

}
