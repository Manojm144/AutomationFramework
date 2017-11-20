package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.core.BasePage;

public class SearchResultPage extends BasePage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[contains(.,'results for')]")
	private WebElement txtSearchResult;
	
	@FindBy(xpath="//h1[contains(.,'results for')]//b")
	private WebElement txtSearch;
	
	public boolean isSearchResultDisplayed(){
		return txtSearchResult.isDisplayed();
	}
	
	public String getTextSearched(){
		return txtSearch.getText();
	}
	
	public String getSearchResultsText(){
		return txtSearchResult.getText();
	}
}
