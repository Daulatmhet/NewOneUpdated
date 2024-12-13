package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DyanamicUtils;

public final class AmazonHamburgerMenuPage extends BasePage{
	
	

	
	private String linkSubMenu = "//a[text()='%replaceable%']";
	
	
	
	
	public AmazonLaptopPage clickOnSubMenuItem(String menutext)
	{
		
		String newpath = DyanamicUtils.getXpath(linkSubMenu, menutext); 
		 click(By.xpath(newpath), WaitStrategy.CLICKABLE, menutext);
		 if(menutext.contains("Laptop"))
		 {
			 return new AmazonLaptopPage();
		 }
		return null;
		 
		
		 
	}
	
	
	

}
