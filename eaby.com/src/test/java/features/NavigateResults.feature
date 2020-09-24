Feature: Search and navigate through results pages
@003
Scenario: Search and navigate through results pages
Given User is a non registered customer and navigate to ebay site
When User search for an item
Then User get a list of matching results display
And the results show more than one page
Then the user can navigate through the pages to continue looking at the items