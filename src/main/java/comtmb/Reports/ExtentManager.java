package comtmb.Reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {}

//	private static WebDriver driver;
	
	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
	
	 static ExtentTest getExtentTest() // defalut  ..> It can be only accessed witin 
	{
		return exTest.get();
	}
	
	 static void setExtentTest(ExtentTest test)
	{
		exTest.set(test);
	}
	
	 static void unload()
	{
		exTest.remove(); 
	}

}
