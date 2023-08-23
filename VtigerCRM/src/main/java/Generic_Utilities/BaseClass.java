package Generic_Utilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POMRepository.HomePage;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 public WebDriver driver;
	 public static WebDriver Sdriver;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BeforeSuite() throws Throwable
	{
		System.out.println("DataBase Connection");
		Thread.sleep(1000);
	}
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("parallele execution");
		
	}
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void beforeClass() throws Throwable
	{
		File_Utility fib=new File_Utility();
		//WebDriver driver = null;
	
	String BROWSER = fib.getKeyAndValue("browser");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		
		System.out.println("Launching Browser");
		
		Sdriver=driver;
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		File_Utility fib=new File_Utility();
		String URL=fib.getKeyAndValue("url");
		String USERNAME = fib.getKeyAndValue("username");
		String PWD = fib.getKeyAndValue("password");
		
		Thread.sleep(2000);
		
		driver.get(URL);
				
		//Calling from POM to avoid the hard coding of locators
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PWD);
		System.out.println("login to Application");
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void afterMethod()
	{
		HomePage home=new HomePage(driver);
		home.logout(driver);
		System.out.println("logout from Application");
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("close Browser");
	}
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void afterTest()
	{
		System.out.println("parallel execution done");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void aftersuite()
	{
		System.out.println("Database connection close");
	}
}
