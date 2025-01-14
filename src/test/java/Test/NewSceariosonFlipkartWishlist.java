package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewSceariosonFlipkartWishlist {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//div[@class='YBLJE4'])[5]")).click();




		WebElement Men = driver.findElement(By.xpath("(//span[@class='TSD49J'])[3]"));
		Actions a = new Actions(driver)   ;
		a.moveToElement(Men).perform();

		driver.findElement(By.name("q")).sendKeys("iphone 15");
		


	}
	
	

}

