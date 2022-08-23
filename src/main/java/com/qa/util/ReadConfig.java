package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() 
	{
	File src = new File("./Configurations/Config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	public String getAppURL()
	{
		String URL = prop.getProperty("baseURL");
		return URL;
	}
	
	public String getUserName()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getpassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getbroswer()
	{
		String broswer = prop.getProperty("broswer");
		return broswer;
	}
	
	public String getChromePath()
	{
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
}
