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

       // UrlParsing.parsing();

        JsonMetroStruct jsonMetroStruct = new JsonMetroStruct();
        jsonMetroStruct.add();
        System.out.println(jsonMetroStruct);


        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(Station.class, new StationSerializator())
               // .registerTypeAdapter(Line.class, new LineSerializator())
                // .registerTypeAdapter(Line.class,new LineDeserializator())
                .setPrettyPrinting()
                .create();
       String json = gson.toJson(jsonMetroStruct);
       System.out.println(json);
       JsonFileWriter.toJson(json);
    }
}
