package CampaignModule;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateCampaignsPage;
import POMRepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign extends BaseClass {

	//public static void main(String[] args) throws Throwable 
	@Test(groups="smokeTest")
	public void CreateCampaign() throws Throwable
	{
		
		Java_Utility JU=new Java_Utility();
		Excel_Utility EXU = new Excel_Utility();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		
		//FileInputStream fes = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		
	//	Properties prop=new Properties();
		//prop.load(fes);
		
		//String URL=prop.getProperty("url");
		//String USERNAME=prop.getProperty("username");
		//String PWD=prop.getProperty("password");
		
	//	driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PWD);
	//	driver.findElement(By.id("submitButton")).click();
		HomePage home=new HomePage(driver);
		home.clickMoreLink();
		//driver.findElement(By.linkText("More")).click();
		home.clickCampLink();
		//driver.findElement(By.name("Campaigns")).click();
		
		CreateCampaignsPage campPage=new CreateCampaignsPage(driver);
		 campPage.clickplusImg();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		 int rannum = JU.getRandomNum();
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		
		// FileInputStream fis = new FileInputStream(".//src/test/resources/VtigerSScenarioData.xlsx");
		 
		// Workbook book = WorkbookFactory.create(fis);
		// Sheet sheet = book.getSheet("Campaigns");
		// Row row = sheet.getRow(0);
		// Cell cell = row.getCell(0);
		// String camp = cell.getStringCellValue()+ranNum;
		 
		String camp = EXU.getExcelData("Campaigns",0,0)+rannum;
		campPage.campaignsName(camp);
		 //driver.findElement(By.name("campaignname")).sendKeys(camp);
		
		campPage.saveButton();
		
		 //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		
		 Thread.sleep(2000);
		 //home.logout(driver);
			//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
