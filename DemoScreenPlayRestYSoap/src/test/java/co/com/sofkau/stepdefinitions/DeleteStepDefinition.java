package co.com.sofkau.stepdefinitions;

import co.com.sofkau.setup.SetupService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.sofkau.questions.ObtenerRespuesta.obtenerRespuesta;
import static co.com.sofkau.tasks.Constantes.mensaje_no_autorizado;
import static co.com.sofkau.tasks.Constantes.recursoDelete;
import static co.com.sofkau.tasks.services.DoDelete.doDelete;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteStepDefinition extends SetupService {
    @When("ingresa un UserId {string} no autorizado enviando una peticion DELETE al recurso")
    public void ingresaUnUserIdNoAutorizado(String userId){
        actor.attemptsTo(
                doDelete().withTheResource(recursoDelete + userId));
    }
    @Then("deberia visualizar el mensaje de usuario no autorizado")
    public void deberiaVisualizarElMensajeDeUsuarioNoAutorizado(){
        actor.should(
                seeThat("mensaje de respuesta", obtenerRespuesta().delCampo("message"), equalTo(mensaje_no_autorizado))
        );
    }
}
