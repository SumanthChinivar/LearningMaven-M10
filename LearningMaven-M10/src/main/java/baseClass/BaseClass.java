package baseClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import POMRepository.LoginPage;
import POMRepository.StartingPage;
import utilityClasses.DataUtilityClass;
import utilityClasses.FrameworkConstants;

public class BaseClass implements FrameworkConstants{

	public WebDriver driver;
	public DataUtilityClass data;
	LoginPage login;
	StartingPage start;
	public SoftAssert softAssert;
	
	@Parameters("browserName")
	@BeforeClass
	public void browserSetup(@Optional("chrome") String browserName) throws EncryptedDocumentException, IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		data=new DataUtilityClass();
		String url=data.readingSingleDataFromExcelFile("./src/test/resources/excelFile/LoginDetails.xlsx", "Practice",1 , 2);
		Reporter.log("Browser is opened",true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		Reporter.log("URL is launched",true);
		softAssert=new SoftAssert();
	}

	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException {
		start=new StartingPage(driver);
		login=new LoginPage(driver);
		String credentials[][]=data.readingDataFromMultipleRowColumn("./src/test/resources/excelFile/LoginDetails.xlsx", "Practice");
		start.getLoginLink().click();
		Reporter.log("Login page is diaplayed");
		login.getEmailTextField().sendKeys(credentials[1][0]);
		Reporter.log("Email id is entered",true);
		login.getPasswordTextField().sendKeys(credentials[1][1]);
		Reporter.log("password is entered",true);
		login.getLoginButton().click();
		Reporter.log("User logged in successfully",true);
	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("User logged out successfully",true);
		softAssert.assertAll();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Browser closed successfully",true);
	}

}
