package co.com.sofka.stepdefinitions.soapservices;

import co.com.sofka.stepdefinitions.SetupService;
import io.cucumber.java.en.*;

import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.getBody;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class PostIsoCodeSD extends SetupService {
    private String country;

    @Given("the user wants to know the Iso code of the country {string}")
    public void theUserWantsToKnowTheIsoCodeOfTheCountry(String countryName) {
        setUpService("http://webservices.oorsprong.org/");
        country = countryName;
    }
    @When("does the petition of the service")
    public void doesThePetitionOfTheService() {
        actor.attemptsTo(
                doPost().withTheResource("websamples.countryinfo/CountryInfoService.wso")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(country, "CountryIsoCode.xml"))
        );

    }
    @Then("it should be able to see the Iso code {string}")
    public void itShouldBeAbleToSeeTheIsoCode(String IsoCode) {
        actor.should(
                seeThat("el resultado deberia ser",
                        responseSoap(), containsString(IsoCode)
                )
        );
    }

}
