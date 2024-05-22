package osorio.alvarez.devon.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import osorio.alvarez.devon.interactions.OurPut;

import java.util.Map;

public class DoPost implements Task {
    private String resource;
    private Object body;
    private Map<String, Object> headers;

    public DoPost withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPost andTheBody(Object body) {
        this.body = body;
        return this;
    }

    public DoPost andHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurPut.resource(resource).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .headers(headers)
                                .relaxedHTTPSValidation()
                                .body(body)
                )
        );

    }

    public static DoPost doPut() {
        return new DoPost();
    }
}
