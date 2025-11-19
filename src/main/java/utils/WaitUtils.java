package utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final long DEFAULT_WAIT_TIME = 15;
	private static WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeoutSeconds) {
        WaitUtils.driver = driver;
       
    }

    public static WebElement waitForVisibility(By locator) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
    	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

	public static void setDriver(WebDriver driver2) {
		driver = driver2;
		
	}
}
