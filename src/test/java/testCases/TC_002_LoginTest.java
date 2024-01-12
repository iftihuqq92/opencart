package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass

{
	@Test(groups= {"sanity","master"})
	public void verify_login()
	{
		logger.info("**** Staring TC_002_LoginTest ****");
		logger.debug("capturing application debug logs.....");
		
		try
		{
	    //Home Page
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		hp.clickLogin(); //login link under MyAccount
		logger.info("clicked on login link");
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email & password...");
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); //login button 
		logger.info("Clicked on login button");
		
		//My Account page
		MyAccountPage mp=new MyAccountPage(driver);
		
		boolean tp=mp.isMyAccountPageExists();
		if(tp==true)
		{
			logger.info("Login test passed");
			AssertJUnit.assertTrue(true);
		}
		else
		{
			logger.error("Login test failed");
			AssertJUnit.fail();
		}
		
		
		
		}
		
		catch(Exception e)
		{
			AssertJUnit.fail();
		}
		logger.info("**** Finished TC_002_LoginTest ****");
		
	}

	
	
	
	
	
	
	
	
	
}
