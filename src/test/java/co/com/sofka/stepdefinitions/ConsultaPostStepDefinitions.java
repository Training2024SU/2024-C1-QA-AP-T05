package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.sofka.questions.ResponseJson.responseJson;
import static co.com.sofka.tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultaPostStepDefinitions extends SetupService {

    @Given("que el servicio de consulta de posts está operativo")
    public void que_el_servicio_de_consulta_de_posts_está_operativo() {
        super.setupService("https://jsonplaceholder.typicode.com/");
    }

    @When("el usuario envía una solicitud para obtener el post con ID {string}")
    public void el_usuario_envía_una_solicitud_para_obtener_el_post_con_id(String postId) {
        actor.attemptsTo(
                doGet().withTheResource("posts/" + postId)
        );
    }

    @Then("debería obtener el título del post como {string}")
    public void debería_obtener_el_título_del_post_como(String title) {
        actor.should(
                seeThat("El código de respuesta es",
                        ResponseCode.was(), equalTo(200))
        );

        actor.should(
                seeThat("El título del post es correcto",
                        responseJson("title"), equalTo(title))
        );
    }
}
