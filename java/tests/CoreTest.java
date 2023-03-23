package tests;

import org.junit.Test;

import base.BasePage;
import pages.HomePage;
//import pages.ProductDetailPage;

public class CoreTest extends BasePage {

	@Test
	public void goForTest() {
		HomePage homePage = new HomePage(driver);
		homePage.keywordIsSearched();
		homePage.goToFirstLink();

//		ProductDetailPage detailPage = new ProductDetailPage(driver);
//		detailPage.goToComment();
//		detailPage.yesForFirstComment();
//		detailPage.seeCongrats();
	}

}
