package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class TemperaturaStepDefinitions extends SetupService {

    @Given("que el servicio de conversión de temperaturas está operativo")
    public void que_el_servicio_de_conversión_de_temperaturas_está_operativo() {
        super.setupService("https://www.w3schools.com:443/xml/");
    }

    @When("el usuario envía una solicitud para convertir la temperatura de Celsius a Fahrenheit con un valor de {string}")
    public void el_usuario_envía_una_solicitud_para_convertir_la_temperatura_de_celsius_a_fahrenheit_con_un_valor_de(String celsius) {
        actor.attemptsTo(
                doPost().withTheResource("tempconvert.asmx")
                        .andHeaders(soapHeaders())
                        .andTheBody(getBody(celsius))
        );
    }

    private static @NotNull String getBody(String celsius) {
        return String.format(readFile("src/test/resources/archivosxml/temperatura.xml"), celsius);
    }

    @Then("debería obtener la temperatura en Fahrenheit como {string}")
    public void debería_obtener_la_temperatura_en_fahrenheit_como(String expectedFahrenheit) {
        actor.should(
                seeThat("El código de respuesta es",
                        ResponseCode.was(), equalTo(200))
        );

        actor.should(
                seeThat("La respuesta contiene el valor esperado en Fahrenheit",
                        responseSoap(), containsString(expectedFahrenheit))
        );
    }
}
