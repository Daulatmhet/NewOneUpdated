package Test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.HRM.Listeners.RetryFailedTests;
import com.annotations.FramworkAnnotation;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AmazonHomePage;
import com.tmb.utils.DataproviderExcel;

import comtmb.Reports.ExtentManager;


public class AmazonDemoTest extends BaseTest {
	 
	
	
	private AmazonDemoTest() {}
	
	@FramworkAnnotation(author = {"Daulat", "Akshay"}, category = { CategoryType.REGRESSSION,CategoryType.MINIREGRESSION })
	@Test
	public void amazonTest(Map<String , String>data) {
		
	ExtentManager.getExtentTest().assignAuthor("Daulat").assignCategory("Smoke").assignCategory("Regression");
		
	 String title= new AmazonHomePage().clickHamburger().clickonComputers()
			 .clickOnSubMenuItem(data.get("menutext")).getTitle();
	 Assertions.assertThat(title).isNotNull().isNotBlank();
		
	}
	
	
}











