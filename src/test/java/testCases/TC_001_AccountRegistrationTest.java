package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("****** Starting TC_001_AccountRegistrationTest *****");
		try
		{HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked on registration link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Entering customer information");
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+randomeNumber()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message..");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");		
		
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.info("****** Finished TC_001_AccountRegistrationTest *****");
		
	}
	
	
	

}
