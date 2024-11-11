package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

import comtmb.Reports.ExtentLogger;

public class BasePage {
	
	
	
	protected void click(By by , WaitStrategy waitstrategy, String elementname)
	{
		/*
		 * We want to make sure can only choose from list of predefined options
		 *  
		 */
		   WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		      element.click();
		      ExtentLogger.pass(elementname+"is clicked");
		  
	}  
	
	protected void sendkeys(By by , String value , WaitStrategy waitstrategy, String elementname) throws Exception
	{ 
		
		WebElement element=	ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		  element.sendKeys(value);
		  ExtentLogger.pass(value+ "is entered sucessfully in"+ elementname , true); 
		
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
