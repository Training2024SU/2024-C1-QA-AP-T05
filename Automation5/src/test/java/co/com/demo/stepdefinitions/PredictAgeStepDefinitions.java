package co.com.demo.stepdefinitions;

import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PredictAgeStepDefinitions extends SetupService{

    @Then("the response body should contain predicted age")
    public void the_response_body_should_contain_predicted_age() {
        seeThat("The response contains an age key",
                response -> lastResponse().jsonPath().getString("age"),
                notNullValue()
        );
    }

}
