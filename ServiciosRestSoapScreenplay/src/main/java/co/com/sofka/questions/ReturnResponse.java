package co.com.sofka.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class ReturnResponse implements Question<String> {
    String field;
    JSONObject jsonObject;
    public ReturnResponse ofTheObject(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        return this;
    }
    public ReturnResponse ofTheField(String field){
        this.field = field;
        return this;
    }
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().asString();
    }
    public static ReturnResponse returnResponse() {
        return new ReturnResponse();
    }

}
