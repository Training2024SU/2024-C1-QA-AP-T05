package com.davidbonelo.tasks;

import com.davidbonelo.interactions.PostAndLog;
import com.davidbonelo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class GenerateToken implements Task {

    private final User user;

    public GenerateToken(User user) {
        this.user = user;
    }

    public static GenerateToken forUser(User user) {
        return new GenerateToken(user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostAndLog.to("/Account/v1/GenerateToken").with(
                        rs -> rs.body(
                                "{\"userName\": \"" + user.getFirstName() + "\"," +
                                        "\"password\": \"" + user.getPassword() + "\"}"
                        )),
                RememberValue.fromResponse("token","token")
        );
    }
}
