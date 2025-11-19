package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By loginLink = By.cssSelector("a.ico-login");
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By loginButton = By.cssSelector("input.button-1.login-button");
    private By errorMessage = By.cssSelector("div.message-error");
    private By welcomeMessage = By.cssSelector(".header-links .account");
    private By loginErrorMessage = By.cssSelector("div.message-error"); 
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    // Methods to interact with page elements
    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.isDisplayed() ? error.getText() : "";
    }

    public String getLoggedInUsername() {
    	 try {
             WebElement userElement = WaitUtils.waitForVisibility(welcomeMessage);
             return userElement.getText();
         } catch (Exception e) {
             return null; // handle timeout or other exceptions gracefully
         }
     }
    public String getLoginErrorMessage() {
        try {
            return driver.findElement(loginErrorMessage).getText().trim();
        } catch (NoSuchElementException e) {
            return null;  // Return null if the error message element is not found on the page
        }
    }

}
