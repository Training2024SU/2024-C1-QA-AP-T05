package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.sofka.questions.ObtenerRespuesta.obtenerRespuesta;
import static co.com.sofka.utils.util.bodyOfTheResponse;
import static co.com.sofka.utils.util.printJoke;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetOneJokeEnglishSD extends SetupService{

    @Given("the user is in the web page Joke Api english")
    public void theUserIsInTheWebPageJokeApiEnglish() {
        setUpService("https://v2.jokeapi.dev/");
    }

    @When("sent a GET petition to the resource {string} of the type {string}")
    public void sentAGETPetitionToTheResourceOfTheType(String resource, String jokeType) {
        actor.attemptsTo(
                Get.resource(resource).with(request->
                        request.queryParam("blacklistFlags", jokeType)
                )
        );
    }

    @Then("it should be able to see the information of the joke in english")
    public void itShouldBeAbleToSeeTheInformationOfTheJokeInEnglish() {
        bodyOfTheResponse(actor);
        printJoke(actor);
        actor.should(
                seeThat(obtenerRespuesta().delCampo("lang"),(equalTo("en")))
        );
    }
}
