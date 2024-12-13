package com.tmb.utils;

public class DyanamicUtils {
	
	
	private DyanamicUtils() {}
	
	
	public static String getXpath(String xpath , String value)
	{
		return xpath.replace("%replaceable%", value);
	}
	
	

}
