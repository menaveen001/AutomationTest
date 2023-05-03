Feature: Register functionality
@register @reg1
Scenario: Validate Register an Account by providing only the Mandatory fields
Given Open the appliction in any Browser

And Click on My Account Drop menu
And Clicked on Register option
When Enter the below data new Account Details into the Mandatory Fields 

|firstName		|Arun								|
|lastName			|Pal								|
|email				|arun46524@gmail.com|
|telephone		|123456							|
|password			|second@123					|

And Select Privacy Policy Fields
And Click on Continue button
Then User should be loged in taken to Account Success page and proper details should be displayed on the page
And Click on Continue button that is displayed in the Account Success page
Then User should be loged in taken to Account Success page and a confirm email should be sent to the register email address

@register @reg2
Scenario: Validate Register an Account by providing all fields
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter the below data new Account Details into the Mandatory Fields 

|firstName		|Arun								|
|lastName			|Pal								|
|email				|arun46524@gmail.com|
|telephone		|123456							|
|password			|second@123					|

And Select Newsletter Subscribe Fields
And Select Privacy Policy Fields
And Click on Continue button
Then User should be loged in taken to Account Success page and proper details should be displayed on the page
And Click on Continue button that is displayed in the Account Success page

@register @reg3
Scenario: Validate Register an Account by providing all fields but not select Privacy Policy
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter the below data new Account Details into the Mandatory Fields 

|firstName		|Arun								|
|lastName			|Pal								|
|email				|arun46524@gmail.com|
|telephone		|123456							|
|password			|second@123					|
And Select Newsletter Subscribe Fields
And Click on Continue button
Then Account shoud not created
And User should see Warning message You must agree to the Privacy policy

@register @reg4
Scenario: Validate Register an Account by skipping all the Mandatory fields
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
And Click on Continue button
Then User should see Warning message You must agree to the Privacy policy
And User should see the error messgae informing the user to fill the mandatory fields

@register @reg5
Scenario: Validate Register an account by providing all the Mandatory fields but skiped the First name
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter new Account Details into the Mandatory Fields the below data but skip firstName
|lastName			|Pal								|
|email				|arun46524@gmail.com|
|telephone		|123456							|
|password			|second@123					|
And Select Newsletter Subscribe Fields
And Select Privacy Policy Fields
And Click on Continue button
Then Account shoud not created
And User should see the Warning message to fill the First name


@register @reg6
Scenario: Validate Register an account by providing all the Mandatory fields but skiped the Last name
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter new Account Details into the Mandatory Fields the below data but skip lastName
|firstName			|Arun								|
|email					|arun46524@gmail.com|
|telephone			|123456							|
|password				|second@123					|
And Select Newsletter Subscribe Fields
And Select Privacy Policy Fields
And Click on Continue button
Then Account shoud not created
And User should see the Warning message to fill the Last name

@register @reg7
Scenario: Validate Register an account by providing all the Mandatory fields but skiped the Email
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter new Account Details into the Mandatory Fields the below data but skip Email
|firstName			|Arun								|
|lastName			|Pal								|
|telephone		|123456							|
|password			|second@123					|
And Select Newsletter Subscribe Fields
And Select Privacy Policy Fields
And Click on Continue button
Then Account shoud not created
And User should see the Warning message to fill the Email

@register @reg8
Scenario: Validate Register an account by providing all the Mandatory fields but skiped the Telephone
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter new Account Details into the Mandatory Fields the below data but skip Telephone
|firstName			|Arun								|
|lastName			  |Pal								|
|email					|arun46524@gmail.com|
|password			  |second@123					|
And Select Newsletter Subscribe Fields
And Select Privacy Policy Fields
And Click on Continue button
Then Account shoud not created
And User should see the Warning message to fill the Telephone

@register @reg9
Scenario: Validate Register an account by providing all the Mandatory fields but skiped the Password
Given Open the appliction in any Browser
And Click on My Account Drop menu
And Clicked on Register option
When Enter new Account Details into the Mandatory Fields the below data but skip Password
|firstName			|Arun								|
|lastName			  |Pal								|
|email					|arun46524@gmail.com|
|telephone			|123456							|
And Select Newsletter Subscribe Fields
And Select Privacy Policy Fields
And Click on Continue button
Then Account shoud not created
And User should see the Warning message to fill the Password

