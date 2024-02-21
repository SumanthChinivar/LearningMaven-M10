package testCasesDWS;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POMRepository.HomePage;
import baseClass.BaseClass;

public class TC_DWS_NewsLetter_005Test extends BaseClass{
	@Test
	public void newsLetter() throws EncryptedDocumentException, IOException {
		String[][] value=data.readingDataFromMultipleRowColumn(path,sheetname);
		
		HomePage home=new HomePage(driver);
		home.getNewsLetterTextField().sendKeys(value[1][0]);
		home.getSubscribeButton().click();
	}
}
