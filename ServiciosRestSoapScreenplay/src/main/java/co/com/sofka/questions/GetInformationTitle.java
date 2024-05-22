package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class GetInformationTitle implements Question<String> {
    String field;
    JSONObject jsonObject;

    public GetInformationTitle ofTheObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public GetInformationTitle ofTheField(String field) {
        this.field = field;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        return jsonObject.getString(field);
    }

    public static GetInformationTitle getInformationTitle() {
        return new GetInformationTitle();
    }
}
