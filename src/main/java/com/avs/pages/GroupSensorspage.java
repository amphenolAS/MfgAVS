package com.avs.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avs.base.BaseClass;

public class GroupSensorspage extends BaseClass {
	
	// Define Setup page element variable declaration definition
	private WebElement GroupSensorspageName = null;
	
	
	private void initializeEelements() {
		GroupSensorspageName = driver.findElementByName("Group Sensors");
	
	}
	
	GroupSensorspage() throws IOException {
		super();
		initializeEelements();
	}
	
	// Check the presence of Group Sensors page
	public boolean GroupSensorspageName_state() {
		return IsElementVisibleStatus(GroupSensorspageName);
	}
	

}
