package co.com.demo.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class SetupService {

    protected final Actor actor = new Actor("Daniel");

    protected void setupServiceGet(String urlBase){
        actorCanRequest(urlBase);
    }
    private void actorCanRequest(String urlBase){
        actor.can(CallAnApi.at(urlBase));
    }


}
