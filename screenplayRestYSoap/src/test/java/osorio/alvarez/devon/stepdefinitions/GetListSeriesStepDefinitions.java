package osorio.alvarez.devon.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import osorio.alvarez.devon.questions.ResponseCode;
import osorio.alvarez.devon.questions.VerifyResponseContainsText;
import osorio.alvarez.devon.utils.ConstantApi;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static osorio.alvarez.devon.tasks.EnviarPeticionGet.enviarPeticionGet;
import static osorio.alvarez.devon.utils.ConstantApi.*;

public class GetListSeriesStepDefinitions extends SetupService {
    String endpoint = BASE_URL + ConstantApi.PATH;

    @Given("que el usuario esta en la pagina de {string}")
    public void queElUsuarioEstaEnLaPaginaDe(String urlBase) {
        setupService(urlBase);
    }

    @When("envia una peticion de tipo get al recurso {string}")
    public void enviaUnaPeticionDeTipoGetAlRecurso(String resource) {
        actor.attemptsTo(
                enviarPeticionGet().conRecurso(resource)
        );
    }

    @Then("deberia obtener un codigo de respuesta {int}")
    public void deberiaObtenerUnCodigoDeRespuesta(Integer statusCode) {
        actor.should(
                seeThat("El codigo de respuesta",
                        ResponseCode.was(),equalTo(statusCode))
        );
        lastResponse().body().print();
    }

    @Then("deberia obtener una lista de los comics")
    public void deberia_obtener_una_lista_de_los_comics() {
        actor.should(
                seeThat("la respuesta contiene el texto esperado", VerifyResponseContainsText.containsText("story from Amazing Spider").asString())

        );
    }
}
