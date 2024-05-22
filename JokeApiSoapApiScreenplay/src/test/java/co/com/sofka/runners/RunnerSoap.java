package co.com.sofka.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@soap",
        features = {"src/test/resources/features/"},
        glue = {"co.com.sofka.stepdefinitions.soapservices"}
)
public class RunnerSoap {
}
