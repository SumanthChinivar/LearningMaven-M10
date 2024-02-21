package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="giftcard_2_RecipientName")
	private WebElement recipientNameTextField;
	
	@FindBy(id="giftcard_2_RecipientEmail")
	private WebElement receipientEmailTextField;
	
	@FindBy(id="giftcard_2_SenderName")
	private WebElement yourNameTextField;
	
	@FindBy(id="giftcard_2_SenderEmail")
	private WebElement yourEmailTextField;
	
	@FindBy(xpath="//input[@value='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(id="add-to-wishlist-button-2")
	private WebElement addToWishList;

	public WebElement getRecipientNameTextField() {
		return recipientNameTextField;
	}

	public WebElement getReceipientEmailTextField() {
		return receipientEmailTextField;
	}

	public WebElement getYourNameTextField() {
		return yourNameTextField;
	}

	public WebElement getYourEmailTextField() {
		return yourEmailTextField;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getAddToWishList() {
		return addToWishList;
	}
	
	@FindBy(xpath = "//p[contains(text(),'The product has been added')] ")
	private WebElement addedToCartMessage;

	public WebElement getAddedToCartMessage() {
		return addedToCartMessage;
	}
}
