package co.com.sofka.tasks.services;

import co.com.sofka.interactions.OurPost;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class DoPostSoap implements Task {
    private String resource;
    private Object body;
    private Map<String, Object> headers;

    public DoPostSoap withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPostSoap andTheBody(Object body) {
        this.body = body;
        return this;
    }

    public DoPostSoap andHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurPost.resource(resource).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .headers(headers)
                                .relaxedHTTPSValidation()
                                .body(body)
                )
        );

    }

    public static DoPostSoap doPostSoap() {
        return new DoPostSoap();
    }
}
