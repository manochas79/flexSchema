package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

public class PersonSRV extends BaseClass {
	
WebDriver ldriver;
	
	public PersonSRV(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Page Factory - OR:
	
		@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-edit/div/form/form[1]/div/div[2]/div[2]/div/div/div/app-person-info-edit/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/a/datatable-body-row/div[2]/datatable-body-cell[2]/div/span")
		WebElement AlternateName;
		
		@FindBy(id = "firstName-edit")
		WebElement FirstName;
		
		@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-edit/div/form/form[2]/div/div/div/div/div/div/div/span[1]/app-person-name-edit/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/a/datatable-body-row/div[2]/datatable-body-cell[3]")
		WebElement MiddleName;
		
		@FindBy(id = "lastName-edit")
		WebElement LastName;
		
		//Actions :
		public String validateAlternateName()
		{
			sendKeys(ldriver, AlternateName, Duration.ofSeconds(10));
			//AlternateName.click();
			String an = AlternateName.getText();
			
			return an;
		}
		
		public String validateFirstName()
		{
			sendKeys(ldriver, FirstName, Duration.ofSeconds(10));
			//FirstName.click();
			String fn = FirstName.getText();
			
			return fn;
		}
		
		public String validateMiddleName()
		{
			sendKeys(ldriver, MiddleName, Duration.ofSeconds(10));
			//MiddleName.click();
			String mn = MiddleName.getText();
			
			return mn;
		}
		
		public String validateLastName()
		{
			sendKeys(ldriver, LastName, Duration.ofSeconds(10));
			String ln = LastName.getText();
			
			return ln;	
		}
		

}
