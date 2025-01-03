package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver 
{

	private Driver(){
	}

	private static WebDriver driver;


	public static void initDriver(String browser) throws Exception
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equalsIgnoreCase("Firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			
			}
				DriverManager.getDriver().get(PropertyUtil.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();

		}
	}
}

