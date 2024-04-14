package org.example.serializators;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Station;

import java.lang.reflect.Type;

public class StationSerializator implements JsonSerializer<Station> {
    @Override
    public JsonElement serialize(Station station, Type type, JsonSerializationContext context) {
        JsonObject stationObject = new JsonObject();
        stationObject.addProperty("lineName",station.getLine());
        stationObject.addProperty("name",station.getName());
        return stationObject;
    }
}
