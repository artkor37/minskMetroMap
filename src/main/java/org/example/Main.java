package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.deserializators.LineDeserializator;
import org.example.serializators.LineSerializator;
import org.example.serializators.StationSerializator;

import java.io.IOException;
import java.util.List;


import static org.example.UrlParsing.stations1;

public class Main {
    public static void main(String[] args) throws IOException {

        UrlParsing.parsing();

        // Connections connections = new Connections();
        Station station = new Station();
        Line line = new Line();
        Metro metro = new Metro();
        System.out.println(metro);


        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Station.class, new StationSerializator())
                .registerTypeAdapter(Line.class, new LineSerializator())
                // .registerTypeAdapter(Line.class,new LineDeserializator())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(metro);
        System.out.println(json);
        //  Metro newMetro = gson.fromJson(json,Metro.class);
        //System.out.println(newMetro);
        //JsonFileWriter.toJson(json);
    }
}
