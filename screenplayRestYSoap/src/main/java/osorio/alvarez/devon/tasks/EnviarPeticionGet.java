package osorio.alvarez.devon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import osorio.alvarez.devon.interactions.OurGet;

public class EnviarPeticionGet implements Task {

    private String endpoint;

    public EnviarPeticionGet conRecurso(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurGet.resource(endpoint)
                        .with(request -> request
                                .queryParam("apikey", "b8d13567f4fc00f6eda4b6fab2c18450")
                                .queryParam("hash", "cc8de0d2f3c0890c504495f6a90b8390")
                                .queryParam("ts", "1")
                                .log().all()
                        )
        );
    }

    public static EnviarPeticionGet enviarPeticionGet() {
        return new EnviarPeticionGet();
    }
}
