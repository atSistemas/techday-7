package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePOM {
	
	private final String url = "https://shop.marvel.com/";
	
	public HomePOM(WebDriver driver) {
    	driver.get(url);
	}

}
