Feature: Booking a Product
@book
Scenario: Validate Booking a iMac Desktops
Given Open any Browser
And Navigate to Login page
When User enters username as "navi@gmail.com" and password as "n1234" into the fields
And User clicks on Login button
Then Verify user should able to successfully login
And User search for a product as "iMac" and Click on search button
Then User should navigate to search results page and  see the product and clicked on it
And User should naviagte to details page of product and Enter the quantity as "1" and clicked on add to cart
And user should see the success message of add to cart
And User clicked on shopping cart option then user should naviagte to the shopping cart page and clicked on checkout button
And User should navigate to the checkout page 
And User should see the exisiting billing address and clicked on continue button
And user should see the existing Delivery details adress and click on continue button
And user should click on continue button
And User should see the Cash on delivery option and selecte privacy then clicked on continue button
Then User should see the confirm order details and clicked on confirm order
And user should see the confirmation message of booking order 
