package com.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter{
	
	private ExtentReports extent;
	//private ExtentHtmlReporter htmlReporter;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
	{
		//String repName = "Test-Report.html";
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp;
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output" + repName);
		extent = new ExtentReports(outputDirectory + "\\FS-Reports" + File.separator + repName + ".html");
		/*
		 * extent.attachReporter(htmlReporter); extent.setSystemInfo("Host name",
		 * "localhost"); extent.setSystemInfo("Environment", "QA");
		 * extent.setSystemInfo("user", "pavan");
		 */
		
		for(ISuite suite : suites)
		{
			Map<String, ISuiteResult> result = suite.getResults();
			
			for(ISuiteResult r : result.values())
			{
				ITestContext context = r.getTestContext();
				
				passedTests(context.getPassedTests(), LogStatus.PASS);
				failedTests(context.getFailedTests(), LogStatus.FAIL);
				skippedTests(context.getSkippedTests(), LogStatus.SKIP);
				
				
			}
		}
		
		extent.flush();
		extent.close();
			
	}
	
	private void passedTests(IResultMap tests, LogStatus status)
	{
		ExtentTest test;
		
		if(tests.size() > 0)
		{
			for (ITestResult result : tests.getAllResults())
			{
				test = extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups())
					test.assignAuthor(group);
				
				if(result.getThrowable() != null)
				{
					 test.log(status, result.getThrowable());
				}
				
				else
				{
				test.log(status, "Test " + status.toString().toLowerCase() + "ed");	
				}
				
				extent.endTest(test);
				
			}
		}
		
	}
	
	
	private void failedTests(IResultMap tests, LogStatus status)
	{
		ExtentTest test;
		
		if(tests.size() > 0)
		{
			for (ITestResult result : tests.getAllResults())
			{
				test = extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups())
					test.assignAuthor(group);
				
				if(result.getThrowable() != null)
				{
					 test.log(status, result.getThrowable());
				}
				
				else
				{
				test.log(status, "Test " + status.toString().toLowerCase() + "ed");	
				}
				
				extent.endTest(test);
				
			}
		}
		
	}
	
	
	
	private void skippedTests(IResultMap tests, LogStatus status)
	{
		ExtentTest test;
		
		if(tests.size() > 0)
		{
			for (ITestResult result : tests.getAllResults())
			{
				test = extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups())
					test.assignAuthor(group);
				
				if(result.getThrowable() != null)
				{
					 test.log(status, result.getThrowable());
				}
				
				else
				{
				test.log(status, "Test " + status.toString().toLowerCase() + "ed");	
				}
				
				extent.endTest(test);
				
			}
		}
		
	}
	
	
	
	private Date getTime(long millis)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
