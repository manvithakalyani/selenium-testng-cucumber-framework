

Feature: Testing tricentis page
 
  @test
  Scenario: Sample tricentis page
    Given user is on tricentis page

  
  @register
Scenario Outline: Register new random user with gender <gender>
  Given user is on tricentis registration page
  When user selects gender as "<gender>"
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
