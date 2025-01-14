package Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkartpage {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//Search for the Given Product
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mivi DuoPods D4 TWS,Rich Bass,50H Playtime, AI ENC, Low Latency, 13mm,5.3 BT");
		// click on search btn
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// click on frist product     
		WebElement frist = driver.findElement(By.xpath("(//a[@class='wjcEIp'])[1]"));

		frist.click();

		// click on go to cart page
		switchToChildWindow(driver);
		WebElement se=  driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']"));
		scrollToElement(driver, se);
		String productpage = driver.findElement(By.xpath("(//div[@class='Nx9bqj CxhGGd'])[1]")).getText();
		System.out.println( "product amount displayed in product details page"+productpage);

		se.click();
		// 4. Get the price from the product detail page

		Thread.sleep(1500);		
		driver.navigate().back();

		// click on cart button

		Thread.sleep(1500);
		WebElement cartbtn = driver.findElement(By.xpath("//span[.='Cart']"));

		cartbtn.click();
		Actions actions = new Actions(driver);
		actions.perform();
		// actions.click(cartbtn);
		Thread.sleep(1500);
		String cartpage = driver.findElement(By.xpath("(//span[.=' ₹799'])[1]")).getText();

		System.out.println("from cart page amount"+cartpage);



		if(productpage.equals(cartpage))
		{
			System.out.println("Test Passed: The Price matched");
		}
		else {
			System.out.println("Test Failed : The price Not Matched");
		} 

           


	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll the page to bring the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void switchToChildWindow(WebDriver driver) {
		// Get all window handles (parent and child windows)
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		// Switch to the second window (which will be the child window)
		String parentWindow = iterator.next();  // The parent window
		String childWindow = iterator.next();   // The child window (newly opened tab)

		// Switch to the child window
		driver.switchTo().window(childWindow);
		System.out.println("Switched to the child window: " + childWindow);
	}

	// Method to switch back to the parent window
	public static void switchToParentWindow(WebDriver driver) {
		// Get all window handles and switch back to the parent window
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();  // The parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Switched back to the parent window: " + parentWindow);

		
	}
}








