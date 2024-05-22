package co.com.sofkau.tasks;

import co.com.sofkau.tasks.services.DoPost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class DoSoap implements Task {

    private String soapAction;
    private String requestBody;

    private String resource;


    public DoSoap withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoSoap andTheBody(String body) {
        this.requestBody = body;
        return this;
    }

    public DoSoap andTheAction(String soapAction) {
        this.soapAction = soapAction;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(request -> request
                                .header("Content-Type", "text/xml; charset=utf-8")
                                .header("SOAPAction", soapAction)
                                .body(requestBody)
                        )
        );
    }

    public static DoSoap doSoap() {
        return new DoSoap();
    }
}
