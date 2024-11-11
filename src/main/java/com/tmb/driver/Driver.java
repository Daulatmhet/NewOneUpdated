package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver 
{
	
	private Driver(){
		
		
	}
	
	

	private static WebDriver driver;
	
	
	public static void initDriver() throws Exception
	{
		if(Objects.isNull(driver))
		{
		WebDriverManager.chromedriver().setup();
		
		
	    DriverManager.	setDriver(new ChromeDriver());
	    DriverManager.getDriver().get(PropertyUtil.get(ConfigProperties.URL)); 
	    
	    
		
	}
	}
	
	
	
	
	
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
	//DriverManager.getDriver().quit();
	DriverManager.unload();
		
		
	}
	}
	
	
}

