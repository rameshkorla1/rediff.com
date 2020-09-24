Feature: Search and Verify Results
@001
Scenario: Search and verify results
Given User is a Non registered Customer and navigate to "https://www.ebay.co.uk"
When User search for an Item
Then To get a list of matching results 
And Verify the Items cards show: postage price, no of bids, price 
When user can sort the results by Lowest Price 
Then Verify the results are listed in the page incorrect order
When user can sort the results by Highest Price
Then Verify the highest price results are listed in the page incorrect order
And user can filter the results by "Buy it now" and verify