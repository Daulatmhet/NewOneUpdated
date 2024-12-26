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

public class FlipPage {  // gptt provided

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Close the login popup if it appears
      

        // Search for the given product
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mivi DuoPods D4 TWS,Rich Bass,50H Playtime, AI ENC, Low Latency, 13mm,5.3 BT");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Click on the first product
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class='wjcEIp'])[1]"));
        firstProduct.click();

        // Switch to child window and get the product price
        switchToChildWindow(driver);

        WebElement priceElement = driver.findElement(By.xpath("(//div[@class='Nx9bqj CxhGGd'])[1]"));
        String productPrice = priceElement.getText();
        System.out.println("Product price from product details page: " + productPrice);

        // Add the product to the cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")));
        addToCartButton.click();

        // Wait for the cart to update
        Thread.sleep(1500); // Ideally, use WebDriverWait here

        // Navigate back to the product page
     //   driver.navigate().back();  // Not use full method

        // Switch back to the parent window
        switchToParentWindow(driver);

        // Go to the cart page
        WebElement cartButton = driver.findElement(By.xpath("//span[.='Cart']"));
        cartButton.click();

        // Wait for cart to load and get the price
        WebElement cartPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[.=' ₹799'])[1]")));
        String cartPrice = cartPriceElement.getText();
        System.out.println("Cart price: " + cartPrice);

        // Compare prices
        if (productPrice.equals(cartPrice)) {
            System.out.println("Test Passed: The Price matched");
        } else {
            System.out.println("Test Failed: The price did not match");
        }

        // Close the driver
       // driver.quit();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void switchToChildWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        System.out.println("Switched to the child window: " + childWindow);
    }

    public static void switchToParentWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to the parent window: " + parentWindow);
    }
}
