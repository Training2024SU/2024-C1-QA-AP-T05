package co.com.sofka.questions;


import io.restassured.path.xml.XmlPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

public class ResponseCapital implements Question<String> {
    private String resource;

    public ResponseCapital withTheResource(String resource){
        this.resource = resource;
        return this;
    }

    @Override
    public String answeredBy(Actor actor) {
        String xmlString = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        XmlPath xmlPath = new XmlPath(xmlString);
        String xpathExpression = "**.find { it.name() == '" + resource + "' }.text()";

        return xmlPath.getString(xpathExpression);
    }

    public static ResponseCapital responseCapital() {
        return new ResponseCapital();
    }
}