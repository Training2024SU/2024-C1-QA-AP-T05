package co.com.sofkau.utils;

import co.com.sofkau.models.ModeloPost;
import net.datafaker.Faker;

public class Util {

    public static ModeloPost crearModeloPostConUsuarioYContrasena(){
        Faker faker = new Faker();

        return new ModeloPost(
                faker.name().firstName() + faker.numerify("########"),
                "testPassword#1" + faker.numerify("########"));
    }
}
