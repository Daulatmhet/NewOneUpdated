package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

public class BasePage {
	
	
	
	protected void click(By by , WaitStrategy waitstrategy)
	{
		/*
		 * We want to make sure can only choose from list of predefined options
		 *  
		 */
		   WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		      element.click();
		
	} 
	
	
	protected void sendkeys(By by , String value , WaitStrategy waitstrategy)
	{
		
		WebElement element=	ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		  element.sendKeys(value);
		
	}
	
	
	
	protected String getPageTitle()
	{ 
		return DriverManager.getDriver().getTitle();
	}
	
	private void explicitWaitForElementToBeClickable(By by)
	{
		
	}
	
	
	private void explicitWaitForElementToBePresent(By by)
	{
		
		
	}
	
	
	 
	
	
	

}
