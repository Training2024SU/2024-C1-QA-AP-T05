package osorio.alvarez.devon.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import osorio.alvarez.devon.model.listUser.DataItem;
import osorio.alvarez.devon.questions.ResponseCode;
import osorio.alvarez.devon.questions.VerifyResponseContainsText;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static osorio.alvarez.devon.tasks.DoGet.doGet;

public class GetStepDefinition extends SetupService {
    DataItem dataItem = new DataItem();
    @Given("que el usuario se encuentra en la pagina de {string}")
    public void queElUsuarioSeEncuentraEnLaPaginaDe(String baseUrl) {
        setupService(baseUrl);
    }

    @When("manda una peticion de tipo get al recurso {string}")
    public void manda_una_peticion_de_tipo_get_al_recurso(String recurso) {
        actor.attemptsTo(
                doGet().withTheResource(recurso)
        );
    }

    @Then("deberia observar un codigo de respuesta {int}")
    public void deberiaObservarUnCodigoDeRespuesta(Integer statusCode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statusCode)
                )
        );
    }
    @Then("deberia obtener una lista de usuarios")
    public void deberia_obtener_una_lista_de_usuarios() {
        actor.should(
                seeThat("la respuesta contiene al usuario", VerifyResponseContainsText.containsText("Michael").asString())

        );
    }
}

