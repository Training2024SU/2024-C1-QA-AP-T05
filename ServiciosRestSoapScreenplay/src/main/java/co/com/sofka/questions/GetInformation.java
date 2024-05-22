package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class GetInformation implements Question<Integer> {
    String field;
    JSONObject jsonObject;
    public GetInformation ofTheObject(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        return this;
    }
    public GetInformation ofTheField(String field){
        this.field = field;
        return this;
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return jsonObject.getInt(field);
    }
    public static GetInformation getInformation(){
        return new GetInformation();
    }
}
