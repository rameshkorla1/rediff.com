Feature: Search and Category
@002
Scenario: Search and Category 
Given User is a non-registered customer and navigate to ebay site
When User enter a search term and select a specific Category
Then User get a list of matching results
And User can verify that the results shown as per the the selected category