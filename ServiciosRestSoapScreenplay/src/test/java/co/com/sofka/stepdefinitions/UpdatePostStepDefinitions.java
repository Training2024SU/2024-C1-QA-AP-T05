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
import static co.com.sofka.questions.GetInformationTitle.getInformationTitle;
import static co.com.sofka.questions.ReturnResponse.returnResponse;
import static co.com.sofka.tasks.DoPutRest.doPutRest;
import static co.com.sofka.util.Util.getPostById;
import static co.com.sofka.util.Util.requestBodyPosts;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdatePostStepDefinitions extends SetUp {
    @Given("the user is updating a user")
    public void theUserIsUpdatingAUser() {
        setUp(URL_REST);
    }

    @When("sends a put request to the resource with user id {int} and the information {string} {string}")
    public void sendsAPutRequestToTheResourceWithUserIdAndTheInformation(Integer id, String title, String body) {
        actor.attemptsTo(
                doPutRest().withTheResource(getPostById(id))
                        .andTheBody(requestBodyPosts(id, title, body))
        );
    }

    @Then("should get status code {int}")
    public void shouldGetStatusCode(Integer statusCode) {
        actor.should(
                seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
        );
    }

    @Then("should see {string}")
    public void shouldSee(String titleExpected) {
        String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(response);
        actor.should(
                seeThat(RESULT, getInformationTitle().ofTheObject(jsonObject).ofTheField(TITLE_FIELD), equalTo(titleExpected))
        );
    }
}
