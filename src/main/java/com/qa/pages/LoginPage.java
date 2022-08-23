package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement email;

		@FindBy(name="loginpassword")
		WebElement password;
		
		@FindBy(name="submit")
		WebElement loginBtn;
		
		public void setUserName(String uname) {
			sendKeys(ldriver, email, Duration.ofSeconds(10));
		email.sendKeys(uname);
		}
		
		//Actions :
		public void setPassword(String pwd) {
			sendKeys(ldriver, password, Duration.ofSeconds(10));
			password.sendKeys(pwd);
			}
		
		public void clickSubmit() {
			sendKeys(ldriver, loginBtn, Duration.ofSeconds(10));
			loginBtn.click();
			}
		
}
