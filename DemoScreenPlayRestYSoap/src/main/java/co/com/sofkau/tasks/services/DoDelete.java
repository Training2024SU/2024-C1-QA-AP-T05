package co.com.sofkau.tasks.services;

import co.com.sofkau.interactions.OurDelete;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoDelete implements Task {
    private String resource;

    public DoDelete withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurDelete.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()


                        )
        );


    }


    public static DoDelete doDelete() {
        return new DoDelete();
    }
}
