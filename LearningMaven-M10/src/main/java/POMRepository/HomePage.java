package POMRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	@FindBy(xpath = "//ul[@class='top-menu']/li")
	private List<WebElement> navigationBar;

	public List<WebElement> getNavigationBar() {
		return navigationBar;
	}
	
	@FindBy(xpath = "//ul[@class='list']/li[@class='inactive']")
	private List<WebElement> categoriesList;

	public List<WebElement> getCategoriesList() {
		return categoriesList;
	}
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCartButton;

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	
	@FindBy(id="newsletter-email")
	private WebElement newsLetterTextField;

	public WebElement getNewsLetterTextField() {
		return newsLetterTextField;
	}
	
	@FindBy(xpath = "//input[@value='Subscribe']")
	private WebElement subscribeButton;

	public WebElement getSubscribeButton() {
		return subscribeButton;
	}
	
	@FindBy(linkText = "sumanthchinivar16@gmail.com")
	private WebElement usernameLink;

	public WebElement getUsernameLink() {
		return usernameLink;
	}
	
	@FindBy(id="pollanswers-1")
	private WebElement excellentRadioButton;
	
	@FindBy(id="pollanswers-2")
	private WebElement goodRadioButton;
	
	@FindBy(id="pollanswers-3")
	private WebElement poorRadioButton;
	
	@FindBy(id="pollanswers-4")
	private WebElement veryBadRadioButton;

	public WebElement getExcellentRadioButton() {
		return excellentRadioButton;
	}

	public WebElement getGoodRadioButton() {
		return goodRadioButton;
	}

	public WebElement getPoorRadioButton() {
		return poorRadioButton;
	}

	public WebElement getVeryBadRadioButton() {
		return veryBadRadioButton;
	}
	
	@FindBy(id="vote-poll-1")
	private WebElement voteButton;

	public WebElement getVoteButton() {
		return voteButton;
	}
	
	@FindBy(xpath = "//li[contains(text(),'Excellent')]")
	private WebElement excellentVotingPercentage;

	public WebElement getExcellentVotingPercentage() {
		return excellentVotingPercentage;
	}
}
