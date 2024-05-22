package co.com.sofka.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

public class ServiceSetup {
    public static final Actor actor = new Actor("Johan");

    protected void setupService(String baseUrl){
        actor.can(CallAnApi.at(baseUrl));
    }

    protected HashMap<String, Object> headers() {
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "application/json");
        return headersCollection;
    }
}
