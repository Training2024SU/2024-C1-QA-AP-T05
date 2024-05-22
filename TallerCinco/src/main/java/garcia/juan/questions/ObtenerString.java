package garcia.juan.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class ObtenerString implements Question<String> {

    String campo;
    JSONObject objeto;

    public ObtenerString delObjeto(JSONObject objeto){
        this.objeto=objeto;
        return this;
    }

    public ObtenerString delCampo(String campo){
        this.campo=campo;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        return objeto.getString(campo);
    }

    public static ObtenerString obtenerString(){
        return new ObtenerString();
    }
}