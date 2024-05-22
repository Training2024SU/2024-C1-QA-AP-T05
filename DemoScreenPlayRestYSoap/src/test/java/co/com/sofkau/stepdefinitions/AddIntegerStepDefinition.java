package co.com.sofkau.stepdefinitions;

import co.com.sofkau.questions.services.ResponseCode;
import co.com.sofkau.setup.SetupService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import static co.com.sofkau.utils.ArchivosUtil.readFile;
import static co.com.sofkau.questions.services.ResponseSoap.responseSoap;
import static co.com.sofkau.tasks.services.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;


public class AddIntegerStepDefinition extends SetupService {
    int valor1;
    int valor2;

    @Given("que el usuario desea sumar el integer1 {int} con el integer2 {int}")
    public void queElEsUsuarioQuiereSumarConElNumero(Integer integer1, Integer integer2) {
        super.setupService("http://www.dneonline.com");
        valor1 = integer1;
        valor2 = integer2;
    }

    @When("envia una peticion de add integer")
    public void haceLaPeticionDeSuma() {
        actor.attemptsTo(
                doPost().withTheResource("addInteger.xml")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(valor1,valor2))
        );
    }

    private static @NotNull String getBody(int valor1, int valor2) {
        String cuerpo = String.format(readFile("src/test/resources/archivosxml/addInteger.xml"), valor1, valor2);
        return cuerpo;
    }

    @Then("deberia obtener el total de {int}")
    public void deberiaObtenerElResultadoDe(Integer resultado) {
        actor.should(
                seeThat("el resultado deberia ser",
                        responseSoap(), containsString(resultado+"")
                )
        );

    }
}