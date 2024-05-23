package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.tasks.SendCreatePostRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearPostStepDefinitions extends SetupService {

    @Given("que el servicio de creación de posts está operativo")
    public void que_el_servicio_de_creación_de_posts_está_operativo() {
        super.setupService("https://jsonplaceholder.typicode.com/");
    }

    @When("el usuario envía una solicitud para crear una nueva publicación con título {string} y cuerpo {string}")
    public void el_usuario_envía_una_solicitud_para_crear_una_nueva_publicación_con_título_y_cuerpo(String title, String body) {
        actor.attemptsTo(
                SendCreatePostRequest.withResourceAndBody("posts", Map.of("title", title, "body", body))

        );
    }

    @Then("la publicación debería ser creada exitosamente")
    public void la_publicación_debería_ser_creada_exitosamente() {
        actor.should(
                seeThat("El código de respuesta es", ResponseCode.was(), equalTo(201))
        );
    }
}
