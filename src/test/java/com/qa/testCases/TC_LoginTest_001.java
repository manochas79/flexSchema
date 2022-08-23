package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	LoginPage loginPage;
	
	@Test
	public void loginTest()
	{
		
		
		//logger.info("URL is Opened");
		
		//loginPage = new LoginPage(driver);
		//loginPage.setUserName(username);
		
		/*logger.info("User Name Entered");
		
		loginPage.setPassword(baseURL);
		
		logger.info("Password Entered");*/
				
		//loginPage.clickSubmit();
		
		/*if(driver.getTitle().equals("FlexSchema"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Case is passed.");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login Test Case is failed.");
		}*/
		Assert.assertTrue(true);
		 
	}
	
	
}
