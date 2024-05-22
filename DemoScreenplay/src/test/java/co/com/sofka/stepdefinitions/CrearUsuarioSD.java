package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.services.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import static co.com.sofka.questions.services.ObtenerInfo.obtenerInfo;
import static co.com.sofka.tasks.services.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.requestBodyUser;
import static net.serenitybdd.cucumber.suiteslicing.SerenityCSVHeader.RESULT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearUsuarioSD extends SetupService{


    @Given("el usuario está creando un nuevo usuario con el servicio de jsonplaceholder")
    public void elUsuarioEstáCreandoUnNuevoUsuarioConElServicioDeJsonplaceholder() {
        setupService("https://jsonplaceholder.typicode.com/");

    }
    @When("ingresa la información para un nuevo usuario {string} {string} {string}")
    public void ingresaLaInformaciónParaUnNuevoUsuario(String nombre, String nombreUsuario, String correo) {
        actor.attemptsTo(
                doPost().withTheResource("users")
                        .andTheBody(requestBodyUser(nombre, nombreUsuario, correo))
        );

    }
    @Then("debería ver que obtiene el código de estado {int}")
    public void deberíaVerQueObtieneElCódigoDeEstado(Integer statusCode) {
        actor.should(
                seeThat("the status code is", ResponseCode.was(), equalTo(statusCode))
        );


    }
    @Then("debería ver que el id es igual a {int}")
    public void deberíaVerQueElIdEsIgualA(Integer idExpected) {
        String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(response);

        actor.should(
                seeThat(RESULT, obtenerInfo().delObjeto(jsonObject).delCampo("id"), equalTo(idExpected))
        );

    }
}
