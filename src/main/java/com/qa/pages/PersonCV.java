package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class PersonCV extends BaseClass{
	
WebDriver ldriver;
	
	public PersonCV(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Page Factory - OR:
	
		@FindBy(xpath = "//i[@title='Create']")
		WebElement  CreateButton;
		
		@FindBy(name = "alternateName")
		WebElement AlternateName;
		
		@FindBy(name = "firstName")
		WebElement FirstName;
		
		@FindBy(name = "middleName")
		WebElement MiddleName;
		
		@FindBy(name = "lastName")
		WebElement LastName;

		@FindBy(xpath = "//i[@title='Save']")
		WebElement  SavePersonButton;
		
		//Actions :
		public void alternateName(String an) throws InterruptedException
		{
			sendKeys(ldriver, CreateButton, Duration.ofSeconds(10));
			CreateButton.click();
			Thread.sleep(3000);
			AlternateName.sendKeys(an);
		}
		
		public void firstName(String fn)
		{
			sendKeys(ldriver, FirstName, Duration.ofSeconds(10));
			FirstName.sendKeys(fn);
		}
		
		public void middleName(String mn)
		{
			sendKeys(ldriver, MiddleName, Duration.ofSeconds(10));
			MiddleName.sendKeys(mn);
		}
		
		public void lastName(String ln)
		{
			sendKeys(ldriver, LastName, Duration.ofSeconds(10));
			LastName.sendKeys(ln);
		}
		
}
