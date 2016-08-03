package accountWebAPI;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {"@GET_billingHistoryValidFields,@GET_billingCallsValidFields"}
		)

public class AccountWebAPIRunnerTest {

}
