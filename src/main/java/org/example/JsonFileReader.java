package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import org.example.deserializators.LineDeserializator;
import org.example.deserializators.StationDeserializator;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFileReader {
    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Station.class, new StationDeserializator())
                .registerTypeAdapter(Line.class, new LineDeserializator())
                .setPrettyPrinting()
                .create();

        // FileReader rd = new FileReader("minskMetroMapExample.json");
        FileReader rd = new FileReader("metroTest.json");
        Metro newMetro = gson.fromJson(rd,Metro.class);
        System.out.println(newMetro);


    }
}
