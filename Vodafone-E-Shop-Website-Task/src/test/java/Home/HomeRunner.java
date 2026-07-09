package Home;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "Home",features = "src/test/java/home/home.feature",plugin = {"pretty","html:tsrget/cucumber-html-report"})

public class HomeRunner extends AbstractTestNGCucumberTests {
}
