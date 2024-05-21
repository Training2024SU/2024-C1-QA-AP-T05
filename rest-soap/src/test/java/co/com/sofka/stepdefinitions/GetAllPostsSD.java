package co.com.sofka.stepdefinitions;

import co.com.sofka.constants.urls.ServiceUrl;
import co.com.sofka.interactions.OurGet;
import co.com.sofka.models.PostItem;
import co.com.sofka.questions.PostsGetResponse;
import co.com.sofka.tasks.DoGet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;

public class GetAllPostsSD extends ServiceSetup{
    @Given("the user is connected to the jsonplaceholder API")
    public void theUserIsConnectedToTheJsonplaceholderAPI() {
        setupService(ServiceUrl.BASE_URL);
    }
    @When("sends a GET request to retrieve all posts")
    public void sendsAGETRequestToRetrieveAllPosts() {
        actor.attemptsTo(
                DoGet.doGet().withResource(ServiceUrl.GET_POSTS_URL)
        );
    }
    @Then("response should contain information about all posts including")
    public void responseShouldContainInformationAboutAllPostsIncluding(List<PostItem> expectedPostItemList) {
        expectedPostItemList.forEach(postItem -> {
            actor.should(
                    seeThat(PostsGetResponse.postsGetResponse(), hasItem(postItem))
            );
        });
    }
    @Then("should receive a response of {int}")
    public void shouldReceiveAResponseOf(Integer statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }



}
