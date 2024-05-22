package com.davidbonelo.questions;

import com.davidbonelo.models.Book;
import com.google.gson.Gson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BookResponse implements Question<Book> {
    public static BookResponse was() {
        return new BookResponse();
    }

    @Override
    public Book answeredBy(Actor actor) {
        Gson gson = new Gson();
        String bookJson = SerenityRest.lastResponse().asString();
        return gson.fromJson(bookJson, Book.class);
    }
}
