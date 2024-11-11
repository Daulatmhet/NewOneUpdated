package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

import comtmb.Reports.ExtentLogger;
import comtmb.Reports.ExtentManager;
import comtmb.Reports.ExtentReport;

public  class OrangeHRMHomePage extends BasePage  {


	private final By link_welcome = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span");
	private final By link_logout = By.xpath("//a[text()='Logout']");



	public OrangeHRMHomePage clickwelcome() throws InterruptedException {
		
		click(link_welcome, WaitStrategy.PRESENCE, " clicked welcome");
		
		return this;
	}


	public OrangeHRMLoginPage clickLogout() throws InterruptedException
	{

		click(link_logout, WaitStrategy.CLICKABLE, "clicked Logout");
		
		return new OrangeHRMLoginPage();

	}






}




