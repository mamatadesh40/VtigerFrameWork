package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePage {
	
//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(linkText="More")
	private WebElement MoreLink;
	
	@FindBy(name="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement Signoutlink;
	

	
	//Getter Methods

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getAdministratorLink() {
		return AdministratorLink;
	}

	public WebElement getSignoutlink() {
		return Signoutlink;
	}
	
//Business Logic
	
	public void OrganizationLink()
	{
		OrganizationLink.click();
	}

	public void productLink()
	{
		ProductLink.click();
	}

	
	public void logout(WebDriver driver) {
		//WebDriver_Utility wlib=new WebDriver_Utility();
		//wlib.ActionsMoveToElement(driver, AdministratorLink);
		Actions act = new Actions(driver);
		act.moveToElement(AdministratorLink).perform();
		Signoutlink.click();
	}
	public void clickMoreLink()
	{
		MoreLink.click();
	}
	public void clickCampLink()
	{
		CampaignsLink.click();
		}
	
}
