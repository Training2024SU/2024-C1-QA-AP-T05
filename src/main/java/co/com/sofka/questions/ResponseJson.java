package co.com.sofka.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ResponseJson implements Question<String> {

    private final String jsonPath;

    public ResponseJson(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public static ResponseJson responseJson(String jsonPath) {
        return new ResponseJson(jsonPath);
    }

    public static ResponseJson withPath(String jsonPath) {
        return new ResponseJson(jsonPath);
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString(jsonPath);
    }
}
