package co.com.sofka.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

import static co.com.sofka.Constants.ACTOR_NAME;

public class SetUp {
    protected static Actor actor = new Actor(ACTOR_NAME);

    protected void setUp(String url) {
        actor.can(CallAnApi.at(url));
    }
    protected HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "text/xml;charset=UTF-8");
        headersCollection.put("SOAPAction", "");
        return headersCollection;
    }
}
