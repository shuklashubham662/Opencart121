package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
public	WebDriver driver;
	 
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement InkRegister;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement linkLogin;
	
	public void clickMyaccount() {
		lnkMyaccount.click();
	}
	
	public void  clickRegister()
	{
		InkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
}
