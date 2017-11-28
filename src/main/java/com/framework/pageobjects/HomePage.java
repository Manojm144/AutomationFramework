
package com.framework.pageobjects;


import org.openqa.selenium.*;

import org.openqa.selenium.support.*;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.framework.core.BasePage;
import com.framework.utils.*;



public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	@FindBy(id = "gh-ac")
	private WebElement txtSearchBox;
	
	@FindBy(id="gh-btn")
	private WebElement btnSearch;
	
	
	public SearchResultPage doSearch(String textToSearch) {
		Log.log(new Message(Status.INFO, "searching : "+textToSearch));
		txtSearchBox.sendKeys(textToSearch);
		ScreenshotUtils.takeScreenshot(driver);
		btnSearch.click();
		ScreenshotUtils.takeScreenshot(driver);
		return PageFactory.initElements(driver,SearchResultPage.class);
	}
}
