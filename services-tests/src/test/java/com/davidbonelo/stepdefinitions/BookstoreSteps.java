package com.davidbonelo.stepdefinitions;

import com.davidbonelo.interactions.GetAndLog;
import com.davidbonelo.models.Book;
import com.davidbonelo.models.User;
import com.davidbonelo.models.factories.UserFactory;
import com.davidbonelo.questions.BookResponse;
import com.davidbonelo.tasks.*;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.davidbonelo.Constants.BOOKSTORE_BASE;
import static com.davidbonelo.Constants.BOOK_ENDPOINT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class BookstoreSteps {

    @Given("the user can access the bookstore service")
    public void theUserCanAccessTheBookstoreService() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BOOKSTORE_BASE)));
    }

    @Given("{actor} has his token access")
    public void davidHasHisTokenAccess(Actor actor) {
        User user = UserFactory.createFakeUser(null);
        actor.wasAbleTo(
                CreateUser.as(user),
                GenerateToken.forUser(user)
        );
    }

    @When("{actor} adds the book with ISBN {string} to my collection")
    public void heAddsTheBookWithISBNToMyCollection(Actor actor, String isbn) {
        actor.attemptsTo(
                AddBook.withIsbn(isbn)
        );
        actor.remember("isbn", isbn);
    }

    @Then("{actor} should receive a response with status {int}")
    public void heShouldReceiveAResponseWithStatus(Actor actor, int statusCode) {
        actor.should(
                seeThatResponse("received a " + statusCode + " response",
                        response -> response.statusCode(statusCode))
        );
    }

    @And("{actor} should be able to see the book in his collection")
    public void heShouldBeAbleToSeeTheBookInHisCollection(Actor actor) {
        String isbn = actor.recall("isbn");
        actor.should(
                seeThatResponse("The book was added successfully",
                        response -> response.body("books[0].isbn", equalTo(isbn)))
        );
    }

    @When("{actor} requests the list of available books")
    public void mariaRequestsTheListOfAvailableBooks(Actor actor) {
        actor.attemptsTo(
                FetchBookList.all()
        );
    }

    @And("{actor} should get a list with all the books")
    public void sheShouldGetAListWithAllTheBooks(Actor actor) {
        actor.should(
                seeThatResponse(
                        response -> response
                                .body("books", is(not(empty())))
                )
        );
    }

    @When("{actor} requests the details for the book with isbn {string}")
    public void juanRequestsTheDetailsForTheBookWithIsbn(Actor actor, String isbn) {
        actor.attemptsTo(
                GetAndLog.resource(BOOK_ENDPOINT + "?ISBN=" + isbn)
        );
    }

    @And("{actor} should be able to see the book details")
    public void heShouldBeAbleToSeeTheBookDetails(Actor actor) {
        actor.should(
                seeThat(
                        BookResponse.was(), notNullValue(Book.class)
                )
        );

    }
}
