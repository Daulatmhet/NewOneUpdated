package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

import comtmb.Reports.ExtentLogger;
import comtmb.Reports.ExtentManager;

public final class OrangeHRMLoginPage extends BasePage{

	
	
	public final By textbox_username = By.xpath("//input[@name='username']");
	public final By textbox_password = By.xpath("//input[@type='password']");
	
	private final By button_login = By.xpath("//button[@type='submit']");
	
	
	 
	public OrangeHRMLoginPage enterusername(String username) throws Exception {
		
		sendkeys(textbox_username, username , WaitStrategy.PRESENCE, "Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) throws Exception
	{
		
		sendkeys(textbox_password, password ,WaitStrategy.PRESENCE,"Password" );
		return this;
		
	}
	
	
	public OrangeHRMHomePage clickLogin()
	{
		click(button_login, WaitStrategy.PRESENCE,"Login Button");
		return new OrangeHRMHomePage();
		
	}
	
	
	public String getTitle()
	{
		return getPageTitle();
		
	}
	}





