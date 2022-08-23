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

public class TC_PersonRestore extends BaseClass{
	
	public static LoginPage loginPage;
	public static PersonMRV personMRV;
	
	@Test(priority = 2, dataProvider="getTestData")
	public void validateArchive(String alterName, String firstName, String middleName, String lastName) throws InterruptedException
	{
		
		String fullName;
		
		if(middleName.equals(""))
		{
			fullName = firstName + " " + lastName;	
		}
		else
		{
			fullName = firstName + " " + middleName + " " + lastName;
		}
		
		personMRV = new PersonMRV(driver);
		personMRV.openPersonMRV();
		personMRV.clickCogIcon(fullName);
	}
	
	@DataProvider
	public String[][] getTestData() throws IOException
	{
		String[][] testData = getData("Person");
		return testData;
	}
}
