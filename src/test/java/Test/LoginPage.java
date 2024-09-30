package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public class LoginPage extends BaseTest{

	
	@Test
	public void test1()
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		DriverManager.getDriver().getTitle();
		//Assert.assertTrue(Objects.nonNull());
		
		//Assert.assertTrue();
		 
	}
	
	
	
	
}


