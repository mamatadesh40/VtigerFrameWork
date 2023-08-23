package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
/**
 * This method is used for launching the application and also it will read data from property file and return
 * @param key
 * @return
 * @throws Throwable
 */
	
	public String getKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String Value=pro.getProperty(key);
		return Value;
		
		
	}

}
