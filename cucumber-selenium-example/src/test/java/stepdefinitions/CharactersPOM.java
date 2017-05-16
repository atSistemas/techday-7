package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CharactersPOM {
	
	private WebDriver driver;

	public CharactersPOM(WebDriver driver) {
		this.driver = driver;
	}

	public void choose(String character) {
		this.driver.findElement(By.xpath("//h2[contains(text()[2],'" + character.toUpperCase() + "')]")).click();
	}

}
