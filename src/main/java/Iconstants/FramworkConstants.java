package Iconstants;import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtil;

public class FramworkConstants {
	
	
	
	private FramworkConstants()
	{
		
	}
	    private static final String  RESOURCEPATH= System.getProperty("user.dir")+"/src/test/resources";
		private static final String CONFIGPATH = RESOURCEPATH+"/config.prop";
		public static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/extent-test-output/index.html";
		
		
		public static String getExtentreportpath() throws Exception {
			
			if(PropertyUtil.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes"))
			{
				return EXTENTREPORTPATH+"/"+System.currentTimeMillis()+"index.html";
			}
			else {
				
				return EXTENTREPORTPATH+"/"+ "index.html";
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





