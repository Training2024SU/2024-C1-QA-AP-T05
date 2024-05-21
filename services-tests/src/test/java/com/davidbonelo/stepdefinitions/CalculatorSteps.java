package com.davidbonelo.stepdefinitions;

import com.davidbonelo.actions.DoSoap;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static com.davidbonelo.Constants.CALCULATOR_BASE;
import static com.davidbonelo.Constants.CALCULATOR_ENDPOINT;
import static com.davidbonelo.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorSteps {

    @Given("the user can access the calculator service")
    public void theUserCanAccessTheCalculatorService() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(CALCULATOR_BASE)));
    }

    @When("{actor} requests to sum {int} plus {int}")
    public void actorRequestsToSumPlus(Actor actor, int num1, int num2) {
        String bodyFormat = readFile("src/test/resources/payloads/sum.xml");
        String body = String.format(bodyFormat, num1, num2);
        actor.attemptsTo(
                DoSoap.request()
                        .to(CALCULATOR_ENDPOINT)
                        .withHeaders(Map.of("SOAPAction", "http://tempuri.org/Add"))
                        .withBody(body)
        );
    }

    @Then("{actor} gets {int} as sum response")
    public void sheGetsAsSumResponse(Actor actor, int result) {
        actor.should(
                seeThatResponse(response -> response
                        .statusCode(200)
                        .body("Envelope.Body.AddResponse.AddResult", equalTo(result + ""))
                )
        );
    }

    @When("{actor} requests to divide {int} by {int}")
    public void actorRequestsToDivideBy(Actor actor, int num1, int num2) {
        String bodyFormat = readFile("src/test/resources/payloads/divide.xml");
        String body = String.format(bodyFormat, num1, num2);
        actor.attemptsTo(
                DoSoap.request()
                        .to(CALCULATOR_ENDPOINT)
                        .withHeaders(Map.of("SOAPAction", "http://tempuri.org/Divide"))
                        .withBody(body)
        );
    }

    @Then("{actor} gets {int} as divide response")
    public void sheGetsAsDivideResponse(Actor actor, int result) {
        actor.should(
                seeThatResponse(response -> response
                        .statusCode(200)
                        .body("Envelope.Body.DivideResponse.DivideResult",
                                equalTo(result + ""))
                )
        );
    }

    @When("{actor} requests to subtract {int} from {int}")
    public void actorRequestsToSubtractFrom(Actor actor, int num1, int num2) {
        String bodyFormat = readFile("src/test/resources/payloads/subtract.xml");
        String body = String.format(bodyFormat, num2, num1);
        actor.attemptsTo(
                DoSoap.request()
                        .to(CALCULATOR_ENDPOINT)
                        .withHeaders(Map.of("SOAPAction", "http://tempuri.org/Subtract"))
                        .withBody(body)
        );
    }

    @Then("{actor} gets {int} as subtract response")
    public void heGetsAsSubtractResponse(Actor actor, int result) {
        actor.should(
                seeThatResponse(response -> response
                        .statusCode(200)
                        .body("Envelope.Body.SubtractResponse.SubtractResult",
                                equalTo(result + ""))
                )
        );
    }

    @When("{actor} requests to multiply {int} times {int}")
    public void actorRequestsToMultiplyTimes(Actor actor, int num1, int num2) {
        String bodyFormat = readFile("src/test/resources/payloads/multiply.xml");
        String body = String.format(bodyFormat, num1, num2);
        actor.attemptsTo(
                DoSoap.request()
                        .to(CALCULATOR_ENDPOINT)
                        .withHeaders(Map.of("SOAPAction", "http://tempuri.org/Multiply"))
                        .withBody(body)
        );
    }

    @Then("{actor} gets {int} as multiply response")
    public void sheGetsAsMultiplyResponse(Actor actor, int result) {
        actor.should(
                seeThatResponse(response -> response
                        .statusCode(200)
                        .body("Envelope.Body.MultiplyResponse.MultiplyResult",
                                equalTo(result + ""))
                )
        );
    }
}
