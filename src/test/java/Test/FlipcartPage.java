package Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartPage {


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("Mivi DuoPods D4 TWS,Rich Bass,50H Playtime, AI ENC, Low Latency, 13mm,5.3 BT");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement frist = driver.findElement(By.xpath("(//a[@class='wjcEIp'])[1]"));

		frist.click();

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);

		WebElement productdetailsprice=	driver.findElement(By.xpath("(//div[.='₹799'])[1]"));
		String     productprice =   	productdetailsprice.getText();
		System.out.println("ProductPriceIs" +productprice );

		// click on Add to Cart button
		WebElement scroll= driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']"));
		scroll.click();

		driver.switchTo().window(parentwindow);

		// click on cart 

		WebElement clickoncart = driver.findElement(By.xpath("//span[.='Cart']"));
		clickoncart.click();

		WebElement cartPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[.=' ₹799'])[1]")));
		String cartPrice = cartPriceElement.getText();
		System.out.println("Cart price: " + cartPrice);

		if(productprice.equals(cartPrice))
		{
			System.out.println("Test Passed : The Price Matched");
		}

		else
		{
			System.out.println("The Price should not matched");
		}

		//		JavascriptExecutor js = (JavascriptExecutor)driver;
		//		js.executeScript("arguments[0].scrollIntoView(true)" ,scroll);






		driver.quit();








	}

}
