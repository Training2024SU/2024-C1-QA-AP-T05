package co.com.sofka.stepdefinitions.soapservices;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.stepdefinitions.SetupService;
import io.cucumber.java.en.*;

import static co.com.sofka.questions.ResponseCapital.responseCapital;
import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.getBody;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostCapitalCitieSD extends SetupService {
    private String country;

    @Given("the user wants to know the name of the capital city of {string}")
    public void theUserWantsToKnowTheNameOfTheCapitalCityOf(String countryName) {
        setUpService("http://webservices.oorsprong.org/");
        country = countryName;
    }
    @When("does the petition")
    public void doesThePetition() {
        actor.attemptsTo(
                doPost().withTheResource("websamples.countryinfo/CountryInfoService.wso")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(country, "postCapital.xml"))
        );

    }
    @Then("it should get a {int} code")
    public void itShouldGetACode(Integer statusCode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statusCode)
                )
        );

    }
    @Then("it should be able to see the name of the capital city {string}")
    public void itShouldBeAbleToSeeTheNameOfTheCapitalCity(String Capital) {
        actor.should(
                seeThat("la capital sea igual a",
                        responseCapital().withTheResource("CapitalCityResponse"), equalTo(Capital)
                )
        );

    }
}
