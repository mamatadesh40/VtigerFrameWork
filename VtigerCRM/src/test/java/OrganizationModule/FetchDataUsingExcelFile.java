package OrganizationModule;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;





public class FetchDataUsingExcelFile extends BaseClass {

	//public static void main(String[] args)
	@Test(groups= {"smokeTest","regressionTest"})
	public void FetchDataUsingExcelFile() throws Throwable {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
	//	File_Utility fib=new File_Utility();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		
		
		//WebDriver driver;
		
	/*	String BROWSER = fib.getKeyAndValue("browser");
		
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
		}*/
		
		/*
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String URL=prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PWD=prop.getProperty("password");
		
		driver.get(URL);*/
		//Using File_Utility (Generic Utility for code optimization and method reusability)
		//wlib.implicitlyWait(driver);
		
				
		/*String URL=fib.getKeyAndValue("url");
		String USERNAME = fib.getKeyAndValue("username");
		String PWD = fib.getKeyAndValue("password");
		
		//Thread.sleep(2000);
		
		driver.get(URL);
				
		//Calling from POM to avoid the hard coding of locators
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PWD);*/
		
	/*	login.getUserTextField().sendKeys(USERNAME);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		login.getPasswordTextField().sendKeys(PWD);
		//driver.findElement(By.name("user_password")).sendKeys(PWD);
		
		login.getLoginButton().click();
		//driver.findElement(By.id("submitButton")).click();*/
		
		HomePage home=new HomePage(driver);
		home.OrganizationLink();
		
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
		org.clickOnImg();
		
		//Assert.assertEquals(false,true);
		
		/*driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();*/
		
		/*Random ran = new Random();//use only for mandatory field
		int ranNum = ran.nextInt(1000);*/
		
		//Using Random utility to avoid duplicates
		
		
		
		int ranNum = ju.getRandomNum();
		
		
		
	/*	FileInputStream fis1=new FileInputStream("./src/test/resources/VtigerSScenarioData.xlsx");
		
			Workbook book = WorkbookFactory.create(fis1);
			Sheet sheet = book.getSheet("Organization");
			Row row = sheet.getRow(0);
			
			Cell cell = row.getCell(0);
			String orgname=cell.getStringCellValue()+ranNum;   
	*/
		
	//fetching data from excel	
		
		String orgname=elib.getExcelData("Organization",0,0)+ranNum;
		//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		Thread.sleep(2000);
		
		/*	
			Row row1 = sheet.getRow(1);
			Cell cell1 = row1.getCell(0);
			DataFormatter format=new DataFormatter();
			String orgnum = format.formatCellValue(cell1); */
			
			String orgnum=elib.getExcelDataUsingDataFormatter("Organization",1,0);
			
			//driver.findElement(By.id("phone")).sendKeys(orgnum);
			
			
		/*	Row row2 = sheet.getRow(2);
			Cell cell2 = row2.getCell(0);
			String email = cell2.getStringCellValue();*/
			
			String email=elib.getExcelDataUsingDataFormatter("Organization",2,0);
			org.orgData(orgname, orgnum, email);
			Thread.sleep(3000);
			org.clickSaveButton();
			
			//Validation
			
			/*String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			{
				if(actData.contains(orgname))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
			}*/
			
		//	driver.findElement(By.id("email1")).sendKeys(email);
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
		
			Thread.sleep(3000);
			
			
			//home.logout(driver);
			
			//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			
			//driver.findElement(By.linkText("Sign Out")).click();
			
		/*	WebElement element= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(element).click().perform(); */
			
		
	}

} //Third Pull For Organisation Module
