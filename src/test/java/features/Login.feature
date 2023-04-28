Feature: Application Login
@loginOne @log
Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "navi@gmail.com" and password as "n1234" into the fields
And User clicks on Login button
Then Verify user should able to successfully login

@loginTwo @log
Scenario: Login with invalid credential
Given Open any Browser
And Navigate to Login page
When User enters username as "nav@gmail.com" and password as "n124" into the fields
And User clicks on Login button
Then Verify user should not able to successfully login
And User should see the error message No match for E-Mail Address and or Password

@loginThree @log
Scenario: Login with valid Email and invalid Password
Given Open any Browser
And Navigate to Login page
When User enters username as "navi@gmail.com" and password as "n134" into the fields
And User clicks on Login button
Then Verify user should not able to successfully login
And User should see the error message No match for E-Mail Address and or Password

@loginFour @log
Scenario: Login with invalid Email and valid Password
Given Open any Browser
And Navigate to Login page
When User enters username as "nav@gmail.com" and password as "n1234" into the fields
And User clicks on Login button
Then Verify user should not able to successfully login
And User should see the error message No match for E-Mail Address and or Password

@loginFive @log
Scenario: Login Without any data
Given Open any Browser
And Navigate to Login page
And User clicks on Login button
Then Verify user should not able to successfully login
And User should see the error message No match for E-Mail Address and or Password


@loginSix @log
Scenario: Login with valid Email and skip Password
Given Open any Browser
And Navigate to Login page
When User enters username as "nav@gmail.com"
And User clicks on Login button
Then Verify user should not able to successfully login
And User should see the error message No match for E-Mail Address and or Password

@loginSeven @log
Scenario: Login with Valid Password and skip Email
Given Open any Browser
And Navigate to Login page
When User enters password as "n1234"
And User clicks on Login button
Then Verify user should not able to successfully login
And User should see the error message No match for E-Mail Address and or Password

@loginEight @log
Scenario: Validate Forgotten Password using valid Email
Given Open any Browser
And Navigate to Login page
And Click on Forgotten Password
Then Navigate to Forgotten Password page
When Use enter Vaild Email as "navi@gmail.com"
And Click on continue button
Then Navigate to the Login page
And User should See the message An email with a confirmation link has been sent your email address

@loginNine @log
Scenario: Validate Forgotten Password using invalid Email
Given Open any Browser
And Navigate to Login page
And Click on Forgotten Password
Then Navigate to Forgotten Password page
When Use enter Invaild Email as "arunp@gmail.com"
And Click on continue button
Then User should see the warning message The E-Mail Address was not found in our records, please try again!

@loginTen @log
Scenario: Validate Forgotten Password without providing an email
Given Open any Browser
And Navigate to Login page
And Click on Forgotten Password
Then Navigate to Forgotten Password page
And Click on continue button
Then User should see the warning message The E-Mail Address was not found in our records, please try again!

