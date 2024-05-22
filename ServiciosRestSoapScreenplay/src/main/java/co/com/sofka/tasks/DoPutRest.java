package co.com.sofka.tasks;

import co.com.sofka.interactions.OurPost;
import co.com.sofka.interactions.OurPut;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoPutRest implements Task {
    private String resource;
    private Object body;

    public DoPutRest withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPutRest andTheBody(Object body) {
        this.body = body;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurPut.resource(resource).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .body(body)
                )
        );
    }
    public static DoPutRest doPutRest() {
        return new DoPutRest();
    }
}
