package Test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.pages.AmazonHomePage;

public class AmazonDemoTest extends BaseTest {
	
	
	private AmazonDemoTest() {}
	
	
	@Test
	public void amazonTest(Map<String , String>data) {
		String title = new AmazonHomePage().clickHamburger().clickOnSubMenuItem(data.get("").get
		
		Assertions.assertThat(title).isNotNull().isNotBlank();
		
		
	}
	
	
	
}

