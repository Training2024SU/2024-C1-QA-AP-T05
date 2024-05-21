package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/countries.feature",
        glue = "co.com.sofka.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
