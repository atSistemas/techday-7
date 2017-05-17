@BuyProducts
Feature: Buy products
	In order to get my favourite Marvel items
	As a customer
	I want to choose and buy a product
	
	Scenario: Buy Iron Man product
		Given I am on the Marvel Shop home page
		And I look for "Iron Man"
		When I try to purchase the first item
		Then I should arrive to the "Cart" page