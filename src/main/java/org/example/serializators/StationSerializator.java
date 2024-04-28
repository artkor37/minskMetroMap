package org.example.serializators;

import com.google.gson.*;
import org.example.Station;

import java.lang.reflect.Type;

public class StationSerializator implements JsonSerializer<Station> {
    @Override
    public JsonElement serialize(Station station, Type type, JsonSerializationContext context) {
        JsonObject stationObject = new JsonObject();
       // stationObject.addProperty("lineName", station.getLineName());
        //stationObject.addProperty("station2", station.getName());
       // return stationObject;
        return new JsonPrimitive(station.getName());
    }
}
