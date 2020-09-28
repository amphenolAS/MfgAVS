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

public class VRTLoggerHubPage extends BaseClass {
	
	private void initElements() {
	}

	VRTLoggerHubPage() throws IOException {
		super();
		initElements();

	}

	// Click IRTD
	/*
	 * public EquipmentIRTDDetailspage ClickIrtdSerialNo() throws
	 * InterruptedException { clickOn(IrtdSerial); return EquipmentIRTDDetailspage;
	 */

	// Click/Select the VRT serial number in EQP HubPage
	
	public VRTLoggersDetailspage Click_VRTSerialNo(String SN) throws InterruptedException, IOException {

		List<WebElement> VRTList = driver.findElementByName("VRT.DataObjects.DataContracts.EquipmentMasterData")
				.findElements(By.className("GridViewItem"));

		// Loop for the different serial number created
		for (int i = 0; i < VRTList.size(); i++) {
			// System.out.println("serial number : " + IrtdList.get(i).getText());

			List<WebElement> VRTTileInfoList = VRTList.get(i).findElements(By.className("TextBlock"));
			// System.out.println(" VRT tile info count: " + VRTTileInfoList.size());

			// Fetch all the contents of the Asset tile
			for (int j = 0; j < VRTTileInfoList.size(); j++) {
				// System.out.println("VRTTileInfo: "+VRTTileInfoList.get(j).getText());

				if (VRTTileInfoList.get(j).getText().contains(SN)) {
					clickOn(VRTTileInfoList.get(j));
					Thread.sleep(2000);
					break;
				}
			}
		}
		return new VRTLoggersDetailspage();
	
	}
}
