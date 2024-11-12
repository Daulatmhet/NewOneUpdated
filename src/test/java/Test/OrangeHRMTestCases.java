package Test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;

public final class OrangeHRMTestCases extends BaseTest {
	
	
	private OrangeHRMTestCases()
	{}
	
	@Test(dataProvider = "getData")
	public void LoginLogoutTest(String username , String password) throws Exception
	{
		
		String title =	new OrangeHRMLoginPage().enterusername(username).enterPassword(password).
				clickLogin().clickwelcome().clickLogout()
				.getTitle();

			Assertions.assertThat(title).
			isEqualTo("OrangeHRM");
	}
	
	
	@DataProvider(parallel = true)
	public Object[][] getData()
	{
		return new Object[][]{
				
			{"Admin", "admin123"},
			{"Admin" , "admin"}
		};
	}
}
	

	



