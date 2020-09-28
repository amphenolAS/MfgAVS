/**
 * @author ruchika.behura
 *
 */

package com.avs.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.avs.base.BaseClass;
import com.avs.pages.EquipmentPage;
import com.avs.pages.IRTDHubPage;
import com.avs.utility.TestUtilities;

public class VRTLoggersDetailspage extends BaseClass {

	IRTDHubPage IRTDHubPage;
	TestUtilities tu = new TestUtilities();

	// EquipmentHubPage Element definition
	WebElement Reports_Button = null;
	WebElement Documents_Tile = null;
	WebElement Copytodrive = null;


	// Initializing the elements
	private void initElements() {
		Reports_Button = driver.findElementByAccessibilityId("ReportsButton");
		Documents_Tile = driver.findElementByAccessibilityId("DocumentsButton");
		Copytodrive = driver.findElementByAccessibilityId("CopyDocumentToDrive");
		
	}

	VRTLoggersDetailspage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		Reports_Button = null;
		Documents_Tile = null;
		Copytodrive = null;

	}

	/*********************
	 * //Page related Method definitions
	 *********************/

	public void Click_VRTVerification_studyFile(String SN) throws InterruptedException, IOException {

		List<WebElement> VRTVerificationList = driver
				.findElementByName("VRT.DataModule.Asset.ViewModels.ActivityItemViewModel")
				.findElements(By.className("ListViewItem"));

		// Loop for the different serial number created
		for (int i = 0; i < VRTVerificationList.size(); i++) {
			// System.out.println("serial number : " + IrtdList.get(i).getText());

			List<WebElement> VRT_VerificationInfoList = VRTVerificationList.get(i)
					.findElements(By.className("TextBlock"));

			for (int j = 0; j < VRT_VerificationInfoList.size(); j++) {
				// System.out.println("AssetTileInfo: "+IRTDTileInfoList.get(j).getText());

				if (VRT_VerificationInfoList.get(j).getText().contains(SN)) {
					clickOn(VRT_VerificationInfoList.get(j));
					Thread.sleep(1000);
					break;
				}
			}
		}
	}

	// Click on Delete Icon against any study/reports files
	public void Click_DeleteBtn() throws InterruptedException {	
		WebElement DeleteBtn = driver.findElementByAccessibilityId("DeleteButton");
		clickOn(DeleteBtn);
		Thread.sleep(1000);
	}

	// Click on reports tile
	public void Click_reporttile() {
		clickOn(Reports_Button);
	}
	
	// Click on Documents tile
	public void Click_Documentstile() {
		clickOn(Documents_Tile);
	}

	// UploadDocumentsButton
	public void Upload_Documents(String filename) throws AWTException, IOException, InterruptedException {

		WebElement UploadDocumentsButton = driver.findElementByAccessibilityId("UploadDocumentsButton");
		clickOn(UploadDocumentsButton);
		Thread.sleep(2000);
		// TestUtilities tu = new TestUtilities();
		tu.uploadDoc("uploadnote.txt");

	}

	// Click the Copy to drive button
	public void click_CopyToDrive() throws InterruptedException {
		clickOn(Copytodrive);
		Thread.sleep(2000);
	}

	//Select any folder present in the resource folder TestData for copying any eqp. files
	public void selectFolder_CopyToDrive(String folderName) throws AWTException, IOException, InterruptedException {
		click_CopyToDrive();				
		//Select any folder present in the resource folder TestData
		tu.selectFolder(folderName);

	}

	// Modify / Enter EquipmentName
	public void Enter_EquipmentName(String EN) {
		WebElement EqpName = driver.findElementByAccessibilityId("AssetNameTextBox");
		clickOn(EqpName);
		ClearText(EqpName);
		enterText(EqpName, EN);
	}

	// Save button

	public void Click_Save() {
		WebElement Save_Button = driver.findElementByAccessibilityId("SaveButton");
		clickOn(Save_Button);
	}

	// Click on yes button for delete confirmation
	public void click_Alrt_YesBtn() {
		WebElement alrtMeg_YesBtn = driver.findElementByAccessibilityId("Button1");
		clickOn(alrtMeg_YesBtn);
	}
}
