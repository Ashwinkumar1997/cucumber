Feature: Customers

Scenario: Add a new Customer

Given User launch the browser
When User opens URL "https://admin-demo.nopcommerce.com/login" 
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then User can veiw Dashboard
When User click on customer Menu
And Click on customer menu item
And Click on add new button
Then User can view add new customer page
When User enters customer info
And Click on save button
Then User can view confirmation massage "The new customer has been added successfully."
And Close browser