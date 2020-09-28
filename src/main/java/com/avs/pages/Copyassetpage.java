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

public class Copyassetpage extends BaseClass {

	// Page element variable declaration definition
	WebElement NewAssetName_Field = null;
	WebElement NewAssetID_Field = null;
	WebElement CopyAsset_btn = null;
	WebElement Copyassetpage_Title = null;


	// Page element Initialize method
	private void initElements() {
		NewAssetName_Field = driver.findElementByAccessibilityId("txtAssetName");	
		NewAssetID_Field = driver.findElementByAccessibilityId("txtAMachaineID");	
		CopyAsset_btn = driver.findElementByAccessibilityId("CopyAssetButton");
		Copyassetpage_Title = driver.findElementByAccessibilityId("AssetsNameTextBlock");

	}

	// Constructor for initializing the page elements
	Copyassetpage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		NewAssetName_Field = null;
		NewAssetID_Field = null;
	}
	
	// Check the presence of Copy Asset Page  tile
	public boolean IsCopyAssetPageTitle_presence() {
		return IsElementVisibleStatus(Copyassetpage_Title);
	}

	
	//Enter New AssetName Field
	public void Enter_NewAssetNameField(String AN)
	{
		ClearText(NewAssetName_Field);
		clickOn(NewAssetName_Field);
		enterText(NewAssetName_Field,AN);	
	}
	public void Enter_NewAssetIDField(String AID)
	{
		ClearText(NewAssetID_Field);
		clickOn(NewAssetID_Field);
		enterText(NewAssetID_Field,AID);	
	}
	
	//Click on copy button
	public void click_copy_Btn() {
		clickOn(CopyAsset_btn);
	}

 //Click on Back button
		public void clickBack_Button() {
			WebElement Back_Button = driver.findElementByAccessibilityId("BackButton");	

			clickOn(Back_Button);
		}
 // click on yes btn 		
		public assetDetailsPage  Yes_alert() throws IOException {
			WebElement YesAlert_btn = driver.findElementByName("Yes");
			clickOn(YesAlert_btn);
			return new assetDetailsPage();
		}		
		
}
