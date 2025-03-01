package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest  extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		//login
		logger.info("*** staring TC_002 ***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		//Myaccount
		MyAccountPage mypage=new MyAccountPage(driver);
	boolean targetPage=mypage.isAccountPageExit();
	Assert.assertTrue(targetPage,"login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** finish TC_002 ***");

	}

}
