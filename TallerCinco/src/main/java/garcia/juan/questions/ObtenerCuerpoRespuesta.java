package garcia.juan.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class ObtenerCuerpoRespuesta implements Question<String> {

    int objeto;
    String campo;

    public ObtenerCuerpoRespuesta delObjeto(int numero){
        this.objeto=numero;
        return this;
    }
    public ObtenerCuerpoRespuesta obtenerElCampo(String campo){
        this.campo=campo;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        String respuesta = new String(LastResponse.received().answeredBy(actor).asByteArray(),
                StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(respuesta);
        JSONObject jsonData = jsonObject.getJSONObject("data"); // Obtener el objeto JSON
        JSONArray jsonResults = jsonData.getJSONArray("results");
        JSONObject primerResultado = jsonResults.getJSONObject(objeto);
        System.out.println("***********************");
        System.out.println(primerResultado.getString(campo));
        System.out.println("************************");
        return primerResultado.getString(campo);
    }

    public static ObtenerCuerpoRespuesta obtenerCuerpoRespuesta(){
        return new ObtenerCuerpoRespuesta();
    }
}
