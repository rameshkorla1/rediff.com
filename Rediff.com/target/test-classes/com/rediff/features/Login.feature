Feature: To test Login Page in HomePage

Scenario Outline: To Checks the Login Functionality

Given User is opens the browser and goes to "http://www.rediff.com"
And User clicks on Rediffmail icon
When User enters invalid username <username> and password <password>
Then User sees the error message on the page 
And closes the browser

Examples:
|username		|password		|
|test			  |pass			  |
|test2			|fail			  |