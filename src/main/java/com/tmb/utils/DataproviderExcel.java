package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import Iconstants.FramworkConstants;

public final class DataproviderExcel {

	  private static List<Map<String, String>> list = new ArrayList<>();
	  
	@DataProvider
	public static Object[] getData(Method m)
	{
		String testname = m.getName();
		
		if(list.isEmpty())
		{
			list = excelUtilss.getTestDetails(FramworkConstants.getIterationdatasheet());
		}
		
	    List<Map<String, String>> list = excelUtilss.getTestDetails("DATA");
	    
	    List<Map<String, String>> smalllist =new ArrayList<>();
	    
	    for(int i=0;i<list.size();i++)
	    {
	       if(list.get(i).get("testname").equalsIgnoreCase(testname)&&
	    	   list.get(i).get("execute").equalsIgnoreCase("yes"))
	    	   {
	    		   smalllist.add(list.get(i));
	    	   }
	    }
	    
	    list.removeAll(smalllist); 
	    
		return smalllist.toArray();
	       
	
	
	
}
}