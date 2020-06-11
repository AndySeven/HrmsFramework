package com.hrms.testbase;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;

public class Listener extends CommonMethods implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {				 // executes when @Test anot method starts
		ITestListener.super.onTestStart(result);
		test = report.createTest(result.getName());    // why we can access without BaseClass.report...  &  BaseClass.test Because CommonMethods
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		System.out.println("From Listener onTestSuccess: Test Success");
		//getScrShot("HRMlistener", result.getName());
		test.pass("Test Case Passed "+result.getName());
		try {
			test.addScreenCaptureFromPath(takeScreenshot("passed/"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		System.out.println("From Listener onTestFailure: Test Fails");
		//getScrShot("HRMlistener", result.getName());
		test.fail("Test Case Failed "+result.getName());
		try {
			test.addScreenCaptureFromPath(takeScreenshot("failed/"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {   				// Executes based on test from <xml> file
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}
	
}