package Generic_Utilities;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to all web driver actions
 * @author mamta
 */
public class WebDriver_Utility {
	
/**
 * This method is used for maximizing browser window
 * @param driver
 * @author mamta
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		//driver.manage().window().minimize();
	}
	
	
	/**
	 * This method will wait for the element to load in GUI
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicit wait
	}
	
	/**
	 * After every action it will for next action to perform
	 * @param driver
	 * @author mamta
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	
	
	/**
	 * Used to wait for element to be clickable in GUI and check for specific element for every 500milli sec.
	 * @param driver
	 * @param Element
	 * @param pollingTime
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait =new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	
	/**
	 * This wait is used to wait for  a particular condition to be satisfied
	 * @param driver
	 * @param Element
	 * @param pollingTime
	 * @author mamta
	 */
	
	public void ExplicitWait(WebDriver driver,WebElement Element,int pollingTime) 
	{
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	
	
	/** This method is used for switching windows
	 * 
	 * @param driver
	 * @param visibleText
	 * @author mamta
	 */
	
	public void swtichingWindows(WebDriver driver,String visibleText)
	{
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> id=allWindows.iterator();
		
		while(id.hasNext())
		{
			String win=id.next();
			driver.switchTo().window(win);
			String title=driver.getTitle();
		
			if(title.contains(visibleText))
			{
				break;
			}
			
		}
	}
	/**
	 *used to switch to AlertWindow and Accept(click on ok Button) 
	 *@param driver
	 *@author mamta 
	 */
	public void switchToAlertAndAccpect(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to AlertWindow and dismiss(click on Cancel Button)
	 *  @param driver
	 * @author mamta
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author mamta
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author mamta
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);	
	}
	
	/**
	 * used to select the value from the dropDown based on index
	 * @param element
	 * @param index
	 * @author mamta
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDown based on text
	* @param element
	 * @param text
	 * @author mamta
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author mamta
	 * 
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 * @author mamta
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	public  String takeScreenshot(WebDriver sDriver, String methodName) {
		
		Date date=new Date();
		date.toString().replace(" "," ").replace(":","-");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}
	public void JavaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
}
		
		
	
	


