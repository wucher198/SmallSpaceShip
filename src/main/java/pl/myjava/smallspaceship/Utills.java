package pl.myjava.smallspaceship;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Utills {
    public static final String CURRNET_DIR = ".";

    public static String getDirectory(String path) {
        return path.substring(0, path.lastIndexOf("/"));
    }

    public static String getFileName(String path) {
        return path.substring(path.lastIndexOf("/"));
    }

    public static boolean checkIfPath(String parameter) {
        File file = new File(parameter);

        return file.canRead();
    }

    public static Map<String, String> loadProperties(String fileName, String resourceDir) {
        final Map<String, String> result = new HashMap<>();

//        if (resourceDir == null || resourceDir.equals("")) {
//            resourceDir = CURRNET_DIR;
//        }
//
//        if (!resourceDir.startsWith("/") && !resourceDir.startsWith("\\")) {
//            resourceDir = "/" + resourceDir;
//        }
//
        Path current = Paths.get(resourceDir + "/" + fileName);
        
        System.out.println("Path to settings: " + current.toString());

        if (Files.exists(current)) {
            try {
                Files.readAllLines(current).stream().forEach(line -> {
                    String[] splitLine = line.split("=");
                    result.put(splitLine[0], splitLine[1]);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
