package OrganizationModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UseOfPropertyFile {

	public static void main(String[] args) throws Throwable  {
		
		//WebDriver driver=new ChromeDriver();
		
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String URL=prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PWD=prop.getProperty("password");*/
		
		File_Utility flib=new File_Utility();
		
		WebDriver driver = null;
		String BROWSER=flib.getKeyAndValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		String URL=flib.getKeyAndValue("url");
		String USERNAME=flib.getKeyAndValue("username");
		String PWD=flib.getKeyAndValue("password");
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		 
		 
		
		
		
				

	}

}
