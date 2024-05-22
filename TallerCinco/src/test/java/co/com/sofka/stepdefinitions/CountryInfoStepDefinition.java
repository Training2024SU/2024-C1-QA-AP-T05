package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static garcia.juan.questions.services.ResponseSoap.responseSoap;
import static garcia.juan.tasks.services.DoPost.doPost;
import static garcia.juan.utils.ArchivosUtil.getBody;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CountryInfoStepDefinition extends SoapSetup{
    String pais;
    String isoCode;
    String phoneCode;


    @Given("el usuario quiere buscar el pais {string}")
    public void el_usuario_quiere_buscar_el_pais(String string) {
        super.setupService("http://webservices.oorsprong.org/");
        pais = string;
    }
    @When("hace la peticion de buscar pais por nombre")
    public void hace_la_peticion_de_buscar_pais_por_nombre() {
        actor.attemptsTo(
                doPost().withTheResource("websamples.countryinfo/CountryInfoService.wso")
                .andHeaders(super.headers())
                .andTheBody(getBody(pais, "CountryIsoCode.xml"))
        );
    }
    @Then("deberia observar el codigo ISO del pais {string}")
    public void deberia_observar_el_codigo_iso_del_pais(String string) {
        isoCode = string;
        actor.should(
                seeThat(
                        "El codigo de pais es",
                        responseSoap().delServicio("CountryISOCodeResult"),
                        equalTo(isoCode)
                        )
        );
    }

    @Given("el usuario quiere buscar el pais {string} con {string}")
    public void el_usuario_quiere_buscar_el_pais_con(String pais, String isoCodigo) {
        super.setupService("http://webservices.oorsprong.org/");
        isoCode = isoCodigo;
    }

    @When("hace la peticion de buscar codigo de pais")
    public void hace_la_peticion_de_buscar_codigo_de_pais() {
        actor.attemptsTo(
                doPost().withTheResource("websamples.countryinfo/CountryInfoService.wso")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(isoCode, "CountryPhoneCode.xml"))
        );
    }

    @Then("deberia observar el codigo de telefono del pais {string}")
    public void deberia_observar_el_codigo_de_telefono_del_pais(String string) {
        phoneCode = string;
        actor.should(
                seeThat(
                        "El codigo de pais es",
                        responseSoap().delServicio("CountryIntPhoneCodeResult"),
                        equalTo(phoneCode)
                )
        );
    }


}
