/**
 * 
 */
package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.framework.core.BasePage;
import com.framework.utils.Log;
import com.framework.utils.Message;
import com.framework.utils.ScreenshotUtils;

/**
 * @author manoj
 *
 */
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
