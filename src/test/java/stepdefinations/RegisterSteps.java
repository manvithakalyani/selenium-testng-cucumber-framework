package stepdefinations;

import org.openqa.selenium.WebDriver;

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

	    @Given("user is on tricentis registration page")
	    public void user_is_on_registration_page() {
	        driver.get("https://demowebshop.tricentis.com/register");
	        // Generate random data before filling form
	        firstName = RandomDataGenerator.getRandomFirstName();
	        lastName = RandomDataGenerator.getRandomLastName();
	        email = RandomDataGenerator.getRandomEmail();
	        password = RandomDataGenerator.getRandomPassword();
	    }

	    @When("user selects gender as {string}")
	    public void user_selects_gender(String gender) {
	        regPage.selectGender(gender);
	    }

	    @When("user enters first name as {string}")
	    public void user_enters_first_name(String ignored) {
	        regPage.enterFirstName(firstName);
	    }

	    @When("user enters last name as {string}")
	    public void user_enters_last_name(String ignored) {
	        regPage.enterLastName(lastName);
	    }

	    @When("user enters email as {string}")
	    public void user_enters_email(String ignored) {
	        regPage.enterEmail(email);
	    }

	    @When("user enters password as {string}")
	    public void user_enters_password(String ignored) {
	        regPage.enterPassword(password);
	    }

	    @When("user enters confirm password as {string}")
	    public void user_enters_confirm_password(String ignored) {
	        regPage.enterConfirmPassword(password);
	    }

	    @When("user clicks the Register button")
	    public void user_clicks_register() {
	        regPage.clickRegisterButton();
	    }

	    @Then("registration success message is displayed")
	    public void registration_success_message() {
	        boolean result = regPage.isRegistrationSuccessMessageDisplayed();
	        assert result : "Registration success message was not displayed!";
	    }
}
