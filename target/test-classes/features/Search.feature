Feature: Search Functionality
@search @sear
Scenario: Verify whether the User is able to search for the Product
Given Open the appliction in any Browser
When User search for a producr name as "<productName>"
Then User should see the product in to search Result
Examples: 
|productName|
|iphone     |