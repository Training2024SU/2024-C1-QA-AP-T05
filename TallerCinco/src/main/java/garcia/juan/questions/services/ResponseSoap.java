package garcia.juan.questions.services;

import io.restassured.path.xml.XmlPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

public class ResponseSoap implements Question<String> {

    String codigo;

    public ResponseSoap delServicio(String codigo){
        this.codigo=codigo;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        String xmlString = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        XmlPath xmlPath = new XmlPath(xmlString);
        String xpathExpression =String.format("**.find { it.name() == '%s' }.text()",codigo);
        return xmlPath.getString(xpathExpression);
    }

    public static ResponseSoap responseSoap() {
        return new ResponseSoap();
    }
}