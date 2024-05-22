package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.Constants.*;
import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.util.Util.getBodyCountryCurrency;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultCurrencyStepDefinitions extends SetUp {
    @Given("the user want to consult the currency by country")
    public void theUserWantToConsultTheCurrencyByCountry() {
        setUp(URL_SOAP);
    }

    @When("makes the request to consult the currency of the country with code {string}")
    public void makesTheRequestToConsultTheCurrencyOfTheCountryWithCode(String countryCode) {
        actor.attemptsTo(
                doPost().withTheResource(RESOURCE_CURRENCY_NAME)
                        .andHeaders(headers())
                        .andTheBody(getBodyCountryCurrency(countryCode))
        );
    }

    @Then("should see the status code {int}")
    public void shouldSeeTheStatusCode(Integer statusCode) {
        actor.should(
                seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
        );
    }

    @Then("the currency name {string}")
    public void theCurrencyName(String currencyName) {
        actor.should(
                seeThat(RESULT, responseSoap(), containsString(currencyName))
        );
    }
}
