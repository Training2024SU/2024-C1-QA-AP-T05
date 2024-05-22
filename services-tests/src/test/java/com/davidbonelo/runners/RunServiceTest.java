package com.davidbonelo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.davidbonelo.stepdefinitions",
        plugin = "pretty",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@service"
)
public class RunServiceTest {
}
