package com.davidbonelo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostAndLog extends RestInteraction {
    private final String resource;

    public PostAndLog(String resource) {
        this.resource = resource;
    }

    public static Post to(String resource) {
        return instrumented(Post.class, resource);
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().post(as(actor).resolve(resource)).then().log().all();
    }
}
