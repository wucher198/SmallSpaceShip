/*
 * Utills
 * Date of creation: 2016-06-03
 * 
 * Copyright (c) CompuGROUP Software GmbH,
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

/** @author Maciej Smolka on 03.06.2016, PL */
public class Utills {
    public static Map<String, String> loadProperties(String fileName) {
        Map<String, String> result = null;
        Path current = FileSystems.getDefault().getPath(".");
        System.out.println(current.getParent().toString());

        Path path = FileSystems.getDefault().getPath(fileName);

        try {
            result = Files.readAllLines(path).stream().collect(Collectors.toMap((String line) -> line.split("=")[0], (String line) -> line.split("0")[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
