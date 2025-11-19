package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinations.RegisterSteps; 

import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    String email = RegisterSteps.storedEmail;
    String password = RegisterSteps.storedPassword;

    @Given("user is on the Demo Web Shop login page")
    public void user_is_on_login_page() {
        loginPage.clickLoginLink();
    }
    
    @When("user enters username as {string}")
    public void user_enters_username(String username) {
        loginPage.enterEmail(username);
    }


    
    @When("user logs in with registered credentials")
    public void user_logs_in_with_registered_credentials() {
        loginPage.enterEmail(RegisterSteps.storedEmail);
        loginPage.enterPassword(RegisterSteps.storedPassword);
    }

    @And("user clicks the Login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

 
    
    @Then("login success message is displayed")
    public void login_success_message_is_displayed() {
        String actualUsername = loginPage.getLoggedInUsername();  // this should do the waiting
        System.out.println("actual: " + actualUsername);
        Assert.assertNotNull(actualUsername, "Login success username is not displayed.");
    }

    @Then("login failed")
    public void login_failed() {
        // Example: check for error message element visibility and text
        String errorMessage = loginPage.getLoginErrorMessage();
        System.out.println("Login error message: " + errorMessage);
        
        Assert.assertTrue(errorMessage != null && !errorMessage.isEmpty(), "Expected login error message not displayed.");
        
        // Optionally check exact error text, e.g.
        Assert.assertTrue(errorMessage.contains("unsuccessful") || errorMessage.contains("incorrect") || errorMessage.contains("No customer account"), 
            "Unexpected error message text: " + errorMessage);
    }

}
    
