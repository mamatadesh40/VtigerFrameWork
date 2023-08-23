package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {
	
	Excel_Utility eutil= new Excel_Utility();
	WebDriver_Utility wlib=new WebDriver_Utility();
	Java_Utility ju=new Java_Utility();
	
	@Test(dataProvider="getData")
	public void vTiger(String orgName,String phnNum,String email) throws Throwable
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.name("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		
		
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
				
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0]="AAA"+ranNum;
		objarr[0][1]="314545454";
		objarr[0][2]="vdgv@gmail.com";
		
		objarr[1][0]="BBB"+ranNum;
		objarr[1][1]="3146464646";
		objarr[1][2]="vfgf@gmail.com";
		
		objarr[2][0]="CCC"+ranNum;
		objarr[2][1]="314545454";
		objarr[2][2]="vdgv@gmail.com";
		
		return objarr;
		
		
		
	}

}
