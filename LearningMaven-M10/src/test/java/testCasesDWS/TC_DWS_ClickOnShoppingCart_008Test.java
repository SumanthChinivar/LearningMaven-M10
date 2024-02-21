package testCasesDWS;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMRepository.HomePage;
import POMRepository.ShoppingCartPage;
import baseClass.BaseClass;

public class TC_DWS_ClickOnShoppingCart_008Test extends BaseClass {
	@Test
	public void clickOnShoppingCart() {
		HomePage home=new HomePage(driver);
		home.getShoppingCartLink().click();
		
		ShoppingCartPage shopping=new ShoppingCartPage(driver);
		boolean cart=shopping.getShoppingCartText().isDisplayed();
		softAssert.assertEquals(cart, true,"Shopping cart page is not displayed");
		Reporter.log("Shopping cart page is displayed",true);
	}
}
