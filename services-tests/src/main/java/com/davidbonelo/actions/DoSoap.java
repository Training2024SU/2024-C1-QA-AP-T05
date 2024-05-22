package com.davidbonelo.actions;

import com.davidbonelo.interactions.PostAndLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import java.util.HashMap;
import java.util.Map;

public class DoSoap implements Performable {
    private String resource;
    private String body;
    private Map<String, String> headers;

    public DoSoap() {
        this.headers = new HashMap<>(Map.of("Content-Type", "text/xml;charset=UTF-8"));
    }

    public static DoSoap request() {
        return new DoSoap();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostAndLog.to(resource).with(requestSpecification -> requestSpecification
//                        .header("SOAPAction", "")
                                .headers(headers)
                                .body(body)
                )
        );
    }

    public DoSoap to(String resource) {
        this.resource = resource;
        return this;
    }

    public DoSoap withHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public DoSoap withBody(String body) {
        this.body = body;
        return this;
    }
}
