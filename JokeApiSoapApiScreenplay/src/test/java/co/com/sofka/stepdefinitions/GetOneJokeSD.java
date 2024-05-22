package co.com.sofka.stepdefinitions;


import co.com.sofka.questions.ResponseCode;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

import static co.com.sofka.questions.ObtenerRespuesta.obtenerRespuesta;
import static co.com.sofka.utils.util.bodyOfTheResponse;
import static co.com.sofka.utils.util.printJoke;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetOneJokeSD extends SetupService{

    @Given("the user is in the web page Joke Api")
    public void the_user_is_in_the_web_page_joke_api() {
        setUpService("https://v2.jokeapi.dev/");

    }
    @When("sent a GET petition to the resource {string}")
    public void sent_a_get_petition_to_the_resource(String resource) {
        actor.attemptsTo(
                Get.resource(resource).with(request->
                        request.queryParam("lang", "es")
                )
        );

    }
    @Then("it should obtain a answer code {int}")
    public void it_should_obtain_a_answer_code(Integer statusCode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statusCode))
        );

    }
    @Then("it should be able to see the information of the joke")
    public void it_should_be_able_to_see_the_information_of_the_joke() {
        bodyOfTheResponse(actor);
        printJoke(actor);
        actor.should(
                seeThat(obtenerRespuesta().delCampo("lang"),(equalTo("es")))
        );
    }
}
