package co.com.sofkau.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

public class SetupService {
    protected static final Actor actor = new Actor("Actor1");

    protected void setupService(String urlBaseServicios){
        actor.can(CallAnApi.at(urlBaseServicios));
    }

    protected HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        //headersCollection.put("Content-Type","text/xml;charset=UTF-8");
        //headersCollection.put("SOAPAction","http://tempuri.org/Add");
        headersCollection.put("Content-Type", "application/json");
        return headersCollection;
    }
}

