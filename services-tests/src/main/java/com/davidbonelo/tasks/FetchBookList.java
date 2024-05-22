package com.davidbonelo.tasks;

import com.davidbonelo.interactions.GetAndLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class FetchBookList implements Task {
    public static FetchBookList all() {
        return new FetchBookList();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetAndLog.resource("/BookStore/v1/Books"),
                RememberValue.fromResponse("books", "books")
        );
    }
}
