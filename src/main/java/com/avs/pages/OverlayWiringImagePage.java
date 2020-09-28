package com.avs.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;

public class OverlayWiringImagePage extends BaseClass{
	
	// Calculation page element variable declaration definition
	WebElement OverlayWiringImage_Title = null;
	WebElement Print_Button = null;
	WebElement OverlayImageClose_button = null;
	WebElement Group_Name = null;
	WebElement GroupWiringReport_Button = null;
	WebElement CreateFullWiringReport_Button = null;

	
	private void initializeEelements() {
		OverlayWiringImage_Title = driver.findElementByName("Overlay Wiring Image");
		Print_Button = driver.findElementByAccessibilityId("PrintButton");
		OverlayImageClose_button = driver.findElementByAccessibilityId("OverlayImageClosebutton");
		Group_Name = driver.findElementByAccessibilityId("tblName");
		GroupWiringReport_Button = driver.findElementByAccessibilityId("GroupWiringReportButton");
		CreateFullWiringReport_Button = driver.findElementByAccessibilityId("CreateFullWiringReportButton");

		
		
	}
	
	OverlayWiringImagePage() throws IOException {
		super();
		initializeEelements();
	}
	
	// Release memory
	public void resetWebElements() {
		OverlayWiringImage_Title = null;
		
	}
	
 // Check the presence of Select Base Station page
	 public boolean IsOverlayWiringPageTitle_state() {
		return IsElementVisibleStatus(OverlayWiringImage_Title);
	}
	 
//Print_Button_Visible
	 public boolean PrintButton_State() {
			return IsElementVisibleStatus(Print_Button);
		}
	 
 //Close_Button_Visible
		 public boolean Close_button_State() {
				return IsElementVisibleStatus(OverlayImageClose_button);
			}
		 
  //Group_Visible_Visible
		 public boolean Group_Visible() {
				return IsElementVisibleStatus(Group_Name);
			}
		 
 //Click on PrintIcon
		 public void Click_PrintIcon()
		 {
			 clickOn(Print_Button);
		 }
		 
	//GroupWiring_Report_Visible
		 public boolean GroupWiring_Report_State()
		 {
			 return IsElementVisibleStatus(GroupWiringReport_Button);
		 } 

	//All_GroupOverlayReport_State
		 public boolean All_GroupOverlayReport_State()
		 {
			 return IsElementVisibleStatus(CreateFullWiringReport_Button);
		 } 
		 
	//GroupOverlayRprtGenerate_Popupvisible
		 
		 public boolean GroupOverlayRprtGenerate_Popupvisible() throws InterruptedException
		 
		 {
			 Click_PrintIcon();
			 clickOn(GroupWiringReport_Button);
			 driver.switchTo().activeElement();
			 Thread.sleep(2000); 
		WebElement roupOverlayRprtGenerate_Popup = driver.findElementByAccessibilityId("HeadText");
		return IsElementVisibleStatus(roupOverlayRprtGenerate_Popup);
             
		 }
		 
//All_GroupOverlayReportGenerate_Popupvisible
		 
		 public boolean All_GroupOverlayReportGenerate_Popupvisible() throws InterruptedException
		 
		 {
			 Click_PrintIcon();
			 clickOn(CreateFullWiringReport_Button);
			 driver.switchTo().activeElement();
			 Thread.sleep(2000); 
		     WebElement All_GroupOverlayReport = driver.findElementByAccessibilityId("HeadText");
		     return IsElementVisibleStatus(All_GroupOverlayReport);     
		 }
		 
}
