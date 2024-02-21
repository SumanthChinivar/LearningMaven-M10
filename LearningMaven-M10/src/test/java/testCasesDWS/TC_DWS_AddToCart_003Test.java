package testCasesDWS;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.ProductDetailsPage;
import POMRepository.StartingPage;
import baseClass.BaseClass;
import utilityClasses.DataUtilityClass;

public class TC_DWS_AddToCart_003Test extends BaseClass{
	@Test
	public void addingProductToCartAndLogout() throws EncryptedDocumentException, IOException {
		String[][] values=data.readingDataFromMultipleRowColumn(path, sheetname);
		
		Actions action=new Actions(driver);
		action.scrollByAmount(0,600).perform();
		
		HomePage home=new HomePage(driver);
		home.getAddToCartButton().click();
		
		ProductDetailsPage details=new ProductDetailsPage(driver);
		details.getRecipientNameTextField().sendKeys(values[1][3]);
		details.getReceipientEmailTextField().sendKeys(values[1][4]);
		
		details.getAddToCartButton().click();
	}
}
