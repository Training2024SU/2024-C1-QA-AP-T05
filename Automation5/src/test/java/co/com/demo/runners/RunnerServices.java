package co.com.demo.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "/home/dan/Desktop/2024-C1-QA-AP-T05/Automation5/src/test/resources/features",
        glue = "co.com.demo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerServices {
}
