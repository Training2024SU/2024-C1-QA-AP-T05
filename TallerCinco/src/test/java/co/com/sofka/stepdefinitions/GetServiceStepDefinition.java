package co.com.sofka.stepdefinitions;

import garcia.juan.questions.ObtenerInfo;
import garcia.juan.questions.services.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import static garcia.juan.questions.ObtenerInfo.obtenerInfo;
import static garcia.juan.questions.services.ReturnResponse.returnResponse;
import static garcia.juan.tasks.services.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetServiceStepDefinition extends SetupService{

    @Given("el usuario tiene acceso al servicio de place holder")
    public void queElUsuarioEstaEnLaPaginaDe() {
        setupService("https://jsonplaceholder.typicode.com/");
    }

    @When("envia una peticion de tipo get al recurso {string}")
    public void enviaUnaPeticionDeTipoGetAlRecurso(String recurso) {
        actor.attemptsTo(
                doGet().withTheResource(recurso)
        );
    }

    @Then("deberia obtener un codigo de respuesta {int}")
    public void deberiaObtenerUnCodigoDeRespuesta(Integer statusCode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statusCode)
                )
        );

    }

    @Then("deberia observar que todos los objetos tienen id")
    public void deberiaObtenerUnaListaConLaInformacionDeLosUsuarios() {
        String nuevo = new String(LastResponse.received().answeredBy(actor).asByteArray(),
                StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(nuevo);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 =(JSONObject)jsonArray.get(i);
            actor.should(
                    seeThat("El id es",
                            obtenerInfo().delObjeto(jsonObject1).delCampo("id"),
                            Matchers.notNullValue()
                    )
            );
        }
    }
}

