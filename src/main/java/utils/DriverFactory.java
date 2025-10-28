package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	 private static WebDriver driver;

	    public static WebDriver initDriver(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }
	        // You can add Firefox, Edge etc. here

	        driver.manage().window().maximize();
	        return driver;
	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }
}
