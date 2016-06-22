package pl.myjava.smallspaceship;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Utills {
    public static final String RESOURCES_DIR = "/resources";

    public static Map<String, String> loadProperties(String fileName, String resourceDir) {
        final Map<String, String> result = new HashMap<>();

        if (resourceDir == null || resourceDir.equals("")) {
            resourceDir = RESOURCES_DIR;
        }

        if (!resourceDir.startsWith("/") && !resourceDir.startsWith("\\")) {
            resourceDir = "/" + resourceDir;
        }

        Path current = Paths.get("." + resourceDir + "/" + fileName);

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
