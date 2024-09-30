package com.tmb.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

import Iconstants.FramworkConstants;

public class ExplicitWaitFactory {
	
	
	public static WebElement performExplicitWait(WaitStrategy waitstrategy , By by)
	{
		WebElement element = null;
		if(waitstrategy == WaitStrategy.CLICKABLE)
		{
			
			 new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
				.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitstrategy== WaitStrategy.PRESENCE)
		{
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if (waitstrategy== WaitStrategy.VISIBLE)
		{
		  element =	 new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		
		else if(waitstrategy== WaitStrategy.NONE)
		{
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
		
	}

	
	
	

}