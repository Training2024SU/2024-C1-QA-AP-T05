package com.davidbonelo.stepdefinitions;

import com.davidbonelo.models.User;
import com.davidbonelo.models.factories.UserFactory;
import com.davidbonelo.tasks.AddBook;
import com.davidbonelo.tasks.CreateUser;
import com.davidbonelo.tasks.GenerateToken;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.davidbonelo.Constants.BOOKSTORE_BASE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class BookstoreSteps {

    @Given("the user can access the bookstore service")
    public void theUserCanAccessTheBookstoreService() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BOOKSTORE_BASE)));
    }

    @Given("{actor} can access the Bookstore")
    public void actorCanAccessTheBookstore(Actor actor) {
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
}
