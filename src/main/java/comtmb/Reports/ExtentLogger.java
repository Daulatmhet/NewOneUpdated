package comtmb.Reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtil;

public class ExtentLogger {
	
	
	private ExtentLogger() {}
	
	
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
		
	}
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
		
	}
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
		
	}
   
	public static void pass(String message , boolean isScreenshotNeeded) throws Exception
	{
		if(PropertyUtil.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
		{
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
			
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message , boolean isScreenshotNeeded) throws Exception
	{
		if(PropertyUtil.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
		{
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
			
		}
		else {
			fail(message);
		}
	}
	
	public static void skip(String message , boolean isScreenshotNeeded) throws Exception
	{
		if(PropertyUtil.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
		{
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
			
		}
		else {
			skip(message);
		}
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	
	
	

}
