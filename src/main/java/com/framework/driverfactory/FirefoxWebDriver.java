package com.framework.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver implements WebDriverUtil{

	WebDriver driver;
	
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		return new FirefoxDriver();
	}

}
