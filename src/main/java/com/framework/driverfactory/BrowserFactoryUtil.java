package com.framework.driverfactory;

import org.openqa.selenium.WebDriver;

import com.framework.configuration.ReadProperties;

public class BrowserFactoryUtil {

	public static WebDriver getDriver() {
		
		String browser = ReadProperties.getInstance().getProperty("Browser");
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxWebDriver().getDriver();
		}else
		{
			driver = new ChromeWebDriver().getDriver();
		}
		
		driver.manage().window().maximize();

		return driver;		
	}
}
