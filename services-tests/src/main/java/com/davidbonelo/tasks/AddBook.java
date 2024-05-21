package com.davidbonelo.tasks;

import com.davidbonelo.interactions.PostAndLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AddBook implements Task {
    private final String isbn;

    public AddBook(String isbn) {
        this.isbn = isbn;
    }

    public static AddBook withIsbn(String isbn) {
        return new AddBook(isbn);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String userId = actor.recall("userID");
        String token = actor.recall("token");
        actor.attemptsTo(
                PostAndLog.to("/BookStore/v1/Books").with(rs -> rs.
                        header("Authorization", "Bearer " + token)
                        .body("{  \"userId\": \"" + userId + "\"," +
                                "  \"collectionOfIsbns\": [" +
                                "    {" +
                                "      \"isbn\": \"" + isbn + "\"" +
                                "    }" +
                                "  ]}")
                )
        );
    }
}
