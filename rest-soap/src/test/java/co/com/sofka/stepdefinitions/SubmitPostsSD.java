package co.com.sofka.stepdefinitions;

import co.com.sofka.constants.urls.ServiceUrl;
import co.com.sofka.models.PostItem;
import co.com.sofka.models.PostModel;
import co.com.sofka.questions.PostSubmitResponse;
import co.com.sofka.tasks.DoPost;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SubmitPostsSD extends ServiceSetup {
    private PostModel postModel;

    @When("sends a POST request to submit its publication with the following information")
    public void sendsAPOSTRequestToSubmitItsPublicationWithTheFollowingInformation(List<PostModel> postModels) {
        postModel = postModels.get(0);
        Gson gson = new Gson();
        String body = gson.toJson(postModel);

        actor.attemptsTo(
                DoPost.doPost()
                        .withResource(ServiceUrl.POST_POSTS_URL)
                        .andBody(body)
                        .andHeaders(super.headers())
        );
    }

    @And("should see the posts with an id generated and the same data")
    public void shouldSeeThePostsWithAnIdGeneratedAndSameData() {
        PostItem postItem = PostSubmitResponse.postSubmitResponse().answeredBy(actor);
        assertThat("Post item ID should not be null", postItem.getId(), is(notNullValue()));
        assertThat("User id should be the same", postItem.getUserId(), equalTo(postModel.getUserId()));
        assertThat("Title should be the same", postItem.getTitle(), equalTo(postModel.getTitle()));
    }
}
