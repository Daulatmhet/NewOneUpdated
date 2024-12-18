package com.tmb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.driver.DriverManager;

public class AmazonHomePage extends BasePage{
	
	
	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	private WebElement linkHamburger;
	
	
	
	public AmazonHomePage()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public AmazonHamburgerMenuPage clickHamburger()
	{
		linkHamburger.click();
		return new AmazonHamburgerMenuPage();
	}

}


