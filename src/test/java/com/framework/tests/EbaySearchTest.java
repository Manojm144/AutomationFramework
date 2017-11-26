package com.framework.tests;

import java.util.Random;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.configuration.ReadProperties;
import com.framework.core.BaseTest;
import com.framework.dp.SearchDataProvider;
import com.framework.pageobjects.HomePage;
import com.framework.pageobjects.ProductPage;
import com.framework.pageobjects.SearchResultPage;
import com.framework.tests.data.ProductDetails;
import com.framework.utils.FormatValidator;
import com.framework.utils.FwAssert;

public class EbaySearchTest extends BaseTest {

	@Test(dataProvider="DP_EXCEL_DATA", dataProviderClass=SearchDataProvider.class)
	public void testSearchParameterized(String testId,String textToSearch){
		driver.get(ReadProperties.getInstance().getProperty("APP_URL"));
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		
		SearchResultPage searchResultPage = homePage.doSearch(textToSearch);
		FwAssert.assertEquals(searchResultPage.getTextSearched(), textToSearch,"Searched text failed");
		
		int productCount = searchResultPage.getProductCount();
		for (int i = 0; i < productCount; i++) {
			String title = searchResultPage.getProductTitle(i);
			System.out.println(title);
			for (String keyword : textToSearch.split(" ")) {
				FwAssert.assertTrue(title.contains(""),"Product title: "+ title+" did not contain word: "+keyword);
			}
		}
		searchResultPage.filterScreenSize50_60();
		FwAssert.assertTrue(searchResultPage.getConstraints().contains("50\" - 60\""), "Failed t appy filter 50\" - 60\"");
		// Randomly select any one product
		int index = new Random().nextInt(60);
		ProductPage productPage = searchResultPage.openProductByIndex(index);
		
		FwAssert.assertTrue(!productPage.getConditionText().isEmpty(), "Condition text not found / empty");
		// check time leeft
		// check prise format
		ProductDetails productDetails = productPage.getProductDetails();
		String price = productPage.getProductPrice();
		
	
		
		FwAssert.assertTrue(FormatValidator.validate(price,"\\$(\\d{1,2},)?(\\d{1,3})(\\.\\d{2})?"), "Price format invalid");
		
		
		
		
		
		
//		ShoppingCardPage shoppingCardPage =  productPage.clickAddToCart();
 //   	FwAssert.assertEquals(shoppingCardPage.getPrice(), productDetails.prise, "Prise failed");
		//Check name
		// check seller name
//		FwAssert.assertEquals(shoppingCardPage.totalUnitePrise(),shoppingCardPage.getPrice(),"Total prise value failed");
		// proceed to checkout as gues
		
	}

	
	
	
}
