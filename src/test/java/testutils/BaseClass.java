package testutils;


import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.DriverManager;

 
public class BaseClass extends BaseTest
    
{
   
	    protected WebDriver driver;
	    protected MainPage main;
	    
	    public BaseClass() {
	        this.driver = DriverManager.getDriver(); // get initialized driver
	        if (this.driver != null) {
	            this.main = new MainPage(driver);  // initialize the page object here
	        }
	    }
	    public void launch() throws InterruptedException {
	    	if (driver == null) {
	            throw new IllegalStateException("Driver not initialized! Cannot launch page.");
	        }
	        driver.get("http://demowebshop.tricentis.com/");
	        Thread.sleep(2000);
	        System.out.println("Title: " + main.getPageTitle());
	     // Use logInfo from BaseTest
	        logInfo("Browser launched and MainPage initialized");
	    }


	}
	
