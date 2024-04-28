package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import org.example.deserializators.LineDeserializator;
import org.example.deserializators.StationDeserializator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {
    public static final List<String> line1stations = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {

       // Gson gson = new Gson();
       Gson gson = new GsonBuilder()
                //.registerTypeAdapter(Station.class, new StationDeserializator())
               // .registerTypeAdapter(Line.class, new LineDeserializator())
                .setPrettyPrinting()
                .create();

        FileReader reader = new FileReader("minskMetroMapExample.json");
       // FileReader rd = new FileReader("metroTest.json");
        //Metro newMetro = gson.fromJson(reader,Metro.class);
        //System.out.println(newMetro);

        Line line = new Line();
        System.out.println(line.getName());

    }
}
