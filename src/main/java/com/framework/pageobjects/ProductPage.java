package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.core.BasePage;
import com.framework.tests.data.ProductDetails;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className="condText")
	WebElement eleConditions;
	
	@FindBy(css="[itemprop=\"price\"]")
	WebElement elePrise;
	
	@FindBy(className="mbg-nw")
	WebElement eleSellerName;
	
	
	
	@FindBy(id="itemTitle")
	WebElement eleTitle;
	
	public String getConditionText() {
		try{
			return eleConditions.getText();
		}
		catch (Exception e) {
			return "";
		}
	}

	public ProductDetails getProductDetails() {
		return new ProductDetails(eleTitle.getText(), elePrise.getAttribute("content"), eleSellerName.getText());
	}

	public String getProductPrice() {
		return elePrise.getText().split(" ")[1];
	}
	
}
