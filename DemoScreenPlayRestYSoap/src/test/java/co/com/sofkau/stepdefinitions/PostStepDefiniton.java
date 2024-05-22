package co.com.sofkau.stepdefinitions;

import co.com.sofkau.models.ModeloPost;
import co.com.sofkau.setup.SetupService;
import co.com.sofkau.utils.Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofkau.questions.ObtenerRespuesta.obtenerRespuesta;
import static co.com.sofkau.tasks.Constantes.recursoPost;
import static co.com.sofkau.tasks.services.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class PostStepDefiniton extends SetupService {
    private static ModeloPost modeloPost = new ModeloPost();
    @When ("ingresa un username y password, enviando una peticion GET al recurso")
    public void ingresaSuUsernameYPasswordDeseado(){

        modeloPost = Util.crearModeloPostConUsuarioYContrasena();

        actor.attemptsTo(
                doPost().withTheResource(recursoPost).andTheBody(modeloPost)
                        .andHeaders(super.headers())
        );
    }

    @When("envia una peticion de tipo POST al recurso")
    public void envia_una_peticion_de_tipo_post_al_recurso() {
        actor.attemptsTo(doPost()
                .withTheResource(recursoPost)
                .andTheBody(modeloPost));
    }
    @Then("deberia visualizar el mismo username")
    public void deberia_visualizar_el_userName_registrado() {

        actor.should(
                seeThat("el codigo de respuesta", obtenerRespuesta().delCampo("username"), equalTo(modeloPost.getUserName()))
        );
    }
}
