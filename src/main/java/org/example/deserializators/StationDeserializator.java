package org.example.deserializators;

import com.google.gson.*;
import org.example.Line;

import java.lang.reflect.Type;

public class StationDeserializator implements JsonDeserializer<Line> {
    @Override
    public Line deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Line station2 = new Line();
        JsonArray data = jsonElement.getAsJsonArray();


        //station2.setLine1(Collections.singletonList(data));


        return station2;
    }
}
