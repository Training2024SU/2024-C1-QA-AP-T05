package co.com.demo.stepdefinitions;

import co.com.demo.questions.ResponseCode;
import co.com.demo.tasks.DoGet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CatsFactsStepDefinitions extends SetupService {

    @Given("the user is on the {string} in page")
    public void theUserIsOnTheInPage(String string) {
      setupService(string);
    }

    @When("I make a GET request to {string}")
    public void iMakeAGETRequestTo(String url) {
        actor.attemptsTo(
                DoGet.doGet().withTheResource(url)
        );
    }

    @Then("the server should respond with a status code of {int} \\(OK)")
    public void theServerShouldRespondWithAStatusCodeOfOK(Integer code) {
        actor.should(
                seeThat("Code", ResponseCode.was(), equalTo(code))
        );

    }

    @Then("the response body should contain a cat fact")
    public void theResponseBodyShouldContainACatFact() {
        actor.should(
                seeThat("The response contains a fact key",
                        response -> lastResponse().jsonPath().getString("fact"),
                        notNullValue()
                ),
                seeThat("The response contains a length key",
                        response -> lastResponse().jsonPath().getInt("length"),
                        notNullValue()
                )
        );
    }

}
