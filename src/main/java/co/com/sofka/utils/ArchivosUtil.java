package co.com.sofka.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArchivosUtil {

    public static boolean verifyIfFileExist(String filePath){
        File file = new File(filePath);
        return file.isFile();
    }

    public static boolean deleteFileOrDirectory(String filePath) {
        File object = new File(filePath);
        boolean deleted = false;

        if(object.exists()) {
            deleted = object.delete();
        }

        return deleted;
    }

    public static String readFile(String filePath) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            while ((line = br.readLine()) != null)
                stringBuilder.append(line + "\n");
        } catch (IOException ioException) {
        }
        return stringBuilder.toString();
    }

}