package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

// data is valid login is successful-passed-logout
// data is valid login failed-test failed
// data is invalid -login successful -testcase failed-logout
// data is invalid -login failed -test fail
public class TC003_LoginDDT  extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("***start testcase***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		//Myaccount
		MyAccountPage mypage=new MyAccountPage(driver);
	boolean targetPage=mypage.isAccountPageExit();
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true)
		{
			mypage.teardown();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);

		}
		
	}
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			mypage.teardown();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(false);	
		}
	}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******test fail***********");
	}
	

}
