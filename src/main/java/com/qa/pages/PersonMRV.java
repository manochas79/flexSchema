package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

public class PersonMRV extends BaseClass
{
	WebDriver ldriver;
		
	public PersonMRV(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
//Page Factory - OR:
	
	@FindBy(xpath = "//a[text()='Person' and @class='nav-link']")
	WebElement PageHeader;
	
	@FindBy(xpath = "//button[contains(text(), ' Application Administration ')]")
	WebElement AppAdministratorMenu;
	
	@FindBy(xpath = "//a[text()='Person' and @class='dropdown-item']")
	WebElement PersonLink;
	
	@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-lis/div/form/div/div[2]/div/div/div[1]/section/div/ul/div/span[2]/i")
	WebElement FilterButton;
	
	@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-lis/div/form/div/app-custom-fillter-component/div/div[1]/div[1]/div/span[1]/select")
	WebElement FilterTable;
	
	@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-lis/div/form/div/app-custom-fillter-component/div/div[1]/div[1]/div/span[2]/select")
	WebElement FilterColumn;
	
	@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-lis/div/form/div/app-custom-fillter-component/div/div[1]/div[1]/div/span[3]/select")
	WebElement FilterCondition;
	
	@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-lis/div/form/div/app-custom-fillter-component/div/div[1]/div[1]/div/span[10]/span/input")
	WebElement FilterValue;

	@FindBy(xpath = "/html/body/app-root/app-model-table-list-view/div/div/div[1]/div[3]/app-person-lis/div/form/div/app-custom-fillter-component/div/div[1]/div[1]/div/span[10]/span/ul/li/span")
	WebElement clickValue;
	
					
//Actions :
	
	public void openPersonMRV() throws InterruptedException
	{
		sendKeys(ldriver, AppAdministratorMenu, Duration.ofSeconds(20));
		AppAdministratorMenu.click();
		sendKeys(ldriver, PersonLink, Duration.ofSeconds(10));
		PersonLink.click();
	}
		
	public String validatePersonMRV()
	{
		sendKeys(ldriver, PageHeader, Duration.ofSeconds(10));
		return PageHeader.getText();
	}
	
	public void PersonMRVFilter(String fullName) throws InterruptedException
	{
		Thread.sleep(2000);
		FilterButton.click();
		Thread.sleep(2000);
		FilterTable.sendKeys("Person");
		Thread.sleep(2000);
		FilterColumn.sendKeys("Full Name");
		Thread.sleep(2000);
		FilterCondition.sendKeys("Equals");
		Thread.sleep(2000);
		FilterValue.sendKeys(fullName);
		Thread.sleep(4000);
		clickValue.click();
		
		
		/*
		sendKeys(ldriver, FilterButton, Duration.ofSeconds(10) );
		FilterButton.click();
		
		sendKeys(ldriver, FilterTable, Duration.ofSeconds(10) );
		FilterTable.sendKeys("Person");
		
		sendKeys(ldriver, FilterColumn, Duration.ofSeconds(10) );
		FilterColumn.sendKeys("Full Name");
		
		sendKeys(ldriver, FilterCondition, Duration.ofSeconds(10) );
		FilterCondition.sendKeys("Equals");
		
		sendKeys(ldriver, FilterValue, Duration.ofSeconds(10) );
		FilterValue.sendKeys(fullName);
		
		sendKeys(ldriver, clickValue, Duration.ofSeconds(10) );
		clickValue.click();
		*/
		
	}
	
	public void clickFirstRow(String fullName) throws InterruptedException
	{
		
		Actions act = new Actions(ldriver);
		
		//Double click on element
		Thread.sleep(2000);
		WebElement clickFirstRow = driver.findElement(By.xpath("//li[text()='"+fullName+"']//parent::ul[@class='padding text']//parent::span[@class='text']//parent::div//parent::datatable-body-cell[@class='datatable-body-cell overlaping sort-active']//preceding-sibling::datatable-body-cell//div//span//input[@type='checkbox']"));
		sendKeys(ldriver, clickFirstRow, Duration.ofSeconds(10));
		act.doubleClick(clickFirstRow).perform();
		//Thread.sleep(5000);
	}
	
	
	public void clickCogIcon(String fullName) throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement clickCogIcon = driver.findElement(By.xpath("//li[text()='Vikass Manocha']//parent::ul[@class='padding text']//parent::span//parent::div//parent::datatable-body-cell//preceding-sibling::datatable-body-cell//span//span"));
		sendKeys(ldriver, clickCogIcon, Duration.ofSeconds(10));
		//clickCogIcon.click();
		Thread.sleep(5000);
		
	}
	
}
