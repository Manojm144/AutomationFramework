package com.framework.pageobjects;

import java.util.List;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import org.testng.Reporter;

import com.framework.core.BasePage;

public class SearchResultPage extends BasePage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h1[contains(.,'results for')]")
	private WebElement txtSearchResult;
	
	@FindBy(xpath="//h1[contains(.,'results for')]//b")
	private WebElement txtSearch;
	
	@FindBy(css="h3.lvtitle")
	private List<WebElement> products; 
	
	@FindBy(xpath="//*[text()='50\" - 60\"']")
	WebElement screenSize50_60;
	
	@FindBy(id="ConstraintCaptionContainer")
	WebElement eleConstraints;
	public boolean isSearchResultDisplayed(){
		return txtSearchResult.isDisplayed();
	}
	
	public String getTextSearched(){
		return txtSearch.getText();
	}
	
	public String getSearchResultsText(){
		return txtSearchResult.getText();
	}

	public int getProductCount() {
		return products.size();
	}

	public String getProductTitle(int i) {
		return products.get(i).getText();
	}
	public void filterScreenSize50_60() {
		this.screenSize50_60.click();
		PageFactory.initElements(driver, this);
	}
	public String getConstraints() {
		return this.eleConstraints.getText();
	}

	public ProductPage openProductByIndex(int index) {
		Reporter.log("Opening random product: "+products.get(index).getText(),true);
		products.get(index).click();
		return PageFactory.initElements(driver, ProductPage.class);
	}
}
