package co.com.sofkau.stepdefinitions;

import co.com.sofkau.questions.services.RequestResponseBody;
import co.com.sofkau.questions.services.ResponseCode;
import co.com.sofkau.setup.SetupService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import static co.com.sofkau.tasks.Constantes.recursoGet;
import static co.com.sofkau.tasks.Constantes.urlBaseServicios;
import static co.com.sofkau.tasks.services.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetStepDefinition extends SetupService {
    @Given("que el usuario esta en la pagina de demoqa")
    public void que_el_usuario_esta_en_la_pagina_de_reqres() {
        try {
            setupService(urlBaseServicios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @When("envia una peticion de tipo GET al recurso")
    public void envia_una_peticion_de_tipo_get_al_recurso() {
        try {
            actor.attemptsTo(
                    doGet().withTheResource(recursoGet));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Then("deberia obtener un codigo de estado de la respuesta {int}")
    public void deberia_obtener_un_codigo_de_estado_de_la_respuesta(Integer codigoEstado) {
        try {
            actor.should(
                    seeThat("The status code",
                            ResponseCode.was(), equalTo(codigoEstado)
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("el libro con isbn {string} deberia tener el title {string} y el author {string}")
    public void el_libro_con_isbn_deberia_tener_el_title_y_el_author(String isbn, String title, String author) {
        try {
            actor.should(
                    seeThat("La respuesta contiene el isbn: ", RequestResponseBody.was(), Matchers.containsString((isbn))),
                    seeThat("La respuesta contiene la titulo: ", RequestResponseBody.was(), Matchers.containsString(title)),
                    seeThat("La respuesta contiene el autor: ", RequestResponseBody.was(), Matchers.containsString(author))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
