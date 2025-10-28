package pages;

import org.openqa.selenium.WebDriver;

public class MainPage {
	  private WebDriver driver;

	    public MainPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public String getPageTitle() {
	        return driver.getTitle();
	    }
}
