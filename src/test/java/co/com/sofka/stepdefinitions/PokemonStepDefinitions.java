package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.tasks.DoGet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static co.com.sofka.questions.ResponseJson.responseJson;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PokemonStepDefinitions extends SetupService {

    @Given("que el servicio de consulta de Pokémon está operativo")
    public void que_el_servicio_de_consulta_de_pokémon_está_operativo() {
        super.setupService("https://pokeapi.co/api/v2/");
    }

    @When("el usuario envía una solicitud para obtener información del Pokémon con nombre {string}")
    public void el_usuario_envía_una_solicitud_para_obtener_información_del_pokémon_con_nombre(String pokemonName) {
        actor.attemptsTo(
                DoGet.withTheResource("pokemon/" + pokemonName)
                        .andHeaders(restHeaders())
        );
        System.out.println(SerenityRest.lastResponse().body().prettyPrint());
    }

    @Then("debería obtener el nombre del Pokémon como {string}")
    public void debería_obtener_el_nombre_del_pokémon_como(String expectedName) {
        actor.should(
                seeThat("El código de respuesta es", ResponseCode.was(), equalTo(200))
        );

        String actualName = SerenityRest.lastResponse().jsonPath().getString("name");
        System.out.println("Actual name: " + actualName);  // Imprime el nombre obtenido

        actor.should(
                seeThat("El nombre del Pokémon es correcto",
                        responseJson("name"), equalTo(expectedName.toLowerCase()))
        );
    }
}
