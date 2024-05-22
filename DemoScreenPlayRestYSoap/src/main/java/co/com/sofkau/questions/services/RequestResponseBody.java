package co.com.sofkau.questions.services;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RequestResponseBody implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().print();
    }
    public static Question<String> was(){
        return new RequestResponseBody();
    }
}
