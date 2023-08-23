package CampaignModule;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateCampaignsPage;
import POMRepository.CreateProductPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
public class CreateCampaignwithProduct extends BaseClass {

	@Test(groups="regressionTest")
	public void CreateCampaignwithProduct() throws Throwable {
		// TODO Auto-generated method stub
		
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		//File_Utility FIU = new File_Utility();
		Java_Utility JU=new Java_Utility();
		Excel_Utility EXU = new Excel_Utility();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		//wlib.maximizeWindow(driver);
		//wlib.implicitlyWait(driver);
	/*	FileInputStream fes = new FileInputStream("./src/test/resources/vtigerSeleniumcommondata.properties");
		
		Properties prop=new Properties();
		prop.load(fes);
		
		String URL=prop.getProperty("url");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String USERNAME=prop.getProperty("username");
		String PWD=prop.getProperty("password");*/
		
		
		
		//String URL = FIU.getKeyAndValue("url");
	//	String USERNAME= FIU.getKeyAndValue("username");
		//String PWD=FIU.getKeyAndValue("password");
		
		//driver.get(URL);
		//login into the Application
		//LoginPage login=new LoginPage(driver);
      //  login.loginToApp(USERNAME, PWD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();*/
		//Click on Products link
        HomePage home=new HomePage(driver);
        home.productLink();
        
		/*driver.findElement(By.linkText("Products")).click();*/
      //  click on Plussign
        CreateProductPage createProduct=new CreateProductPage(driver);
        createProduct.clickonPlussign();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
	/*	Random ran = new Random();
		int rannum = ran.nextInt(1000);*/
		
	//To avoid duplicate call Random Method	
		int rannum = JU.getRandomNum();
		
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/VtigerSScenarioData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Products");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String product = cell.getStringCellValue()+rannum; */
		
		//Fetch data from excel sheet
		String product = EXU.getExcelData("products",0,0)+rannum;
		createProduct.createprodname(product);
		//driver.findElement(By.name("productname")).sendKeys(product);
		
		//Assert.assertEquals(false, true);
		
		createProduct.saveButton(driver);
		
		/*WebElement ele = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		ele.click();*/
		
		 
		/*Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(0);
		DataFormatter format=new DataFormatter();
		String price = format.formatCellValue(cell1);
		
		driver.findElement(By.name("unit_price")).sendKeys(price);
		
		WebElement ele = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		
	/*	Rectangle rect = ele.getRect();
		System.out.println(rect.getX());
		System.out.println(rect.getY());

		
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1149)");*/
		
		//ele.click();
		
		// Click on More link
		
		home.clickMoreLink();
		
		//Click on Campaigns link
		
		home.clickCampLink();
		/*driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();*/
		
		//Create Campaign
		
		CreateCampaignsPage campPage=new CreateCampaignsPage(driver);
		 campPage.clickplusImg();
		/*driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		 */
		//To add the product from the Product window into the campaign module		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//Another way of switching windows adv.selenium
		
		wlib.swtichingWindows(driver," Products&action");
		
		
	/*	Set<String> allwindows=driver.getWindowHandles();
		Iterator<String> id= allwindows.iterator();
		while(id.hasNext())
		{
			String win=id.next();
			driver.switchTo().window(win);
			String title=driver.getTitle();
			
			if(title.contains("Products&action"))
			{
				break;		
			}
		
		}*/
		
		
		
	/*	One way of switching window in basic selenium
	 * String mainId = driver.getWindowHandle();
		System.out.println(mainId);
		
		Set<String> allIds = driver.getWindowHandles();
		System.out.println(allIds);
		
		for(String id:allIds)
		{
			if(!mainId.equals(id)) {
				
			driver.switchTo().window(id);
			}
		}
						Thread.sleep(1000);*/
						
			
		campPage.productNameSwitching(product);
		//	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(product);
		
				
		campPage.searchProductdata();
		//driver.findElement(By.xpath("//input[@name='search']")).submit();
		Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
			
			
			wlib.swtichingWindows(driver, "Campaigns&action");
			
		
			
		/*	Set<String> allwindows1=driver.getWindowHandles();
			Iterator<String> id1= allwindows1.iterator();
			while(id1.hasNext())
			{
				String win=id1.next();
				driver.switchTo().window(win);
				String title=driver.getTitle();
				
				if(title.contains("Campaigns&action"))
				{
					break;		
				}
			}*/
			
			
			
			//driver.switchTo().window(mainId);
			
			//Fetch Data from Excel
			
			String camp = EXU.getExcelData("Campaigns",0,0)+rannum;						
					
			/*Sheet sheet1 = book.getSheet("Campaigns");
				Row row2 = sheet1.getRow(0);
				Cell cell2 = row2.getCell(0);
				String camp = cell2.getStringCellValue()+rannum1;*/
			
			
			campPage.campaignsName(camp);
					
			//driver.findElement(By.name("campaignname")).sendKeys(camp);
			
			//Save Campaign with product
			
			campPage.saveButton();
			
			//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
					
					Thread.sleep(2000);
			
			//Log out		
				//	home.logout(driver);
			//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
		
		
		}
		

	}

//Pull Back
//push back
