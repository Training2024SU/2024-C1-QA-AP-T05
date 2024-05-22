package com.davidbonelo.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class RememberValue implements Task {
    private final String jsonPath;
    private final String key;

    public RememberValue(String jsonPath, String key) {
        this.jsonPath = jsonPath;
        this.key = key;
    }

    public static RememberValue fromResponse(String jsonPath, String key) {
        return new RememberValue(jsonPath, key);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String value = SerenityRest.lastResponse().jsonPath().getString(jsonPath);
        System.err.println("Remembered " + key + ": " + value);
        actor.remember(key, value);
    }
}
