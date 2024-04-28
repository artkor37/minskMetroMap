package org.example.serializators;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Line;

import java.lang.reflect.Type;

public class LineSerializator implements JsonSerializer<Line> {
    @Override
    public JsonElement serialize(Line line, Type type, JsonSerializationContext context) {
        JsonObject lineObject = new JsonObject();
        lineObject.addProperty("lineName", line.getName());
        lineObject.addProperty("color", line.getColor());
        // lineObject.add("stations", context.serialize(line.getStations()));
        return lineObject;
    }
}
