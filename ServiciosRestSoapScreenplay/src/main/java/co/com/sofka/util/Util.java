package co.com.sofka.util;

import org.jetbrains.annotations.NotNull;
import org.json.JSONMLParserConfiguration;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import static co.com.sofka.constants.ConstantsOperations.RESOURCE_POSTS_BY_ID;
import static co.com.sofka.constants.ConstantsOperations.RESOURCE_TODOS_BY_ID;

public class Util {
    public static @NotNull String getBodyCountryCurrency(String value) {
        String cuerpo = String.format(readFile("src/test/resources/xmlfiles/countrycurrency.xml"), value);
        return cuerpo;
    }

    public static @NotNull String getBodyCapitalCity(String value) {
        String cuerpo = String.format(readFile("src/test/resources/xmlfiles/capitalcity.xml"), value);
        return cuerpo;
    }

    public static @NotNull String getAllCountries() {
        String cuerpo = readFile("src/test/resources/xmlfiles/allcountries.xml");
        return cuerpo;
    }

    public static String requestBodyUser(String name, String username, String email) {
        String requestBodyBase = "{\"name\": \"%s\", \"username\": \"%s\", \"email\": \"%s\"}";
        String requestBody = String.format(requestBodyBase, name, username, email);
        return requestBody;
    }

    public static String requestBodyPosts(int id, String postTitle, String postBody) {
        String requestBodyBase = "{\"id\": \"%s\", \"title\": \"%s\", \"body\": \"%s\", \"userId\": 1}";
        String requestBody = String.format(requestBodyBase, id, postTitle, postBody);
        return requestBody;
    }

    public static String requestBodyDelete(int id) {
        String requestBodyBase = "{\"id\": \"%s\"}";
        String requestBody = String.format(requestBodyBase, id);
        return requestBody;
    }

    public static String getPostById(int id) {
        return String.format(RESOURCE_POSTS_BY_ID, id);
    }

    public static String getTodosById(int id) {
        return String.format(RESOURCE_TODOS_BY_ID, id);
    }




    public static boolean verifyIfFileExist(String filePath) {
        File file = new File(filePath);
        /*LOGGER.info("\n\r****Verificación de archivo:****\r");
        LOGGER.info("Ruta suministrada: " + filePath + "\r");
        LOGGER.info("¿Es un archivo o directorio existente?:" + file.exists() + "\n");
        LOGGER.info("¿Es un archivo?:" + file.isFile() + "\n\r");*/
        return file.isFile();
    }

    public static boolean deleteFileOrDirectory(String filePath) {
        File object = new File(filePath);
/*
        LOGGER.info("\n\r****Verificación de eliminación de archivo o directorio:****\r");
        LOGGER.info("Ruta suministrada: " + filePath + "\r");
        LOGGER.info("¿Es un archivo o directorio existente?:" + object.exists() + "\n\r");*/

        boolean deleted = false;

        if (object.exists()) {
            deleted = object.delete();
        }
/*
        LOGGER.info("¿Fue eliminado?:" + deleted + "\n\r");*/

        return deleted;
    }

    public static String readFile(String filePath) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            while ((line = br.readLine()) != null)
                stringBuilder.append(line + "\n");
        } catch (IOException ioException) {
       /*     LOGGER.info("\n\n****Hay problemas con la ruta especificada para la lectura de archivos****");
            LOGGER.info(ioException.getMessage() + "\r\n");
            LOGGER.info(ioException);*/
        }
        return stringBuilder.toString();
    }
}
