package co.com.sofka.tasks;

import co.com.sofka.interactions.OurDelete;
import co.com.sofka.interactions.OurPost;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoDeleteRest implements Task {
    private String resource;
    private Object body;

    public DoDeleteRest withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoDeleteRest andTheBody(Object body) {
        this.body = body;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurDelete.resource(resource).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .body(body)
                )
        );
    }
    public static DoDeleteRest doDeleteRest() {
        return new DoDeleteRest();
    }
}
