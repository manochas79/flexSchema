package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonCV;

public class TC_PersonCV extends BaseClass {
	
	public static LoginPage loginPage;
	public static PersonCV personCV;
	
	@Test(priority = 1)
	public void validateCreatePerson() throws InterruptedException
	
	{
		personCV = new PersonCV(driver);
		Thread.sleep(3000);
		//personCV.validateCreatePerson();
	}

}
