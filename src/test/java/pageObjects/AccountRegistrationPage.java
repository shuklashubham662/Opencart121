package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
public WebDriver driver;

public AccountRegistrationPage(WebDriver driver)
{
	super(driver);
}	
@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
@FindBy(xpath="//input[@id='input-telephone']") WebElement txtPhone;
@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
@FindBy(xpath="//input[@name='agree']") WebElement chcdPolicy;
@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
public void setFirstName(String fname)
{
	txtFirstname.sendKeys(fname);
}
public void setLastName(String lname)
{
	txtLastname.sendKeys(lname);
}
public void setEmail(String email)
{
	txtemail.sendKeys(email);
}
public void setPhone(String phone)
{
	txtPhone.sendKeys(phone);
}
public void setPassword(String Password)
{
	txtPassword.sendKeys(Password);
}
public void setConfirmPassword(String Password)
{
	txtConfirmPassword.sendKeys(Password);
}
public void setPrivacyPolicy()
{
	chcdPolicy.click();
}
public void setContinuebtn()
{
	btnContinue.click();
}

public String getConfirmationmsg()
{
	try
	{
	return(msgConfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}

}
}
