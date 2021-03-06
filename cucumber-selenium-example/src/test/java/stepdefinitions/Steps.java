package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AccessoriesPOM;
import pageobjects.CartPOM;
import pageobjects.CharactersPOM;
import pageobjects.HomePOM;
import pageobjects.ProductPOM;
import pageobjects.ResultsPOM;

public class Steps {
	
	private WebDriver driver;
	
	private HomePOM homePage;
	private CharactersPOM charactersPage;
	private ResultsPOM resultsPage;
	private AccessoriesPOM accessoriesPage;
	private ProductPOM productPage;
	private CartPOM cartPage;
	
	private int unfilteredResults;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "**** PONER AQU� PATH AL DRIVER EN TU EQUIPO ****");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	@When("^I filter by \"(.*?)\" age$")
	public void i_filter_by_age(String age) {
		this.accessoriesPage = new AccessoriesPOM(this.driver);
		this.unfilteredResults = this.accessoriesPage.getNumberOfResults();
		this.accessoriesPage.filterByAge(age);
	}
	
	@When("^I filter by \"(.*?)\" character name$")
	public void i_filter_by_character_name(String characterName) {
		this.accessoriesPage = new AccessoriesPOM(this.driver);
		this.unfilteredResults = this.accessoriesPage.getNumberOfResults();
		this.accessoriesPage.filterByCharacterName(characterName);		
	}
	
	@When("^I try to purchase the first item$")
	public void i_try_to_purchase_the_first_item() {
		this.resultsPage.chooseFirstItem();
		this.productPage = new ProductPOM(this.driver);
		this.productPage.addToCart();
		this.productPage.checkOut();
		this.cartPage = new CartPOM(this.driver);
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
	
	@Then("^I get fewer items$")
	public void i_get_fewer_items() {
		int filteredResults = this.accessoriesPage.getNumberOfResults();
		Assert.assertTrue(this.unfilteredResults > filteredResults);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
