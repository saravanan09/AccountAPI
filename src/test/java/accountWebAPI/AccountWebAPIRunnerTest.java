package accountWebAPI;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json" ,
                           "junit:target/cucumber.xml"},
		tags = {}
		)

public class AccountWebAPIRunnerTest {

}
