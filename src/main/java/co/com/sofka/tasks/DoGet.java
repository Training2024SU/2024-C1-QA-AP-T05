package co.com.sofka.tasks;

import co.com.sofka.interactions.OurGet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class DoGet implements Task {
    private String resource;
    private Map<String, Object> headers;

    public static DoGet withTheResource(String resource) {
        DoGet doGet = new DoGet();
        doGet.resource = resource;
        return doGet;
    }

    public DoGet andHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        OurGet ourGet = (OurGet) OurGet.resource(resource)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .relaxedHTTPSValidation());

        if (headers != null && !headers.isEmpty()) {
            ourGet = (OurGet) ourGet
                    .with(requestSpecification -> requestSpecification
                            .headers(headers));
        }

        actor.attemptsTo(ourGet);
    }

    public static DoGet doGet() {
        return new DoGet();
    }

}
