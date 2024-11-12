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
		      try {
				ExtentLogger.pass(elementname+"is clicked",true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	}  
	
	protected void sendkeys(By by , String value , WaitStrategy waitstrategy, String elementname) 
	{ 
		
		WebElement element=	ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		  element.sendKeys(value);
		  try {
			ExtentLogger.pass(value+ "is entered sucessfully in"+ elementname , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
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
