Feature: Application logOut
@logout
Scenario: Validate login and logout
Given Open any Browser
And Navigate to Login page
When User enters username as "navi@gmail.com" and password as "n1234" into the fields
And User clicks on Login button
Then Verify user should able to successfully login
And Click on myAccount Dropdown and then Click on Logout option
Then User should be Logout Successfully