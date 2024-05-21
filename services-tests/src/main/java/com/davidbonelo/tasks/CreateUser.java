package com.davidbonelo.tasks;

import com.davidbonelo.interactions.PostAndLog;
import com.davidbonelo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CreateUser implements Task {
    private final User user;

    public CreateUser(User user) {
        this.user = user;
    }

    public static CreateUser as(User user) {
        return new CreateUser(user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostAndLog.to("/Account/v1/User")
                        .with(rS -> rS.body(
                                "{\"userName\": \"" + user.getFirstName() + "\"," +
                                        "\"password\": \"" + user.getPassword() + "\"}")
                        ),
                RememberValue.fromResponse("userID", "userID")
        );
    }
}
