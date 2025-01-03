package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.Exception.InvalidPathForException;

import Iconstants.FramworkConstants;


public class excelUtilss {

	private excelUtilss() {}

	public static List<Map<String, String>> getTestDetails(String SheetName){
		List<Map<String , String>>list = null;
		
		
		try  (FileInputStream  fs = new FileInputStream(FramworkConstants.getExcelpath());)
		{
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			
			XSSFSheet sheet = workbook.getSheet(SheetName);


			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String , String> map = null;
			list = new ArrayList<>();
			
			for(int i=1;i<=lastrownum;i++){
				map = new HashMap<>(); // {map}
				for(int j=0;j<lastcolnum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);	
			}
		
		} catch (FileNotFoundException e1) {
			
			throw new InvalidPathForException("Excel File trying read but not found");
		}
		catch(IOException e)
		{
			throw new InvalidPathForException("some Io Exception while reading the Excel data");
		}
		return list;
	}
}

