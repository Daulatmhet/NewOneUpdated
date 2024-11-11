package Test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.driver.Driver;

import comtmb.Reports.ExtentReport;

public class BaseTest {
	protected BaseTest()
	{
		
	}
	
	
	@BeforeMethod
	public void setup(Method m) throws Exception
	{
		ExtentReport.createTest(m.getName());
		Driver.initDriver();
	}
	
	@AfterMethod
	public void teardown() throws Exception
	{
		Driver.quitDriver();
		
	}

}
