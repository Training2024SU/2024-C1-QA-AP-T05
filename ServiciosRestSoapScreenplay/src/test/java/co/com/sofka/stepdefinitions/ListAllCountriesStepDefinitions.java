package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.Constants.*;
import static co.com.sofka.questions.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.util.Util.getAllCountries;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class ListAllCountriesStepDefinitions extends SetUp {
    @Given("the user want to consult all country names")
    public void theUserWantToConsultAllCountryNames() {
        setUp(URL);
    }
    @When("makes the request to consult them")
    public void makesTheRequestToConsultThem() {
        actor.attemptsTo(
            doPost().withTheResource(RESOURCE_ALL_COUNTRIES)
                    .andHeaders(headers())
                    .andTheBody(getAllCountries())
        );
    }
    @Then("should get a status code {int}")
    public void shouldGetAStatusCode(Integer statusCode) {
        actor.should(
                seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
        );
    }
    @Then("should see the country name {string} including its code {string}")
    public void shouldSeeTheCountryNameIncludingItsCode(String countryName, String countryCode) {
        actor.should(
                seeThat(RESULT, responseSoap(), containsString(countryName), containsString(countryCode))
        );
    }
}
