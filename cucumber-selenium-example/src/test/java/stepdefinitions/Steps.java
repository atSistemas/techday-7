package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.HomePOM;

public class Steps {
	
	private WebDriver driver;
	private HomePOM homePage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eriol\\OneDrive\\Trabajo\\atSistemas\\TechDay\\techday-7\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^I am on the Marvel Shop home page$")
	public void visit_marvel_shop_home_page() {
		this.homePage = new HomePOM(this.driver);
	}
	
	@When("^I try to read the \"(.*?)\"$")
	public void i_try_to_read_the(String section) {
	    this.homePage.goToSection(section);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
