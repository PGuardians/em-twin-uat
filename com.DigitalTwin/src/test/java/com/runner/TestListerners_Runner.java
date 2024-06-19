package com.runner;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pom_manager.Pom_Manager;

public class TestListerners_Runner implements ITestListener {
	
	public ExtentReports extentReport;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("The test onStart- Test Begins from here");
		spark = new ExtentSparkReporter("reportPath");
		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);
		test = extentReport.createTest("Test");
	} 
	
	@Override
	public void onTestStart(ITestResult result) {
		//String reportPath =
		//String testName = result.getTestName();
//		String testName = result.getMethod().getMethodName();
//		System.out.println("The test has been started- Successfully----with TestName of "+ testName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("The test has been done- Successfully");
		test.log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		String methodName = result.getMethod().getMethodName();
//		System.out.println("The test has been failed- Error!"+ methodName);
		test.log(Status.FAIL, "Test failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		String methodName = result.getMethod().getMethodName();
//		System.out.println("The test has been skipped"+ methodName);
		test.log(Status.SKIP, "Test skiped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("The test has been failed with success percent");
		test.log(Status.FAIL, "Test Failed But With in Success Percentage");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
//		System.out.println("The test onFinish- Test Ends here");
	}

}
