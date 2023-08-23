package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class LoginPage {
	
	//Initializing the elements using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
		
	//Declaration of the pom class
	//@findBy,@findBys,@findAll
	@FindBy(name="user_name")
	private WebElement userTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	
	//getter methods
	public WebElement getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(WebElement userTextField) {
		this.userTextField = userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	
	
	//Business Logic
	public void loginToApp(String username,String password)
	{
		userTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	

}
