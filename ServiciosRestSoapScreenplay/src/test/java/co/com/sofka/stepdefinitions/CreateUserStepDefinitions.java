package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import static co.com.sofka.Constants.*;
import static co.com.sofka.questions.GetInformation.getInformation;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.tasks.DoPostRest.doPostRest;
import static co.com.sofka.util.Util.requestBodyUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserStepDefinitions extends SetUp {
    @Given("the user is creating a new user with the service of jsonplaceholder")
    public void theUserIsCreatingANewUserWithTheServiceOfJsonplaceholder() {
        setUp(URL_REST);
    }

    @When("types the information for a new user {string} {string} {string}")
    public void typesTheInformationForANewUser(String name, String userName, String email) {
        actor.attemptsTo(
                doPostRest().withTheResource(RESOURCE_USERS)
                        .andTheBody(requestBodyUser(name, userName, email))
        );
    }

    @Then("should see obtain the status code {int}")
    public void shouldSeeObtainTheStatusCode(Integer statusCode) {
        actor.should(
                seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
        );
    }

    @Then("should see the id equals {int}")
    public void shouldSeeTheIdEquals(Integer idExpected) {
        String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(response);

        actor.should(
                seeThat(RESULT, getInformation().ofTheObject(jsonObject).ofTheField(ID_FIELD), equalTo(idExpected))
        );
    }
}
