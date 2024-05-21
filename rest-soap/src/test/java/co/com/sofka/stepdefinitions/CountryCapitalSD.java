package co.com.sofka.stepdefinitions;


import co.com.sofka.constants.urls.ServiceUrl;
import co.com.sofka.questions.XmlResponse;
import co.com.sofka.utils.XmlBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CountryCapitalSD extends SOAPServiceSetup {
    @Given("the user is connected to the SOAP Services")
    public void theUserIsConnectedToTheSOAPServices() {
        setupService(ServiceUrl.SOAP_BASE_URL);
    }

    @When("sends a POST request entering the ISO country code {string}")
    public void sendsAPOSTRequestEnteringTheISOCountryCode(String isoCode) {
        String requiredFile = "country_capital";
        actor.attemptsTo(
                doPost()
                        .withResource(ServiceUrl.SOAP_RESOURCE)
                        .andHeaders(super.headers())
                        .andBody(XmlBody.isoCodeCapitalBody(isoCode, requiredFile))
        );
    }
    @Then("response should contain the capital of the country {string}")
    public void responseShouldContainTheCapitalOfTheCountry(String expectedCapital) {
        actor.should(
                seeThat("result",
                        XmlResponse.xmlResponse().withName("CapitalCityResult"), equalTo(expectedCapital))
        );
    }


}
