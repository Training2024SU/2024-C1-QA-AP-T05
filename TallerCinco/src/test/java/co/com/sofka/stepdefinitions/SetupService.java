package co.com.sofka.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

public class SetupService {

    protected static final Actor actor = new Actor("Juanes");

    protected void setupService(String urlBase){
        actor.can(CallAnApi.at(urlBase));
    }




    protected HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        //headersCollection.put("Content-Type","text/xml;charset=UTF-8");
        headersCollection.put("Content-Type", "application/json");
        return headersCollection;
    }

}
