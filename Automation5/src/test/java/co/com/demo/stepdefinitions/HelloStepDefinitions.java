package co.com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelloStepDefinitions {
    @Given("the Hello service is available")
    public void theHelloServiceIsAvailable() {

    }
    @When("the user sends a request with {string}")
    public void theUserSendsARequestWith(String string) {

    }
    @Then("I should receive a greeting with the name")
    public void iShouldReceiveAGreetingWithTheName() {

    }

}
