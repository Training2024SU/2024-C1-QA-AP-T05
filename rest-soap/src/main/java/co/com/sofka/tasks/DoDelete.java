package co.com.sofka.tasks;

import co.com.sofka.interactions.OurDelete;
import co.com.sofka.interactions.OurGet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoDelete implements Task {

    private String resource;
    public DoDelete withResource(String resource){
        this.resource=resource;
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

    public static DoDelete doDelete(){
        return new DoDelete();
    }
}