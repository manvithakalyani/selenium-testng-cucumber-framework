

Feature:  Tricentis Demo Web Shop Registration

Background:
  Given user is on tricentis page
 
 
 Scenario: Sample tricentis page
  
  

Scenario Outline: Register new random user with gender <gender>
 
  When user clicks the Register menu
    And user is on tricentis registration page
    And user selects gender as "<gender>"
    And user enters first name as "<firstName>"
    And user enters last name as "<lastName>"
    And user enters email as "<email>"
    And user enters password as "<password>"
    And user enters confirm password as "<password>"
    And user clicks the Register button
    Then registration success message is displayed
  

Examples:
  | gender | firstName | lastName | email | password |
  | Male | placeholder | placeholder | placeholder | placeholder |
  | Female | placeholder | placeholder | placeholder | placeholder |
  
  
  
  Scenario: Registration fails when mandatory fields are missing
  Given user clicks the Register menu
    And user is on tricentis registration page
  When user clicks the Register button without filling any fields
  Then appropriate error messages for missing fields are displayed
  
  
  Scenario: Registration fails with invalid email
  When user clicks the Register menu
  And user is on tricentis registration page
  And user selects gender as "Male"
  And user enters first name as "Invalid"
  And user enters last name as "Email"
  And user enters email as "invalidemail"
  And user enters password as "Pass@123"
  And user enters confirm password as "Pass@123"
  And user clicks the Register button
  Then error message "wrong email" is displayed
  
  
  Scenario: Registration fails with duplicate email
  When user clicks the Register menu
  And user is on tricentis registration page
  And user selects gender as "Male"
  And user enters first name as "John"
  And user enters last name as "Doe"
  And user enters email as "bgfdt@example.com"
  And user enters password as "Pass@123"
  And user enters confirm password as "Pass@123"
  And user clicks the Register button
  Then error message "The specified email already exists" is displayed
  
 
 Scenario: Successful login with valid credentials
    Given user is on the Demo Web Shop login page
    When user enters username as "bgfdt@example.com"
    And user enters password as "Pass@123"
    And user clicks the Login button
    Then login success message is displayed
    
  
  Scenario: Login with existing registered user
  Given user is on the Demo Web Shop login page
   When user logs in with registered credentials
  And user clicks the Login button
  Then login success message is displayed
  
  
  Scenario: unSuccessful login with blank credentials
    Given user is on the Demo Web Shop login page
    When user enters username as ""
    And user enters password as ""
    And user clicks the Login button
    Then login failed     
    
    
    Scenario: Login fails for invalid user name and password
    Given user is on the Demo Web Shop login page
    When user enters username as "abc@example.com"
    And user enters password as "ValidPass123"
    And user clicks the Login button
    Then error message "the credentials provided are incorrect" is displayed
