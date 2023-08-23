package ProductModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateProductPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.loginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProdUsingPropertiesFile extends BaseClass {

	//public static void main(String[] args) throws Throwable 
	@Test(groups="smokeTest")
	public void CreateProdUsingPropertiesFile() throws Throwable{
		// File_Utility fiu = new File_Utility();
		 Java_Utility ju = new Java_Utility();
		 Excel_Utility elib=new Excel_Utility();
		 WebDriver_Utility wlib=new WebDriver_Utility();
		
		
		
		//Launching the Browser
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		
	/*	FileInputStream fes = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		
		Properties prop=new Properties();
		prop.load(fes);
		
		String URL=prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PWD=prop.getProperty("password"); */
		
		//Login To application using File utility
		// String URL = fiu.getKeyAndValue("url");
		// String USERNAME=fiu.getKeyAndValue("username");
		// String PWD=fiu.getKeyAndValue("password");
		
		//driver.get(URL);
		Thread.sleep(3000);
		
		//maximizing the screen
		//*wlib.maximizeWindow(driver);
		
		//LoginPage login =new LoginPage(driver);
		//loginPage1 login=new loginPage1(driver);
		/*login.getUserTextField().sendKeys(USERNAME);
		login.getPasswordTextField().sendKeys(PWD);
		login.getLoginButton().click();
		login.loginToApp(USERNAME, PWD);//Using getter methods
		*/
		//login.loginToApp(USERNAME, PWD);//using business logic
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//Click on product link
				HomePage home=new HomePage(driver);
				home.productLink();
		
		//driver.findElement(By.linkText("Products")).click();
				
		//Click on Plus Sign			
	 CreateProductPage prodpage=new CreateProductPage(driver);
	 prodpage.clickonPlussign();
	
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();*/
		
	 //To avoid duplicate records random method
	 int rannum = ju.getRandomNum();
	/*	Random ran = new Random();
		int rannum = ran.nextInt(1000);*/
		
		
	//Fetching data from Excelsheet	
	 
	String productData=elib.getExcelData("products",0,0)+rannum;
	prodpage.createprodname(productData);
	//driver.findElement(By.name("productname")).sendKeys(product);
		
	//save data by scrolling
	
	
	prodpage.saveButton(driver);
	Thread.sleep(3000);
	
		
	/*WebElement ele = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	wlib.scrollPage(driver,ele);*/
		
	/*	Rectangle rect = ele.getRect();
		System.out.println(rect.getX());
		System.out.println(rect.getY());

		
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1149)");
		
		ele.click();*/
		
		
		/*
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
		ele.click();
		
		/*JavascriptExecutor js1=(JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView()",ele);
		ele.click();*/
		
		
		//log out
		//home.logout(driver);
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
			
		
		

	}

}
