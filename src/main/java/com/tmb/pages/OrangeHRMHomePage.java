package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public  class OrangeHRMHomePage extends BasePage  {
	
	

	
  private final By link_welcome = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span");
  private final By link_logout = By.xpath("//a[text()='Logout']");
  
  
  
  public OrangeHRMHomePage clickwelcome() throws InterruptedException {
	 // Thread.sleep(1500);
	 // DriverManager.getDriver().findElement(link_welcome).click();
	  
	  click(link_welcome, WaitStrategy.PRESENCE);
	  return this;
  }
  
  
  public OrangeHRMLoginPage clickLogout() throws InterruptedException
  {
		
	//ssssssssssss  Thread.sleep(1000);
	  
	  
	//  DriverManager.getDriver().findElement(link_logout).click();
	  
	  click(link_logout, WaitStrategy.CLICKABLE);
	  
	   return new OrangeHRMLoginPage();
	   
  }
  
  
   
  

  
}




