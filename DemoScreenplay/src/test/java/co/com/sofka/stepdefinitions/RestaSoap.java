package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.services.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import static co.com.sofka.questions.services.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.services.DoPostSoap.doPostSoap;
import static co.com.sofka.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestaSoap extends SetupService {
    int valueUno;
    int valueDos;

    @Given("que el usuario quiere restar {int} con el numero {int}")
    public void queElUsuarioQuiereRestarConElNumero(Integer numeroUno, Integer numeroDos) {
        super.setupService("http://www.dneonline.com/");
        valueUno = numeroUno;
        valueDos = numeroDos;

    }

    @When("hace la peticion de resta")
    public void haceLaPeticionDeResta() {
        actor.attemptsTo(
                doPostSoap().withTheResource("calculator.asmx")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(valueUno, valueDos))
        );
    }

    private static @NotNull String getBody(int valueUno, int valueDos) {
        String cuerpo = String.format(readFile("src/test/resources/archivosxml/suma.xml"), valueUno, valueDos);
        return cuerpo;

    }

    @Then("deberia obtener el resultado de resta {int}")
    public void deberiaObtenerElResultadoDeResta(Integer resultado) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(200)
                ),
                seeThat("el resultado deberia ser",
                        responseSoap(), containsString(resultado+"")
                )
        );

    }
}

