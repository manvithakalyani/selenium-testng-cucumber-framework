package utils;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pages.MainPage;
import utils.DriverFactory;

/**
 * Unit test for simple App.
 */
public class BaseClass
    
{
   
	    private WebDriver driver;
	    private MainPage main;
	   
	    
	    @Before
	    public void setUp() {
	        // Initialize WebDriver (launch browser)
	        driver = DriverFactory.initDriver("chrome");
	        main = new MainPage(driver);
	    }

	    public void launch() throws InterruptedException {
	        driver.get("http://demowebshop.tricentis.com/");
	        Thread.sleep(2000);
	        System.out.println("Title: " + main.getPageTitle());
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	}
	
