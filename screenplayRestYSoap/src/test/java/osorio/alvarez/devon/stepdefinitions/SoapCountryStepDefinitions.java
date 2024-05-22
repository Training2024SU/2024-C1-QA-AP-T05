package osorio.alvarez.devon.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import osorio.alvarez.devon.questions.ResponseCode;

import static java.util.function.Predicate.not;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static osorio.alvarez.devon.questions.ResponseSoap.responseSoap;
import static osorio.alvarez.devon.tasks.DoPost.doPut;
import static osorio.alvarez.devon.utils.ArchivosUtil.readFile;

public class SoapCountryStepDefinitions extends SetupService{
    String codigoISO;
    @Given("que el es usuario quiere ingresar el codigo {string}")
    public void queElEsUsuarioQuiereIngresarElCodigo(String iso) {
        super.setupService("http://webservices.oorsprong.org");
        codigoISO = iso;
    }
    @When("hace la peticion de tipo soap")
    public void haceLaPeticionDeTipoSoap() {
        actor.attemptsTo(
                doPut().withTheResource("/websamples.countryinfo/CountryInfoService.wso")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(codigoISO))
        );
    }

    private static @NotNull String getBody(String codigo) {
        String cuerpo = String.format(readFile("src/test/resources/archivosxml/countryIso.xml"), codigo);
        return cuerpo;
    }
    @Then("deberia obtener un statuscode {int}")
    public void deberia_obtener_un_statuscode(Integer statuscode) {
        String texto = "";
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statuscode)
                )
        );
    }
}
