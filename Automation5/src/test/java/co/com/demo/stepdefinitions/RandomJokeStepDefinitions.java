package co.com.demo.stepdefinitions;

import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RandomJokeStepDefinitions extends SetupService {

    @Then("the response body should contain a joke")
    public void theResponseBodyShouldContainAJoke() {
        actor.should(
                seeThat("The response contains a type key",
                        response -> lastResponse().jsonPath().getString("type"),
                        notNullValue()
                ),
                seeThat("The response contains a setup key",
                        response -> lastResponse().jsonPath().getString("setup"),
                        notNullValue()
                ),
                seeThat("The response contains a punchline key",
                        response -> lastResponse().jsonPath().getString("punchline"),
                        notNullValue()
                ),
                seeThat("The response contains an id key",
                        response -> lastResponse().jsonPath().getInt("id"),
                        notNullValue()
                )
        );
    }


}
