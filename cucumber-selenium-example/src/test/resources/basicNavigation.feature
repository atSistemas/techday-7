@BasicNavigation
Feature: Basic navigation check
	In order to check the main navigation functionalities
	As a customer
	I want to navigate through the main sections of the website
	
	Scenario: Navigate to latest news
		Given I am on the Marvel Shop home page
		When I try to read the "Latest News"
		Then I should arrive to the "News" page