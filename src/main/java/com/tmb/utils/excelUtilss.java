package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Iconstants.FramworkConstants;

public class excelUtilss {

	private excelUtilss() {}

	public static List<Map<String, String>> getTestDetails(String SheetName){
		List<Map<String , String>>list = null;
		FileInputStream fs = null ;
		
		try {
			fs = new FileInputStream(FramworkConstants.getExcelpath());
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
			e1.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(Objects.nonNull(fs))
				{
				 	fs.close();
				}
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}


}
