package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
 
 @Test(groups={"Regression","Master"})
void verify_account_registration()
 {
	 logger.info("*****starting of TC001");
	 try {
	 HomePage hp=new HomePage(driver);
	   hp.clickMyaccount();
	   hp.clickRegister();
	   logger.info("click on registed page");
	   AccountRegistrationPage  regpage=new AccountRegistrationPage(driver);
	   regpage.setFirstName(randomstring().toUpperCase());
	   regpage.setLastName(randomstring().toLowerCase());
	   regpage.setEmail(randomstring()+"@gmail.com");
	   regpage.setPhone(randomNumber());
String password=alphanumeric();
	   regpage.setPassword(password);
	   regpage.setConfirmPassword(password);
	   regpage.setPrivacyPolicy();
	   regpage.setContinuebtn();
String confirmmsg=regpage.getConfirmationmsg();
if(confirmmsg.equals("Your Account Has Been Created!"))
{
	Assert.assertTrue(true);
}
else
{
	logger.error("test failed");
	logger.debug("debuglog");
	Assert.assertTrue(false);
}

logger.info("*****Ending of TC001");
	 }
	 catch(Exception e)
	 {
		 Assert.fail();
	 }
	 logger.info("*****finish of TC001");
 }
}

