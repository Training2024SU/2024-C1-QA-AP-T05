package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.services.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.tasks.services.DoDeleteRest.doDeleteRest;

import static co.com.sofka.utils.ArchivosUtil.getTodosById;
import static co.com.sofka.utils.ArchivosUtil.requestBodyDelete;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteSD extends SetupService{

    @Given("el usuario esta eliminando una actividad")
    public void elUsuarioEstaEliminandoUnaActividad() {
        setupService("https://jsonplaceholder.typicode.com/");


    }
    @When("envia una solicitud DELETE al recurso con id de usuario {int}")
    public void enviaUnaSolicitudDELETEAlRecursoConIdDeUsuario(Integer id) {
        actor.attemptsTo(
                doDeleteRest().withTheResource(getTodosById(id))
                        .andTheBody(requestBodyDelete(id))
        );

    }
    @Then("deberia obtener el código de estado {int}")
    public void deberiaObtenerElCódigoDeEstado(Integer statusCode) {
            actor.should(
                    seeThat("the status code is", ResponseCode.was(), equalTo(statusCode))
            );


    }
}
