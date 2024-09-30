package Test;


	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest {

    private WebDriver driver;
    private String downloadFilepath = "path/to/download/directory";  // Set your download directory
    private String fileName = "testfile.txt";  // The name of the file to be downloaded

    @BeforeClass
    public void setUp() {
        // Set path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Set Chrome preferences for file download
        ChromeOptions options = new ChromeOptions();
        options.addArguments("download.default_directory=" + downloadFilepath);

        // Initialize the WebDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFileDownload() throws InterruptedException {
        // Navigate to the page that triggers the file download
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Trigger the file download (adjust the locator to your needs)
        driver.findElement(By.id("downloadButton")).click();

        // Wait for the file to download (could be replaced with WebDriver wait)
        Thread.sleep(5000);  // Adjust this based on the expected download time

        // Verify if the file is downloaded
        File downloadedFile = new File(downloadFilepath + File.separator + fileName);
        Assert.assertTrue(downloadedFile.exists(), "File not found!");

        // Optionally, you can add more checks for file properties or content here
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}



	