package com.practice.extentReporting;

//import junit.framework.Assert;

import library.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC01_Login {

	ExtentReports report;
	ExtentTest test; 
	WebDriver driver;

	@Test
	public void verifyBNTitle(){
		report = new  ExtentReports("C:\\MyDevelopment\\EclipseWorkspaces\\githubprojects\\extentReporting\\report\\index.html");
		test=report.startTest("VerifyBNTitle");
		
		driver=new FirefoxDriver();

		driver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "Browser started ");
		driver.get("http://www.bn.com");
		test.log(LogStatus.INFO, "Application is up and running");
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Google"));
		test.log(LogStatus.PASS, "Title verified");
		/*try {
			Assert.assertTrue(title.contains("Google"));
			test.log(LogStatus.PASS, "Title verified");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Title verification", "Title Verification Fail");
		} 
		
		
		
		
		report.endTest(test);
		report.flush();
		driver.get("C:\\MyDevelopment\\EclipseWorkspaces\\githubprojects\\extentReporting\\report\\index.html");*/
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			String screenshot_path=Utility.captureScreenShot(driver, result.getName());
			String image= test.addScreenCapture(screenshot_path);
			test.log(LogStatus.FAIL, "Title verification", "Title Verification Fail");
		}

		report.endTest(test);
		report.flush();

		driver.get("C:\\MyDevelopment\\EclipseWorkspaces\\githubprojects\\extentReporting\\report\\index.html");

	}

}
