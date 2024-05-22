package co.com.sofka.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

import static co.com.sofka.questions.ObtenerRespuesta.obtenerRespuesta;

public class util {

    public static void bodyOfTheResponse(Actor actor) {
        System.out.println("cuerpo de la respuesta");
        String nuevo = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        System.out.println(nuevo);
    }
    public static void printJoke(Actor actor) {
        try {
            String joke = obtenerRespuesta().delCampo("joke").answeredBy(actor);
            System.out.println(joke);
        }catch (Exception e){}
        try {
            String setUp = obtenerRespuesta().delCampo("setup").answeredBy(actor);
            String delivery = obtenerRespuesta().delCampo("delivery").answeredBy(actor);
            System.out.println(setUp);
            System.out.println(delivery);
        }catch (Exception e){}
    }
}
