package co.com.demo.stepdefinitions;

import co.com.demo.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static co.com.demo.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CatsFactsStepDefinitions extends SetupService {

    @Given("I want to know a random cat fact")
    public void iWantToKnowARandomCatFact() {
        // No implementation needed
    }
    @When("I make a GET request to {string}")
    public void iMakeAGETRequestTo(String string) {
        actor.attemptsTo(
                doGet().withTheResource(string)
        );
    }
    @Then("the server should respond with a status code of {int} \\(OK)")
    public void theServerShouldRespondWithAStatusCodeOfOK(Integer int1) {
        actor.should(
                seeThat("Code", ResponseCode.was(),equalTo(int1))
        );

        System.out.println("Request Body");
        SerenityRest.lastResponse().body().print();
    }
    @Then("the response body should contain a cat fact")
    public void theResponseBodyShouldContainACatFact() {

    }
}



/*
@Then("it should receive a code {int}")
public void it_should_receive_a_code(Integer statusCode) {
    actor.should(
            seeThat("The response code", ResponseCode.was(),equalTo(statusCode))
    );

    System.out.println("Request Body");
    SerenityRest.lastResponse().body().print();

}

 */