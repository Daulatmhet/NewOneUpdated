package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DyanamicUtils;

public final class AmazonHamburgerMenuPage extends BasePage{
	
	
  
	private String linkcomputer = "//div[.='Mobiles, Computers']//parent::a";
	
	private String linkSubMenu = "//a[.='%s%']";
	
	
	
	public AmazonHamburgerMenuPage clickonComputers()
	{
		
		click(By.xpath(linkcomputer), WaitStrategy.CLICKABLE, "Mobiles and computers");
		return this;
	}

	public AmazonLaptopPage clickOnSubMenuItem(String menutext)
	{
		
		String newpath = DyanamicUtils.getXpath(linkSubMenu, menutext); 
		 click(By.xpath(newpath), WaitStrategy.CLICKABLE, menutext);
		 if(menutext.contains("Laptops"))
		 {
			 return new AmazonLaptopPage();
		 }
		return null;
		 
		
	}
	
	
	
	

}
