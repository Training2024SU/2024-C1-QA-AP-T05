package com.davidbonelo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetAndLog extends RestInteraction {
    private final String resource;

    public GetAndLog(String resource) {
        this.resource = resource;
    }

    public static Get resource(String resource) {
        return instrumented(Get.class, resource);
    }

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(resource)).then().log().all();
    }
}
