package stepdefinations;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.DriverManager;
import utils.ExtentReportsUtil;
import utils.ExtentTestManager;

public class Hooks {
	
	@BeforeAll // or use TestNG @BeforeClass, or Cucumber @Before with order=0 if supported
	public static void setupExtent() {
	    ExtentReportsUtil.initializeExtentReports();
	}
	
    @Before
    public void setUp(Scenario scenario) {
     //   DriverFactory.initDriver("chrome");
      //  DriverManager.getDriver();
    	// DriverManager.setDriver(DriverFactory.initDriver("chrome"));
    	 WebDriver driver = DriverFactory.initDriver("chrome");
    	    DriverManager.setDriver(driver);
        ExtentTestManager.startTest("Scenario: " + scenario.getName());
    }

    @After
    public static void tearDown() {
       if(DriverManager.getDriver() != null) {
          DriverManager.getDriver().quit();
       }
    }
    
    @AfterAll
    public static void tearDownAll() {
        ExtentReportsUtil.flushExtentReports();
    }
}