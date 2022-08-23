package com.qa.base;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.qa.pages.LoginPage;
import com.qa.util.ReadConfig;
import com.qa.util.XLUtils;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getAppURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getpassword();
	public String chromePath = readConfig.getChromePath();
	public String browser = readConfig.getbroswer();
	public static WebDriver driver;
	public static Logger logger;
	public static LoginPage loginPage;
	
	String br = "chrome";
	
	
	//@Parameters("browser")
	@BeforeSuite
	public void setup()
	{
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", chromePath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", chromePath);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseURL);
		loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
				
	}
	
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
		System.out.println("After Finishing Suite");
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, Duration timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		//element.sendKeys(value);
				
	}

	@DataProvider
	public static String[][] getData(String module) throws IOException
	{
	
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\testData\\" + module + ".xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String personCVData[][] = new String [rownum][colcount];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				personCVData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
	return personCVData;
	}
	
	
}
