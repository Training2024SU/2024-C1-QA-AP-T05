package co.com.sofka.tasks;

import co.com.sofka.interactions.OurPost;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class SendCreatePostRequest implements Task {
    private final String resource;
    private final Map<String, Object> requestBody;

    public SendCreatePostRequest(String resource, Map<String, Object> requestBody) {
        this.resource = resource;
        this.requestBody = requestBody;
    }

    public static SendCreatePostRequest withResourceAndBody(String resource, Map<String, Object> requestBody) {
        return new SendCreatePostRequest(resource, requestBody);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurPost.resource(resource)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(requestBody)
                        )
        );
    }
}
