package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.enums.ConfigProperties;

import Iconstants.FramworkConstants;

public final class PropertyUtil {
	
	
	
	//If you passing 100 value and reading 100 data passing
	
	private PropertyUtil()
	{
		
		
	}
	
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	
	static {
		try {
		FileInputStream file = new FileInputStream(FramworkConstants.getConfigFilepath());
		property.load(file);
		
		
//		for(Object key : property.keySet())
//		{
//			CONFIGMAP.put(String.valueOf(key),String.valueOf(property.get(key)));
//		}
		
		
	for(Map.Entry<Object, Object>entry:property.entrySet())
		{
			CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
		}
		
	
	//trim remove trailing and leading spaces
		//If You know Lambda Expression
		// so you can go this approch
	//	property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		
	
	
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(IOException e){
			
		}
		
		
	}
	
//	public static String get( ConfigProperties key) throws Exception
//	{
//		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key)))
//		{
//			throw new Exception("Property name" + key + "is not found. Please check config.properties");
//		}
//		return CONFIGMAP.get(key.name().toLowerCase());
//		
//	}
//}
	

//Two method fill compartable use those code

	
	
	public static String get( ConfigProperties key) throws Exception
	{
		
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
		{
		  	throw new Exception("Property name" + key + "is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
		
		
	}
	

}
