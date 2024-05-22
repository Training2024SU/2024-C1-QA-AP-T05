package osorio.alvarez.devon.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class VerifyResponseContainsText implements Question<Boolean> {

    private final String expectedText;

    public VerifyResponseContainsText(String expectedText) {
        this.expectedText = expectedText;
    }

    public static VerifyResponseContainsText containsText(String expectedText) {
        return new VerifyResponseContainsText(expectedText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String responseBody = String.valueOf(LastResponse.received().asString());
        return responseBody.contains(expectedText);
    }
}

