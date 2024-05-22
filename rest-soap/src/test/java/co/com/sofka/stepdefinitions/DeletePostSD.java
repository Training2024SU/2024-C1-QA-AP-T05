package co.com.sofka.stepdefinitions;

import co.com.sofka.constants.urls.ServiceUrl;
import co.com.sofka.interactions.OurDelete;
import io.cucumber.java.en.When;


public class DeletePostSD extends ServiceSetup{
    @When("sends a DELETE request to remove the post with id {string}")
    public void sendsADELETERequestToRemoveThePostWithId(String postId) {
        actor.attemptsTo(
                OurDelete.resource(ServiceUrl.DELETE_POST_URL).with(request -> request.pathParam("id", postId))
        );
    }
}
