package osorio.alvarez.devon.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import osorio.alvarez.devon.questions.ResponseCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static osorio.alvarez.devon.questions.ResponseSoap.responseSoap;
import static osorio.alvarez.devon.tasks.DoPost.doPut;
import static osorio.alvarez.devon.utils.ArchivosUtil.readFile;

public class SoapStepDefinition extends SetupService {
    int valueUno;
    int valueDos;

    @Given("que el es usuario quiere sumar {int} con el numero {int}")
    public void queElEsUsuarioQuiereSumarConElNumero(Integer numeroUno, Integer numeroDos) {
        super.setupService("http://www.dneonline.com/");
        valueUno = numeroUno;
        valueDos = numeroDos;
    }

    @When("hace la peticion de suma")
    public void haceLaPeticionDeSuma() {
        actor.attemptsTo(
                doPut().withTheResource("calculator.asmx")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(valueUno,valueDos))
        );
    }

    private static @NotNull String getBody(int valueUno, int valueDos) {
        String cuerpo = String.format(readFile("src/test/resources/archivosxml/suma.xml"), valueUno, valueDos);
        return cuerpo;
    }

    @Then("deberia obtener el resultado de {int}")
    public void deberiaObtenerElResultadoDe(Integer resultado) {
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
