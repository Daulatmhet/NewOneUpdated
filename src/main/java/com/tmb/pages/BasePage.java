package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

import Iconstants.FramworkConstants;

public class BasePage {
	
	
	
	protected void click(By by , String waitstrategy)
	{
		/*
		 * We want to make sure can only choose from list of predefined options
		 *  
		 */
		if(waitstrategy.equalsIgnoreCase("clickable"))
		{
			explicitWaitForElementToBeClickable(by);
		}
		else if (waitstrategy.equalsIgnoreCase("present"))
		{
			explicitWaitForElementToBePresent(by);
		}
		
		
		DriverManager.getDriver().findElement(by).click();
		
	}
	
	protected void sendkeys(By by , String value , String waitstrategy)
	{
		
		if(waitstrategy.equalsIgnoreCase("clickable"))
		{
			explicitWaitForElementToBeClickable(by);
		}
		else if (waitstrategy.equalsIgnoreCase("present"))
		{
			explicitWaitForElementToBePresent(by);
		}
		
		DriverManager.getDriver().findElement(by).sendKeys(value);
		
		
	}
	
	protected String getPageTitle()
	{ 
		return DriverManager.getDriver().getTitle();
	}
	
	private void explicitWaitForElementToBeClickable(By by)
	{
		 new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
				.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	
	private void explicitWaitForElementToBePresent(By by)
	{
		
		 new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	 
	
	
	

}
