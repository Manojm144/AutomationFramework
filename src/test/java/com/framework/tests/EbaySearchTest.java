package com.framework.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.configuration.ReadProperties;
import com.framework.core.BaseTest;
import com.framework.dp.SearchDataProvider;
import com.framework.pageobjects.HomePage;
import com.framework.pageobjects.SearchResultPage;
import com.framework.utils.FwAssert;

public class EbaySearchTest extends BaseTest {

	@Test(dataProvider="DP_EXCEL_DATA", dataProviderClass=SearchDataProvider.class)
	public void testSearchParameterized(String testId,String textToSearch){
		driver.get(ReadProperties.getInstance().getProperty("APP_URL"));
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		
		SearchResultPage searchResultPage = homePage.doSearch(textToSearch);
		FwAssert.assertEquals(searchResultPage.getTextSearched(), textToSearch,"Searched text failed");
	}
	
}
