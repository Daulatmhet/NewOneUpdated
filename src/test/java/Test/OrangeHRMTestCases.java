package Test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;

public final class OrangeHRMTestCases extends BaseTest {
	
	
	private OrangeHRMTestCases()
	{
		
	}
	
	
	

	@Test
	public void LoginLogoutTest() throws InterruptedException
	{
		
		String title =	new OrangeHRMLoginPage().enterusername("Admin").enterPassword("admin123").
				clickLogin().clickwelcome().clickLogout()
				.getTitle();

			Assertions.assertThat(title).
			isEqualTo("OrangeHRM");
			
			
		
			
	/*	Thread.sleep(1500);
		
		OrangeHRMHomePage home = new OrangeHRMHomePage();
		home.clickwelcome().clickLogout();
		
		
		
		Thread.sleep(1000);*/
		
		
		
	}

}

