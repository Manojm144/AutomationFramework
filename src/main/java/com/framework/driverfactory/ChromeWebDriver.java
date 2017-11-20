/**
 * 
 */
package com.framework.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author manoj
 *
 */
public class ChromeWebDriver implements WebDriverUtil{
	
	WebDriver driver;

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		return new ChromeDriver();
	}

}
