package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import pageobjects.HomePOM;

public class Steps {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eriol\\OneDrive\\Trabajo\\atSistemas\\TechDay\\techday-7\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@Given("^I am on the Marvel Shop home page$")
	public void visit_marvel_shop_home_page() {
		HomePOM homePage = new HomePOM(this.driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
