package co.com.sofka.questions;

import co.com.sofka.models.PostItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;


public class PostSubmitResponse implements Question<PostItem> {

    public PostItem answeredBy(Actor actor) {
        String jsonResponse = SerenityRest.lastResponse().getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonResponse, PostItem.class );
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new PostItem();
        }
    }

    public static PostSubmitResponse postSubmitResponse() {
        return new PostSubmitResponse();
    }
}