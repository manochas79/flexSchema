package com.qa.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonMRV;
import com.qa.util.XLUtils;

public class TC_PersonMRV extends BaseClass{
	
	public static LoginPage loginPage;
	public static PersonMRV personMRV;
	
	@Test(priority = 1)
	public void validatePersonHeader() throws InterruptedException
	{
		
		personMRV = new PersonMRV(driver);
		personMRV.openPersonMRV();
		if (personMRV.validatePersonMRV().equals("Persons"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		}
	}
