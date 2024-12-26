package Test;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTest {
	protected BaseTest()
	{
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void setup(Object[]data) throws Exception
	{
		Map<String, String>map = (Map<String , String>)data[0];
		Driver.initDriver(map.get("browser"));
		
	}
	
	@AfterMethod
	public void teardown() throws Exception
	{
		Driver.quitDriver();
		
	}

}


