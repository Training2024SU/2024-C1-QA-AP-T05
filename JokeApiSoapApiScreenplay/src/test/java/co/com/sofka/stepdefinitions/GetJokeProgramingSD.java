package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.sofka.questions.ObtenerRespuesta.obtenerRespuesta;
import static co.com.sofka.utils.util.bodyOfTheResponse;
import static co.com.sofka.utils.util.printJoke;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetJokeProgramingSD extends SetupService{

    @Given("the user is in the webpage Joke Api")
    public void theUserIsInTheWebpageJokeApi() {
        setUpService("https://v2.jokeapi.dev/");
    }

    @When("sent a GET petition to the resource {string} of the category {string}")
    public void sentAGETPetitionToTheResourceOfTheCategory(String resource, String category) {
        actor.attemptsTo(
                Get.resource(resource)
        );
    }

    @Then("it should be able to see the information of the joke about programing")
    public void itShouldBeAbleToSeeTheInformationOfTheJokeAboutPrograming() {
        bodyOfTheResponse(actor);
        printJoke(actor);
        actor.should(
                seeThat(obtenerRespuesta().delCampo("category"),(equalTo("Programming")))
        );
    }
}
