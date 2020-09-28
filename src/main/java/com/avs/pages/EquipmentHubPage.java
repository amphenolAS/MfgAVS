/**
 * @author ruchika.behura
 *
 */

package com.avs.pages;

import java.awt.AWTException;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;
import com.avs.pages.EquipmentPage;

public class EquipmentHubPage extends BaseClass {
	// IRTDHubPage IRTDHubPage;
	// EquipmentHubPage Element definition
	WebElement AddButton = null;
	WebElement VRTLogger = null;

	private void initElements() {
		AddButton = driver.findElementByAccessibilityId("AddEquipmentsButton");
		VRTLogger = driver.findElementByAccessibilityId("TitleTextBlock1");
		
	}

	EquipmentHubPage() throws IOException {
		super();
		initElements();

	}

	// Click AddButton
	public EquipmentPage ClickAddButton() throws InterruptedException, IOException {
		clickOn(AddButton);
		//Thread.sleep(1000);
		return new EquipmentPage();
	}

	// IRTD
	// Click on IRTD List box of Equipment page
	public IRTDHubPage click_IRTDTile() throws IOException {
		WebElement irtdbox = driver.findElementByName("IRTD");
		clickOn(irtdbox);
		return new IRTDHubPage();
	}
		// 
		// Click on VRT List box of Equipment page
		public VRTLoggerHubPage Click_VRTLogger_listbox() throws IOException {
			clickOn(VRTLogger);
			return new VRTLoggerHubPage();
	}

	// Click AddButton to get Alert message when supervisor does not have default
	// privilege
	public void Alert_ClickAddBtn() throws InterruptedException {
		clickOn(AddButton);
		Thread.sleep(1000);
	}

	// Alert message for non default privilege of supervisor
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}

	// Click on back button
	public MainHubPage ClickBackBtn() throws IOException {
		WebElement backBtn = driver.findElementByAccessibilityId("ArrowGlyph");
		clickOn(backBtn);
		return new MainHubPage();
	}
	//click Initiate Verification Tab
		public void  ClickInitiateVerification() throws IOException {
			WebElement InitiateVerificationTab = driver.findElementByAccessibilityId("SaveButton1");
			clickOn(InitiateVerificationTab);
		}
			

}
