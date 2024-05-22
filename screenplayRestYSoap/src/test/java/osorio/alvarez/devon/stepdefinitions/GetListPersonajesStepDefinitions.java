package osorio.alvarez.devon.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import osorio.alvarez.devon.questions.ResponseCode;
import osorio.alvarez.devon.questions.VerifyResponseContainsText;


import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static osorio.alvarez.devon.tasks.EnviarPeticionGet.enviarPeticionGet;

public class GetListPersonajesStepDefinitions extends SetupService {

    @When("realiza una peticion de tipo get al recurso {string}")
    public void realizaUnaPeticionDeTipoGetAlRecurso(String resource) {
        actor.attemptsTo(
                enviarPeticionGet().conRecurso(resource)
        );
    }

    @Then("deberia ver un codigo de respuesta {int}")
    public void deberiaVerUnCodigoDeRespuesta(Integer statusCode) {
        actor.should(
                seeThat("El codigo de respuesta",
                        ResponseCode.was(),equalTo(statusCode))
        );
        lastResponse().body().print();
    }

    @Then("deberia obtener una lista de personajes")
    public void deberiaObtenerUnaListaDePersonajes() {
        actor.should(
                seeThat("la respuesta contiene el personaje", VerifyResponseContainsText.containsText("Rogue").asString())

        );
    }

}
