package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM {
	
	private final String url = "https://shop.marvel.com/";
	private WebDriver driver;
	
	public HomePOM(WebDriver driver) {
    	this.driver = driver;
		this.driver.get(url);
	}

	public void goToSection(String section) {
		this.driver.findElement(By.xpath("//a[contains(text(),'" + section + "')]")).click();
	}

}
