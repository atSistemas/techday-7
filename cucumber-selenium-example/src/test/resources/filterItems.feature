@FilterAccessories
Feature: Filter accessories results
	In order to find best accessories
	As a customer
	I want to filter accessories
	
	Scenario: Filter accessories by Age Range
		Given I am on the Marvel Shop home page
		And I go to the "Accessories"
		When I filter by age
		Then I get fewer items
	
	Scenario: Filter accessories by Character name
		Given I am on the Marvel Shop home page
		And I go to the "Accessories"
		When I filter by character name
		Then I get fewer items
