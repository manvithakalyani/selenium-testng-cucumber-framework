package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import testutils.BaseClass;

import utils.DriverManager;
import utils.RandomDataGenerator;
import utils.WaitUtils;

public class RegisterSteps extends BaseClass  {
	 WebDriver driver = DriverManager.getDriver();
	    RegistrationPage regPage = new RegistrationPage(driver);

	    String firstName, lastName, email, password;
	    private String generatedPassword;

	    
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
	        if (input.equals("placeholder")) {
	            generatedPassword = RandomDataGenerator.getRandomPassword();
	            regPage.enterPassword(generatedPassword);
	            logInfo("Entered password as generated value: " + generatedPassword);

	        } else {
	            regPage.enterPassword(input);
	            generatedPassword = input;
	            logInfo("Entered password as: " + input);
	        }
	    }

	    @And("user enters confirm password as {string}")
	    public void user_enters_confirm_password(String input) {
	        if (input.equals("placeholder")) {
	            // Use the same generated password, not a new one
	            regPage.enterConfirmPassword(generatedPassword);
	            logInfo("Entered confirm password as generated value: " + generatedPassword);
	            
	        } else {
	            regPage.enterConfirmPassword(input);
	            logInfo("Entered confirm password as: " + input);
	        }
	    }
	    @And("user clicks the Register button")
	    public void user_clicks_register() {
	        regPage.clickRegisterButton();
	        logInfo("Clicked the Register button");
	    }

	    @Then("registration success message is displayed")
	    public void registration_success_message() {
	    	 WaitUtils waitUtils = new WaitUtils(driver, 10);
	    	    boolean result;
	    	    try {
	    	        WebElement successMsg = waitUtils.waitForVisibility(By.cssSelector(".result"));
	    	        result = successMsg.isDisplayed();
	    	        logPass("Registration success message was displayed.");
	    	    } catch (TimeoutException e) {
	    	        result = false;
	    	        logFail("Registration success message was NOT displayed.");
	    	    }
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
	        	logPass("Error message '" + expectedMessage + "' appeared as expected.");
	            
	        }
	        else {
	            logFail("Expected error message '" + expectedMessage + "' not found. Actual: " + actualMessage);
	            throw new AssertionError("Expected error message containing: '" + expectedMessage + "' or 'Wrong email', but found: '" + actualMessage + "'");
	        }
	    }
	    
	   
}
