 package com.HRM.Listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import comtmb.Reports.ExtentLogger;
import comtmb.Reports.ExtentReport;
public class ListenerClass implements ITestListener , ISuiteListener
{
	@Override
	public void onStart(ISuite suite)
	{
		
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite)
	{
		
		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentReport.createTest(result.getMethod().getDescription());
		
	}
	
	@Override
	public void onTestSuccess (ITestResult result)
	{
		ExtentReport.createTest(result.getMethod().getMethodName()+ "is passed" );
		
	}
	
	@Override
	public void onTestFailure (ITestResult result)
	{
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public void onTestSkipped (ITestResult result)
	{
		ExtentReport.createTest(result.getMethod().getMethodName()+ "is Skipped");
		
	}
	
	
	
	
	
	

	
	
	
	
 
}
