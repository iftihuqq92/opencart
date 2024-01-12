package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String password, String exp)
	{
		logger.info("**** Staring TC_003_LoginDDT ****");
		
		
		try {
	    //Home Page
		HomePage hp=new HomePage(driver);
		//-----------------------------------
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		hp.clickLogin(); //login link under MyAccount
		logger.info("clicked on login link");
		//-----------------------------------
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email & password...");
		//-----------------------------------
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin(); //login button 
		logger.info("Clicked on login button");
		//-----------------------------------
		//My Account page
		MyAccountPage mp=new MyAccountPage(driver);
		boolean tp=mp.isMyAccountPageExists();
		//-----------------------------------
		if(exp.equals("Valid"))
		{
			if(tp==true)
			{
				mp.clickLogout();
				AssertJUnit.assertTrue(true);
			}
			else
			{
				AssertJUnit.assertTrue(false);
			}}
			//-----------------------------------
			if(exp.equals("Invalid"))
			{
				if(tp==true)
				{
					mp.clickLogout();
					AssertJUnit.assertTrue(false);
				}
				else
				{
					AssertJUnit.assertTrue(true);
				}
			}}
			
			catch(Exception e)
			{
				AssertJUnit.fail();
			}
		
		logger.info("**** Finished TC_003_LoginDDT ****");
		
	}
	
	
	

}
