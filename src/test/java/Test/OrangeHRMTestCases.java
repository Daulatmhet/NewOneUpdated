package Test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.Listeners.RetryFailedTests;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataproviderExcel;

public final class OrangeHRMTestCases extends BaseTest {
	
	private OrangeHRMTestCases()
	{}

	@Test(dataProvider = "getData",dataProviderClass = DataproviderExcel.class,retryAnalyzer =RetryFailedTests.class )
	public void loginLogoutTest(Map<String,String>data) throws Exception
	{

		String title =	new OrangeHRMLoginPage().enterusername(data.get("username")).enterPassword(data.get("password")).
				clickLogin().clickwelcome().clickLogout()
				.getTitle();

		Assertions.assertThat(title).
		isEqualTo("OrangeHRM");
	}

	@Test(dataProvider = "getData",dataProviderClass = DataproviderExcel.class )
	public void newTest(Map<String,String>data) throws Exception
	{
		String title =	new OrangeHRMLoginPage().enterusername(data.get("username")).enterPassword(data.get("password")).
				clickLogin().clickwelcome().clickLogout()
				.getTitle();

		Assertions.assertThat(title).
		isEqualTo("OrangeHRM");
	}
     
	
	@DataProvider(name = "LoginTestDataProvider" , parallel = true)
	public Object[][] getData()
	{
		return new Object[][]{

			{"Admin", "admin123"},
			//{"Admin" , "admin"}
		};
	}
	
	
	
	
	
}






