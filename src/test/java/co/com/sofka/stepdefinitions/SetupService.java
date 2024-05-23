package co.com.sofka.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

public class SetupService {

    protected static final Actor actor = new Actor("Kathe");

    protected void setupService(String urlBase){
        actor.can(CallAnApi.at(urlBase));
    }

    protected HashMap<String, Object> soapHeaders(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type","text/xml; charset=UTF-8");
        headersCollection.put("SOAPAction","https://www.w3schools.com/xml/CelsiusToFahrenheit");
        return headersCollection;
    }

    protected HashMap<String, Object> restHeaders(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "application/json; charset=UTF-8");
        return headersCollection;
    }
    protected HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "application/json");
        return headersCollection;
    }

}
