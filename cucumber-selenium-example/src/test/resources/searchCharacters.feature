@Characters
Feature: Check characters products
	In order to know available products about my favorite character
	As a customer
	I want to look for characters products
	
	Scenario: Search for Iron Man products
		Given I am on the Marvel Shop home page
		When I look for "Iron Man"
		Then I should see a list of "Iron Man" available products
	
	Scenario: Search for Thor products
		Given I am on the Marvel Shop home page
		When I look for "Thor"
		Then I should see a list of "Thor" available products