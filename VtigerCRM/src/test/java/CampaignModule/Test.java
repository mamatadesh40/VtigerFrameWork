package CampaignModule;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;





public class Test {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		FileInputStream fes = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		
		Properties prop=new Properties();
		prop.load(fes);
		
		String URL=prop.getProperty("url");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String USERNAME=prop.getProperty("username");
		String PWD=prop.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		String mainId = driver.getWindowHandle();
		System.out.println(mainId);
		
		Set<String> allIds = driver.getWindowHandles();
		System.out.println(allIds);
		
		for(String id:allIds)
		{
			if(!mainId.equals(id))
			{
				
			driver.switchTo().window(id);
			
			//break;
			}
		}
									
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Puma1");
			driver.findElement(By.xpath("//input[@name='search']")).submit();
			driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
			
			FileInputStream fis = new FileInputStream("./src/test/resources/VtigerSScenarioData.xlsx");
			
			Workbook book = WorkbookFactory.create(fis);
			Sheet sheet = book.getSheet("Campaigns");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String camp = cell.getStringCellValue();
			
			driver.findElement(By.name("campaignname")).sendKeys(camp);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			
			
	}
}


