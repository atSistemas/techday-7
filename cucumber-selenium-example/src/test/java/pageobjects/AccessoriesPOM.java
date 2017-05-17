package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessoriesPOM {
	
	private WebDriver driver;
	
	private By resultsTextSelector = By.id("plNumberItems");
	private By characterNameSelector = By.cssSelector("div.dynamicFilter > div.customSelect > select");

	public AccessoriesPOM(WebDriver driver) {
		this.driver = driver;
	}

	public int getNumberOfResults() {
		new WebDriverWait(this.driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("popupBackground")));
		String resultsText = this.driver.findElement(resultsTextSelector).getText();
		return Integer.parseInt(resultsText.split(" ")[0]);
	}

	public void filterByAge(String age) {
		By ageSelector = By.xpath("//li[text()='" + age + "']");
		this.driver.findElement(ageSelector).click();
	}

	public void filterByCharacterName(String characterName) {
		Select characterSelect = new Select(this.driver.findElement(characterNameSelector));
		characterSelect.selectByVisibleText(characterName.toUpperCase());
	}

}
