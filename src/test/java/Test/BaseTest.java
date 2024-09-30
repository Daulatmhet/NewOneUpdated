package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTest {
	
	
	
	
	protected BaseTest()
	{
		
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		
		Driver.initDriver();
	}
	
	
	@AfterMethod
	public void teardown() throws Exception
	{
		Driver.quitDriver();
		
	}
	
	

}
