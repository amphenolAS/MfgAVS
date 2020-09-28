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

public class RWFileSelctionPage extends BaseClass {

	// Page element variable declaration definition
	WebElement AssetsName_Textfield = null;

	// Page element Initialize method
	private void initElements() {
		AssetsName_Textfield = driver.findElementByAccessibilityId("AssetsNameTextBlock");

	}

	// Constructor for initializing the page elements
	RWFileSelctionPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		AssetsName_Textfield = null;

	}
	// verify the presence of ExportToExcel Btn

	public boolean assetDetailTitle_Visible() {
		return IsElementVisibleStatus(AssetsName_Textfield);
	}

}
		
	
