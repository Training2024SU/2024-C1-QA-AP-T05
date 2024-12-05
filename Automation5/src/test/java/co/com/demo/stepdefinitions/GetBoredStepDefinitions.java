package co.com.demo.stepdefinitions;

import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetBoredStepDefinitions extends SetupService {

    @Then("the response body should contain an activity")
    public void theResponseBodyShouldContainAnActivity() {
        actor.should(
                seeThat("The response contains an activity key",
                        response -> lastResponse().jsonPath().getString("activity"),
                        notNullValue()
                ),
                seeThat("The response contains a type key",
                        response -> lastResponse().jsonPath().getString("type"),
                        notNullValue()
                ),
                seeThat("The response contains a participants key",
                        response -> lastResponse().jsonPath().getInt("participants"),
                        notNullValue()
                ),
                seeThat("The response contains a price key",
                        response -> lastResponse().jsonPath().getFloat("price"),
                        notNullValue()
                ),
                seeThat("The response contains a link key",
                        response -> lastResponse().jsonPath().getString("link"),
                        notNullValue()
                ),
                seeThat("The response contains a key key",
                        response -> lastResponse().jsonPath().getString("key"),
                        notNullValue()
                ),
                seeThat("The response contains an accessibility key",
                        response -> lastResponse().jsonPath().getFloat("accessibility"),
                        notNullValue()
                )
        );
    }

}
