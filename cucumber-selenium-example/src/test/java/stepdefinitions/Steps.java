package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CharactersPOM;
import pageobjects.HomePOM;
import pageobjects.ResultsPOM;

public class Steps {
	
	private WebDriver driver;
	private HomePOM homePage;
	private CharactersPOM charactersPage;
	private ResultsPOM resultsPage;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eriol\\OneDrive\\Trabajo\\atSistemas\\TechDay\\techday-7\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Given("^I am on the Marvel Shop home page$")
	public void visit_marvel_shop_home_page() {
		this.homePage = new HomePOM(this.driver);
	}
	
	@Given("^I go to the \"(.*?)\"$")
	public void i_go_to(String section) {
	    this.homePage.goToSection(section.toUpperCase());
	}
	
	@When("^I try to read the \"(.*?)\"$")
	public void i_try_to_read_the(String section) {
	    this.homePage.goToSection(section);
	}
	
	@When("^I look for \"(.*?)\"$")
	public void i_look_for(String character) {
	    this.homePage.goToSection("Characters".toUpperCase());
	    this.charactersPage = new CharactersPOM(this.driver);
	    this.charactersPage.choose(character);
	    this.resultsPage = new ResultsPOM(this.driver);
	}
	
	@Then("^I should arrive to the \"(.*?)\" page$")
	public void i_should_arrive_to_the_page(String expectedTitlePage) {
	    Assert.assertTrue(this.driver.getTitle().contains(expectedTitlePage));
	}
	
	@Then("^I should see a list of \"(.*?)\" available products$")
	public void i_should_see_a_list_of_available_products(String character) {
	    Assert.assertTrue(this.driver.getTitle().contains(character));
	    Assert.assertTrue(resultsPage.getProductsNumber() > 0);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
