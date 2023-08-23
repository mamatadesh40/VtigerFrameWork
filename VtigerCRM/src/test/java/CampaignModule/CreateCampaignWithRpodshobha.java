package CampaignModule;

import java.io.FileInputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaignWithRpodshobha {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
	//Setting the connection to the Property file	
	FileInputStream fis = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
	Properties pro=new Properties();
	pro.load(fis);
	
	String URL=pro.getProperty("url");
	String USERNAME=pro.getProperty("username");
	String pwd=pro.getProperty("password");
	
	//Passing the Data from property file
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(pwd);
	driver.findElement(By.id("submitButton")).click();
	
	
	//Creating the new Product
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	//creating random product name
	Random ran = new Random();
	int rannum = ran.nextInt(1000);
	
	//Setting the connection with the excelsheet
	FileInputStream fes = new FileInputStream("./src/test/resources/VtigerSScenarioData.xlsx");
	
	//fetching data from excel sheet
	Workbook book = WorkbookFactory.create(fes);
	
	Sheet sheet = book.getSheet("Products");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String product = cell.getStringCellValue()+rannum;
	//passing the data from excel and saving the product
	driver.findElement(By.name("productname")).sendKeys(product);
	WebElement ele = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	ele.click();
	
	//Creating the Campaign from the campaign option under More tab.	
	driver.findElement(By.linkText("More")).click();
	driver.findElement(By.name("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	
	

	}

}
