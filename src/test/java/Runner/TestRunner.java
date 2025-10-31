package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features", // runs all features in that folder
	    glue = "stepdefinations",
	    
	    plugin = {"pretty", "html:target/report.html"}
	)
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
	
	
	
	
	


