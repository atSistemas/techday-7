package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPOM {
	
	private WebDriver driver;
	private By listItemsSelector = By.xpath("//section[@id='productList']/div[@class='productTile']");

	public ResultsPOM(WebDriver driver) {
		this.driver = driver;
	}

	public int getProductsNumber() {
		List<WebElement> listItems = driver.findElements(listItemsSelector);
		return listItems.size();
	}

	public void chooseFirstItem() {
		new WebDriverWait(this.driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("popupBackground")));
		List<WebElement> listItems = driver.findElements(listItemsSelector);
		listItems.get(0).click();
	}

}
