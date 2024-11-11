package comtmb.Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Iconstants.FramworkConstants;

public final class ExtentReport {
	
	
	private ExtentReport()
	{}
	 
	private static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initReports() throws Exception {
		
		if(Objects.isNull(extent))
		 extent = new ExtentReports();
		 ExtentSparkReporter spark = new ExtentSparkReporter(FramworkConstants.getExtentreportpath());
		 extent.attachReporter(spark);
		 spark.config().setTheme(Theme.STANDARD);
		 spark.config().setDocumentTitle("TMB Report");
		 spark.config().setReportName("Youtube Training");
	}

	
	public static void flushReports() throws IOException
	{
		if(Objects.nonNull(extent))
		{
			
		extent.flush();
		}
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
	
	public static void createTest(String testcasename)
	{
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
	
	

}