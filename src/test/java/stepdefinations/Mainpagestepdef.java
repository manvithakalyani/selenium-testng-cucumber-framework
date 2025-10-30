package stepdefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.BaseClass;

public class Mainpagestepdef {
	 BaseClass appTest = new BaseClass();
	@Given("user is on tricentis page")
    public void user_is_on_login_page() throws InterruptedException {
		    appTest.setUp();
	        appTest.launch();
	       
    }
	@Then("close after landing on page")
    public void closeBrowser() {
        appTest.tearDown();   // Calls the tearDown method which quits the driver
    }

}
