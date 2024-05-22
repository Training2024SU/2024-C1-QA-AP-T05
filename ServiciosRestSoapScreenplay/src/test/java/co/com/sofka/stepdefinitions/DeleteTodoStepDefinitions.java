package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.Constants.STATUS_CODE;
import static co.com.sofka.Constants.URL_REST;
import static co.com.sofka.tasks.DoDeleteRest.doDeleteRest;
import static co.com.sofka.util.Util.getTodosById;
import static co.com.sofka.util.Util.requestBodyDelete;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteTodoStepDefinitions extends SetUp {
    @Given("The user is deleting a todo")
    public void theUserIsDeletingATodo() {
        setUp(URL_REST);
    }

    @When("sends a delete request to the resource with user id {int}")
    public void sendsADeleteRequestToTheResourceWithUserId(Integer id) {
        actor.attemptsTo(
                doDeleteRest().withTheResource(getTodosById(id))
                        .andTheBody(requestBodyDelete(id))
        );
    }

    @Then("should obtain status code {int}")
    public void shouldObtainStatusCode(Integer statusCode) {
        actor.should(
                seeThat(STATUS_CODE, ResponseCode.was(), equalTo(statusCode))
        );
    }
}
