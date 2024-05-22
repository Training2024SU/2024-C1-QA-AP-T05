package co.com.sofka.stepdefinitions;

import co.com.sofka.constants.urls.ServiceUrl;
import co.com.sofka.questions.XmlResponse;
import co.com.sofka.utils.XmlBody;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CountryConcurrencySD extends SOAPServiceSetup{
    @When("sends a POST request entering the ISO country code {string} for concurrency")
    public void sendsAPOSTRequestEnteringTheISOCountryCodeForConcurrency(String isoCode) {
        String requiredFile = "concurrency";
        actor.attemptsTo(
                doPost()
                        .withResource(ServiceUrl.SOAP_RESOURCE)
                        .andHeaders(super.headers())
                        .andBody(XmlBody.isoCodeCapitalBody(isoCode, requiredFile))
        );
    }

    @Then("response should contain the concurrency of the country {string}")
    public void responseShouldContainTheConcurrencyOfTheCountry(String expectedConcurrency) {
        actor.should(
                seeThat("result",
                        XmlResponse.xmlResponse().withName("sName"), equalTo(expectedConcurrency))
        );
    }
}
