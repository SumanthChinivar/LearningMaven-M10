package testCasesDWS;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POMRepository.HomePage;
import POMRepository.ProductDetailsPage;
import baseClass.BaseClass;

public class TC_DWS_AddToWishList_004Test extends BaseClass {

	@Test
	public void addToWishList() throws EncryptedDocumentException, IOException {
		String[][] value = data.readingDataFromMultipleRowColumn(path,sheetname);

		Actions action = new Actions(driver);
		action.scrollByAmount(0, 600).perform();

		HomePage home = new HomePage(driver);
		home.getAddToCartButton().click();

		ProductDetailsPage details = new ProductDetailsPage(driver);
		details.getRecipientNameTextField().sendKeys(value[1][3]);
		details.getReceipientEmailTextField().sendKeys(value[1][4]);

		details.getAddToWishList().click();
	}
}
