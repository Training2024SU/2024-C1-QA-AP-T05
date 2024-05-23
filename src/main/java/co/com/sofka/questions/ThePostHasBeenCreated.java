package co.com.sofka.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ThePostHasBeenCreated implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode() == 201;
    }

    public static ThePostHasBeenCreated successfully() {
        return new ThePostHasBeenCreated();
    }
}
