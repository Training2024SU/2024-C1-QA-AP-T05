package co.com.sofka.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArchivosUtil {

    public static boolean verifyIfFileExist(String filePath){
        File file = new File(filePath);
        /*LOGGER.info("\n\r****Verificación de archivo:****\r");
        LOGGER.info("Ruta suministrada: " + filePath + "\r");
        LOGGER.info("¿Es un archivo o directorio existente?:" + file.exists() + "\n");
        LOGGER.info("¿Es un archivo?:" + file.isFile() + "\n\r");*/
        return file.isFile();
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
        return String.format("posts/%s", id);
    }

    public static String getTodosById(int id) {
        return String.format("todos/%s", id);
    }




    public static boolean deleteFileOrDirectory(String filePath) {
        File object = new File(filePath);
/*
        LOGGER.info("\n\r****Verificación de eliminación de archivo o directorio:****\r");
        LOGGER.info("Ruta suministrada: " + filePath + "\r");
        LOGGER.info("¿Es un archivo o directorio existente?:" + object.exists() + "\n\r");*/

        boolean deleted = false;

        if(object.exists()) {
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
