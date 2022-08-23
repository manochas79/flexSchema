package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonCV;
import com.qa.pages.PersonMRV;
import com.qa.util.XLUtils;

public class TC_PersonCV_DDT extends BaseClass
{
	public static LoginPage loginPage;
	public static PersonCV personCV;
	public static PersonMRV personMRV;
	
	@Test(dataProvider="CreatePerson")
	public void validateCreatePerson(String alterName, String firstName, String middleName, String lastName) throws InterruptedException
	
	{
		personCV = new PersonCV(driver);
		personMRV = new PersonMRV(driver);
		//Thread.sleep(3000);
		//personCV.validateCreatePerson();
		
		personMRV.openPersonMRV();
		
		personCV.alternateName(alterName);
		personCV.firstName(firstName);
		personCV.middleName(middleName);
		personCV.lastName(lastName);
	}
	
}
