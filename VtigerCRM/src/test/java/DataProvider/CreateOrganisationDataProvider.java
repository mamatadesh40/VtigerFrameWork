package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationDataProvider extends BaseClass {
	Excel_Utility eutil= new Excel_Utility();
	WebDriver_Utility wlib=new WebDriver_Utility();
	Java_Utility ju=new Java_Utility();
	File_Utility fib=new File_Utility();
	
	@Test(dataProvider="getData")
	public void vTiger(String org,String phnNum,String email) throws Throwable
	{
		String orgname=org+ju.getRandomNum();
		HomePage home=new HomePage(driver);
		home.OrganizationLink();
		
		CreateOrganizationPage org1=new CreateOrganizationPage(driver);
		org1.clickOnImg();
		
		org1.orgData(orgname, phnNum, email);
		org1.clickSaveButton();
		Thread.sleep(3000);
				
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eutil.readMultipleData("VtigergetData");
	}

}
