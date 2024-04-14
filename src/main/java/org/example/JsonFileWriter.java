package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {

    public static void toJson(String json) {
        try (FileWriter writer = new FileWriter("metroTest.json")) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
