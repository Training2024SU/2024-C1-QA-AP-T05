package com.davidbonelo.stepdefinitions;

import com.davidbonelo.actions.DoSoap;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.davidbonelo.Constants.DAE_BASE;
import static com.davidbonelo.Constants.ISBN_ENDPOINT;
import static com.davidbonelo.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class IsbnSteps {

    @Given("the user can access the validator service")
    public void theUserCanAccessTheValidatorService() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(DAE_BASE)));
    }

    @When("{actor} requests the validation of the {string} isbn")
    public void actorRequestsTheValidationOfTheIsbn(Actor actor, String isbn) {
        String bodyFormat = readFile("src/test/resources/payloads/isbn.xml");
        String body = String.format(bodyFormat, isbn);
        actor.attemptsTo(
                DoSoap.request()
                        .to(ISBN_ENDPOINT)
                        .withBody(body)
        );
    }

    @Then("{actor} should get a response with code {int}")
    public void heShouldGetAResponseWithCode(Actor actor, int responseCode) {
        actor.should(
                seeThatResponse(
                        response -> response.statusCode(responseCode)
                )
        );
    }

    @And("{actor} should get is {string} as response")
    public void heShouldGetIsAsResponse(Actor actor, String result) {
        String responsePath = "Envelope.Body.IsValidISBN13Response.IsValidISBN13Result";
        actor.should(
                seeThatResponse(
                        response -> response
                                .body(responsePath, equalTo(result))
                )
        );
    }
}
