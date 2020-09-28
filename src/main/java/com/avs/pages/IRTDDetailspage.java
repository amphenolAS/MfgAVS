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
import com.avs.pages.IRTDHubPage;
import com.avs.utility.TestUtilities;

public class IRTDDetailspage extends BaseClass {

	IRTDHubPage IRTDHubPage;
	TestUtilities tu = new TestUtilities();
	// EquipmentHubPage Element definition
	WebElement IRTDHeader = null;
	WebElement DeleteBtn = null;		
	WebElement Eqpname = null;
	WebElement ClkSaveBtn = null;

	// Button1
	private void initElements() {
		IRTDHeader = driver.findElementByAccessibilityId("EquipmentsHeaderTextBlock");
		DeleteBtn = driver.findElementByAccessibilityId("DeleteEquipmentsButton");
		Eqpname = driver.findElementByAccessibilityId("AssetNameTextBox");
		ClkSaveBtn = driver.findElementByAccessibilityId("SaveButton");
	}

	IRTDDetailspage() throws IOException {
		super();
		initElements();

	}
	
	// Release memory
	public void resetWebElements() {
		IRTDHeader = null;
		DeleteBtn = null;		
		Eqpname = null;
		ClkSaveBtn = null;
	}

	// IRTD Details page Header is presence...
	public boolean IRTD_DetailsHeaderPresence() {
		return IsElementVisibleStatus(IRTDHeader);
	}

	//Delete Equipment
	public void clickDeleteEquipmentIcon() {
		clickOn(DeleteBtn);
	}

	// Delete Pop up Window is presence...
	public boolean IRTD_DeletePopupWindow() {
		WebElement DeletePopupWindow = driver.findElementByAccessibilityId("Popup Window");
		return IsElementVisibleStatus(DeletePopupWindow);
	}

	// clickYesBtn
	public void ClickYesBtn() {
		if (!IRTD_DeletePopupWindow()) {
			System.out.println("IRTD delete popup didnt display");
		} else {
			WebElement YesBtn = driver.findElementByAccessibilityId("Button1");
			clickOn(YesBtn);
		}
	}
	
	// Navigate to IRTD Hub page after Deleting IRTD in IRTDDetails page
	public IRTDHubPage delete_IRTD(String UID, String PW) throws InterruptedException, IOException {
		clickDeleteEquipmentIcon();
		WebElement YesBtn = driver.findElementByAccessibilityId("Button1");
		clickOn(YesBtn);
		UserLoginPopup(UID, PW);		
		return new IRTDHubPage();
	}

	// Edit Equipment Name
	public void enter_Equipmentname(String equipNm) {		
		ClearText(Eqpname);
		enterText(Eqpname, equipNm);
	}

	// Click on save button after edited
	public void ClickSaveButton() throws InterruptedException {
		clickOn(ClkSaveBtn);
		Thread.sleep(1000);
	}

	//Edit Functionality for IRTD Equipments				
	public void enter_IRTDEquipName(String an) throws InterruptedException {
		enter_Equipmentname(an);
		ClickSaveButton();
	}

	//Fetch the alert message when Supervisor not have the privilege to edit the equipments
	/*public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}*/
	
}
