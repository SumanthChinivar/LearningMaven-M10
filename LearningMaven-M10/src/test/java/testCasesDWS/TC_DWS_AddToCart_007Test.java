package testCasesDWS;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMRepository.HomePage;
import POMRepository.ProductDetailsPage;
import baseClass.BaseClass;

public class TC_DWS_AddToCart_007Test extends BaseClass{
	@Test
	public void addingProductToCartAndLogout() throws EncryptedDocumentException, IOException {

		String[][] values = data.readingDataFromMultipleRowColumn(path,sheetname);

		Actions action=new Actions(driver);
		action.scrollByAmount(0,600).perform();
		HomePage home=new HomePage(driver);
		
		home.getAddToCartButton().click();
		ProductDetailsPage details=new ProductDetailsPage(driver);
		boolean addToCartIsDisplayed = details.getAddToCartButton().isDisplayed();
		softAssert.assertEquals(addToCartIsDisplayed, true,"Products details page is not displayed");
		Reporter.log("User clicked on add to cart button",true);
		
		details.getRecipientNameTextField().sendKeys(values[1][3]);
		String recipientName = details.getRecipientNameTextField().getAttribute("value");
		softAssert.assertEquals(recipientName, values[1][3],"recipeientName mismatch");
		Reporter.log("Recepient name entered",true);
		
		details.getReceipientEmailTextField().sendKeys(values[1][4]);
		String recipientEmail = details.getReceipientEmailTextField().getAttribute("value");
		softAssert.assertEquals(recipientEmail,values[1][4],"Recipient email mismatch");
		Reporter.log("Recipient email mismatch",true);
		
		details.getAddToCartButton().click();
		boolean addedToCartMessage = details.getAddedToCartMessage().isDisplayed();
		softAssert.assertEquals(addedToCartMessage,true,"Product is not added to cart");
		Reporter.log("Product added to cart successfully",true);
		
		action.scrollByAmount(0, -150).perform();
	}
}
