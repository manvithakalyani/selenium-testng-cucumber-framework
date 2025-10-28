package stepdefinations;


import io.cucumber.java.en.Given;
import utils.BaseClass;

public class Mainpagestepdef {
	 BaseClass appTest = new BaseClass();
	@Given("user is on tricentis page")
    public void user_is_on_login_page() throws InterruptedException {
		    appTest.setUp();
	        appTest.launch();
	       
    }

}
