package by.paulouskin.etsycucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "by.paulouskin.etsycucumber.stepdefs"
)
public class EtsyComRunner {
}
