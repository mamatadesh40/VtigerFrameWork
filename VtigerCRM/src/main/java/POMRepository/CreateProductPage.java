package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateProductPage {
//Initialization	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration

@FindBy(xpath="//img[@title='Create Product...']")
private WebElement CreateProdImg;

@FindBy(name="productname")
private WebElement prodname;

@FindBy(xpath="((//input[@title='Save [Alt+S]'])[2]")
private WebElement saveButton;

//Getter Methods

public WebElement getCreateProdImg() {
	return CreateProdImg;
}
public WebElement getProdname() {
	return prodname;
}
public WebElement getSaveButton() {
	return saveButton;
}
//Business Logic
public void clickonPlussign()
{
	CreateProdImg.click();
}
public void createprodname(String productname) {
	
	prodname.sendKeys(productname);
}
public void saveButton(WebDriver driver) throws Throwable
{
	WebDriver_Utility wlib=new WebDriver_Utility();
	
	WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	wlib.JavaScriptExecutor(driver, saveButton);
	
	saveButton.click();
	
}
	
}

