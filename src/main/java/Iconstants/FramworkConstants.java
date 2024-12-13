package Iconstants;import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtil;

public class FramworkConstants {
	
	
	
	private FramworkConstants()
	{
		
	}
	    private static final String  RESOURCEPATH= System.getProperty("user.dir")+"/src/test/resources";
		private static final String CONFIGPATH = RESOURCEPATH+"/config.prop";
		private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/index.html";
		private static String extentReportFilepath = "";
		private static final String EXCELPATH =  System.getProperty("user.dir")+"/src/test/resources/Excel/Updated.xlsx";
		private static final String RUNMANAGERSHEET = "RUNMANAGER";
		
		private static final String ITERATIONDATASHEET = "DATA";
		
		
		public static String getExtentreportfolderpath() {
			return EXTENTREPORTFOLDERPATH;
		}


		public static String getIterationdatasheet() {
			return ITERATIONDATASHEET;
		}


		public static String getExcelpath() {
			return EXCELPATH;
		}
		

		public static String getExtentReportFilepath() throws Exception {
			
			if(extentReportFilepath.isEmpty()) {
				
				extentReportFilepath = createReportPath();
			}
			return extentReportFilepath;
		}
      
		// this method take eyrything
		private static String createReportPath() throws Exception
		{
			if(PropertyUtil.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
				
				return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
			}
			else
			{
				return EXTENTREPORTFOLDERPATH+"/index.html";
			}
		}	
		private static final int EXPLICITWAIT = 20;
		
		public static int getExplicitwait() {
			return EXPLICITWAIT;
		}
		

		public static String getConfigFilepath() {
			return CONFIGPATH;
		}
		
}





