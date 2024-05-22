package garcia.juan.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.JSONObject;

public class ObtenerInfo implements Question<Integer> {

    String campo;
    JSONObject objeto;

    public ObtenerInfo delObjeto(JSONObject objeto){
        this.objeto=objeto;
        return this;
    }

    public ObtenerInfo delCampo(String campo){
        this.campo=campo;
        return this;
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return objeto.getInt(campo);
    }

    public static ObtenerInfo obtenerInfo(){
        return new ObtenerInfo();
    }
}
