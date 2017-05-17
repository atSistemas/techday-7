package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPOM {
	
	private WebDriver driver;
	
	private By addToCartButtonSelector = By.linkText("Add to Cart".toUpperCase());
	private By checkoutButtonSelector = By.linkText("Checkout".toUpperCase());

	public ProductPOM(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart() {
		this.driver.findElement(addToCartButtonSelector).click();
	}

	public void checkOut() {
		this.driver.findElement(checkoutButtonSelector).click();		
	}

}
