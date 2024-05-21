package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.Constants.*;
import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.util.Util.getBodyCapitalCity;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultCapitalCityStepDefinitions extends SetUp {
    @Given("the user want to consult the country capital city")
    public void theUserWantToConsultTheCountryCapitalCity() {
        setUp(URL);
    }
    @When("makes the request to consult by country {string}")
    public void makesTheRequestToConsultByCountry(String countryCode) {
       actor.attemptsTo(
               doPost().withTheResource(RESOURCE_CAPITAL_CITY)
                       .andHeaders(headers())
                       .andTheBody(getBodyCapitalCity(countryCode))
       );
    }
    @Then("should obtain a status code {int}")
    public void shouldObtainAStatusCode(Integer statusCode) {
        actor.should(
                seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
        );
    }
    @Then("should get the capital city {string}")
    public void shouldGetTheCapitalCity(String capitalCityName) {
        actor.should(
                seeThat(RESULT, responseSoap(), containsString(capitalCityName))
        );
    }
}
