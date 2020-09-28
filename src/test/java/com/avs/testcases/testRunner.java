/**
 * @author manoj.ghadei
 *
 */

package com.avs.testcases;

import java.io.FileNotFoundException;


import org.testng.TestNG;

import com.avs.Listners.ExtentReporterNG;

public class testRunner {
	
	static TestNG testng;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException {		

	        
		ExtentReporterNG er = new ExtentReporterNG();

		testng = new TestNG();
		testng.setTestClasses(new Class[] {FirstUserCreation.class});

		testng.run();			
	}

}
