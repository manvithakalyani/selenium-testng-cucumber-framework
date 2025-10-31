package stepdefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testutils.BaseClass;

public class Mainpagestepdef extends BaseClass{
	 BaseClass appTest = new BaseClass();
	 
	@Given("user is on tricentis page")
    public void user_is_on_login_page() throws InterruptedException {
		    
	        appTest.launch();
	       
    }
	/* @Then("close after landing on page")
    public void closeBrowser() {
        Hooks.tearDown();   // Calls the tearDown method which quits the driver
    }  */

}
