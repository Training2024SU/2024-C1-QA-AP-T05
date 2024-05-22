package co.com.sofka.questions.services;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class ObtenerInfo implements Question<Integer> {
    String campos;
    JSONObject jsonObject;
    public ObtenerInfo delObjeto(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        return this;
    }
    public ObtenerInfo delCampo(String campos){
        this.campos = campos;
        return this;
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return jsonObject.getInt(campos);
    }
    public static ObtenerInfo obtenerInfo(){
        return new ObtenerInfo();
    }
}

