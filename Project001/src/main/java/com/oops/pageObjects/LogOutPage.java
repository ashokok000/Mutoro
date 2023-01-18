package com.oops.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage 
{
	@FindBy(xpath="//a[text()='Log out']")
	public WebElement logoutbtn;
	
	public LogOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogout()
	{
		return logoutbtn;
	}
ChromeOptions option=new ChromeOptions();

	}
	

	


