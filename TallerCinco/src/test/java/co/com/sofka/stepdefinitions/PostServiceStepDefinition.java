package co.com.sofka.stepdefinitions;

import garcia.juan.models.PostModel;
import garcia.juan.questions.ObtenerString;
import garcia.juan.tasks.services.DoPost;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static garcia.juan.questions.ObtenerInfo.obtenerInfo;
import static garcia.juan.tasks.services.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostServiceStepDefinition extends SetupService{
    private PostModel postModel = new PostModel();

    @When("envia una peticion de tipo post al recurso con la siguiente informacion {string} y con body {string}")
    public void enviaUnaPeticionDeTipoPostAlRecursoConLaSiguienteInformacionYConBody(String title, String body){
        postModel.setTitle(title);
        postModel.setBody(body);

        actor.attemptsTo(
                DoPost.doPost().withTheResource("posts/1/comments").
                        andTheBody(postModel).andHeaders(super.headers())
        );
    }

    @Then("should see the posts with an id generated and the same data")
    public void shouldSeeThePostsWithAnIdGeneratedAndTheSameData() {
        String nuevo = new String(LastResponse.received().answeredBy(actor).asByteArray(),
                StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(nuevo);

        actor.should(
                seeThat("El title es",
                        ObtenerString.obtenerString().delObjeto(jsonObject).delCampo("title"),
                        equalTo(postModel.getTitle())
                ),
                seeThat("El body es",
                        ObtenerString.obtenerString().delObjeto(jsonObject).delCampo("body"),
                        equalTo(postModel.getBody())
                )
        );
    }
}
