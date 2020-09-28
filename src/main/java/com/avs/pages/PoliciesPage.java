/**
 * @author ruchika.behura
 *
 */

package com.avs.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.avs.base.BaseClass;

public class PoliciesPage extends BaseClass{
	//Page element variable declaration definition
	WebElement PoliciesHeaderText = null;
	WebElement pwdcombobox = null;
	WebElement SaveBtn = null;
	WebElement UserManagement_TAB = null;


		
	//Page element Initialize method
	private void initElements()
	{
		PoliciesHeaderText = driver.findElementByAccessibilityId("PoliciesButton");
		pwdcombobox = driver.findElementByAccessibilityId("RequireMinLengthPasswordComboBox");
		SaveBtn = driver.findElementByName("Save");
		UserManagement_TAB = driver.findElementByAccessibilityId("UserManagementButton");
		
		
		

	}
	
	//Constructor for initializing the page elements
	PoliciesPage() throws IOException
	{
		super();
		initElements();
	}
	
	//Release memory
	public void resetWebElements()
	{
		PoliciesHeaderText = null;
		
	}
	
	/*----------------------
	Methods of Policies Page
	------------------------*/
	// Check if Policies page is displayed
	public boolean IsPolicies_screenDisplayed() {
		return IsElementEnabledStatus(PoliciesHeaderText);
	}
	
   // Select 7 chars for minimum length pwd
	public void PWDLength_Box() throws InterruptedException {
		//System.out.println(Utype);
		clickOn(pwdcombobox);	
		WebElement option2 = driver.findElementByName("7 Characters");
		clickOn(option2);
		ClickSaveButton();
}
	
	
	// Click Save button
	public void ClickSaveButton() throws InterruptedException {
		clickOn(SaveBtn);
	}
	
	//Click on um tab
	public UserManagementPage ClickUserManagement_TAB() throws InterruptedException, IOException {
		clickOn(UserManagement_TAB);
		return new UserManagementPage();
	}
	
}
