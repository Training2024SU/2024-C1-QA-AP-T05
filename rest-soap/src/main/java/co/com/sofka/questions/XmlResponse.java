package co.com.sofka.questions;

import io.restassured.path.xml.XmlPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

public class XmlResponse implements Question<String> {
    private String name;
    public XmlResponse withName(String name){
        this.name = name;
        return this;
    }


    @Override
    public String answeredBy(Actor actor) {
        String xmlString = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        XmlPath xmlPath = new XmlPath(xmlString);
        String xpathExpression = String.format("**.find { it.name() == '%s' }.text()", name);
        return xmlPath.getString(xpathExpression);
    }

    public static XmlResponse xmlResponse() {
        return new XmlResponse();
    }
}