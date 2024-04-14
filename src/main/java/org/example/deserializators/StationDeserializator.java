package org.example.deserializators;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.Line;
import org.example.Station;

import java.lang.reflect.Type;

public class StationDeserializator implements JsonDeserializer<Station> {
    @Override
    public Station deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Line line = new Line();
        String data2 = jsonElement.getAsString();

        Station station = new Station();
        String data = jsonElement.getAsString();
        line.setColor("color");
        //station.setLine(line.getColor("color"));
        station.setName(data);


        return station;
    }
}
