package com.oops.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.oops.pageObjects.LogOutPage;
import com.oops.pageObjects.LoginPage;


public class BaseClass 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static ChromeOptions option;
	public static WebDriver driver;

	public FileLib f=new FileLib();
	@BeforeTest
	public void openBrowser()
	{
		Reporter.log("openBrowser",true);
		option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


	}
	@BeforeMethod
	public void login() throws IOException
	{
		Reporter.log("login",true);

		String url=f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un,pw);	
	} 
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout",true);
		LogOutPage l=new LogOutPage(driver);
		l.getLogout().click();
	}

	@AfterTest
	public void closeBrowser()
	{
		Reporter.log("closeBrowser",true);
		driver.quit();
	}

}
