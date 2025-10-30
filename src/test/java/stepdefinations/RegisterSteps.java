package stepdefinations;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utils.DriverFactory;
import utils.RandomDataGenerator;

public class RegisterSteps {
	 WebDriver driver = DriverFactory.getDriver();
	    RegistrationPage regPage = new RegistrationPage(driver);

	    String firstName, lastName, email, password;
	    
	    @When("user clicks the Register menu")
	    public void user_clicks_register_menu() {
	        regPage.clickRegisterMenuLink();
	    }

	    @And("user is on tricentis registration page")
	    public void user_is_on_registration_page() {
	    	 String url = driver.getCurrentUrl();
	    	    if (!url.endsWith("/register")) {
	    	        throw new AssertionError("User is NOT on the registration page. Current URL: " + url);
	    	    }
	        
	    }
	    
	    @And("user selects gender as {string}")
	    public void user_selects_gender(String gender) {
	        regPage.selectGender(gender);
	    }
	    @And("user enters first name as {string}")
	    public void user_enters_first_name(String input) {
	        String valueToEnter = input.equals("placeholder") ? RandomDataGenerator.getRandomFirstName() : input;
	        regPage.enterFirstName(valueToEnter);
	    }

	    @And("user enters last name as {string}")
	    public void user_enters_last_name(String input) {
	        String valueToEnter = input.equals("placeholder") ? RandomDataGenerator.getRandomLastName() : input;
	        regPage.enterLastName(valueToEnter);
	    }

	    @And("user enters email as {string}")
	    public void user_enters_email(String input) {
	        String valueToEnter = input.equals("placeholder") ? RandomDataGenerator.getRandomEmail() : input;
	        regPage.enterEmail(valueToEnter);
	    }

	    @And("user enters password as {string}")
	    public void user_enters_password(String input) {
	        String valueToEnter = input.equals("placeholder") ? RandomDataGenerator.getRandomPassword() : input;
	        regPage.enterPassword(valueToEnter);
	    }

	    @And("user enters confirm password as {string}")
	    public void user_enters_confirm_password(String input) {
	        String valueToEnter = input.equals("placeholder") ? RandomDataGenerator.getRandomPassword() : input;
	        regPage.enterConfirmPassword(valueToEnter);
	    }
	    @And("user clicks the Register button")
	    public void user_clicks_register() {
	        regPage.clickRegisterButton();
	    }

	    @Then("registration success message is displayed")
	    public void registration_success_message() {
	        boolean result = regPage.isRegistrationSuccessMessageDisplayed();
	        assert result : "Registration success message was not displayed!";
	    }
	    
	   
	    
	    @When("user clicks the Register button without filling any fields")
	    public void user_clicks_register_without_filling_fields() {
	        regPage.clickRegisterButton();
	    }

	    @Then("appropriate error messages for missing fields are displayed")
	    public void appropriate_error_messages_displayed() {
	        boolean missingFieldsErrorsPresent = regPage.areErrorMessagesDisplayedForMissingFields();
	        if (!missingFieldsErrorsPresent) {
	            throw new AssertionError("Error messages for missing fields were not displayed");
	        }
	    }
	    
	    @Then("error message {string} is displayed")
	    public void error_message_is_displayed(String expectedMessage) {
	        String actualMessage = regPage.getErrorMessage().toLowerCase();
	        String expectedLower = expectedMessage.toLowerCase();

	        // Accept either the expected message or "wrong email"
	        if (!(actualMessage.contains(expectedLower) || actualMessage.contains("wrong email"))) {
	            throw new AssertionError("Expected error message containing: '" + expectedMessage + "' or 'Wrong email', but found: '" + actualMessage + "'");
	        }
	    }

}
