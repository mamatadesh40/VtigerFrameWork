package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class loginPage1 {
	
	public loginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userTextField;
	
	@FindBys({@FindBy(xpath="//input[@type='password']"),@FindBy(name="user_password")})
	private WebElement passwordtextfield;
	
	@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
	private WebElement loginButton;

	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String username,String password)
	{
		userTextField.sendKeys(username);
		passwordtextfield.sendKeys(password);
		loginButton.click();
	}
	
	

}
