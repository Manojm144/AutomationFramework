
package com.framework.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeWebDriver implements WebDriverUtil{
	
	WebDriver driver;

	public WebDriver getDriver() {
		
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		return new ChromeDriver();
	}

}
