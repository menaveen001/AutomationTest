Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "navi@gmail.com" and password as "n1234" into the fields
And User clicks on Login button
Then Verify user is able to successfully login