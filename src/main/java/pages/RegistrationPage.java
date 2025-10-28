package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	  private WebDriver driver;

	    // Locators
	    private By genderMaleRadio = By.id("gender-male");
	    private By genderFemaleRadio = By.id("gender-female");
	    private By firstNameInput = By.id("FirstName");
	    private By lastNameInput = By.id("LastName");
	    private By emailInput = By.id("Email");
	    private By passwordInput = By.id("Password");
	    private By confirmPasswordInput = By.id("ConfirmPassword");
	    private By registerButton = By.id("register-button");
	    private By registrationSuccessMessage = By.cssSelector(".result");

	    // Constructor
	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Methods to interact with elements

	    public void selectGender(String gender) {
	        if (gender.equalsIgnoreCase("male")) {
	            driver.findElement(genderMaleRadio).click();
	        } else if (gender.equalsIgnoreCase("female")) {
	            driver.findElement(genderFemaleRadio).click();
	        }
	    }

	    public void enterFirstName(String firstName) {
	        driver.findElement(firstNameInput).sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        driver.findElement(lastNameInput).sendKeys(lastName);
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailInput).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordInput).sendKeys(password);
	    }

	    public void enterConfirmPassword(String confirmPassword) {
	        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
	    }

	    public void clickRegisterButton() {
	        driver.findElement(registerButton).click();
	    }

	    public boolean isRegistrationSuccessMessageDisplayed() {
	        return driver.findElement(registrationSuccessMessage).isDisplayed();
	    }

	    public String getRegistrationSuccessMessage() {
	        return driver.findElement(registrationSuccessMessage).getText();
	    }
}
