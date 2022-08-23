package com.qa.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonCV;
import com.qa.pages.PersonMRV;
import com.qa.pages.PersonSRV;
import com.qa.util.XLUtils;

public class TC_PersonSRV extends BaseClass
{
	public static LoginPage loginPage;
	public static PersonCV personCV;
	public static PersonMRV personMRV;
	public static PersonSRV personSRV;
	
	@Test(dataProvider="getTestData")
	public void validateSRVPerson(String alterName, String firstName, String middleName, String lastName) throws InterruptedException
	
	{
		personMRV = new PersonMRV(driver);
		personSRV = new PersonSRV(driver);
		
		String fullName;
		
		if(middleName.equals(""))
		{
			fullName = firstName + " " + lastName;	
		}
		else
		{
			fullName = firstName + " " + middleName + " " + lastName;
		}
		
		personMRV.openPersonMRV();
		//personMRV.PersonMRVFilter(fullName);
		personMRV.clickFirstRow(fullName);
		
		//Thread.sleep(5000);
		
		String an = personSRV.validateAlternateName();
		String fn = personSRV.validateFirstName();
		String mn = personSRV.validateMiddleName();
		String ln = personSRV.validateLastName();
		
		if(alterName.equals(an))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertEquals(an, alterName);
		}
		
		if(firstName.equals(fn))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertEquals(fn, firstName);
		}
		
		if(middleName.equals(mn))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertEquals(mn, middleName);
		}
		
		if(lastName.equals(ln))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertEquals(ln, lastName);
		}
	}
	
	@DataProvider
	public String[][] getTestData() throws IOException
	{
		String[][] testData = getData("Person");
		return testData;
	}
	/*public String[][] getTestData(String [][] personCVData)
	{
		try {
			getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personCVData;
	}*/
}
