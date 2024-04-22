package org.example.deserializators;

import com.google.gson.*;
import org.example.Line2;

import java.lang.reflect.Type;

public class StationDeserializator implements JsonDeserializer<Line2> {
    @Override
    public Line2 deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Line2 station2 = new Line2();
        JsonArray data = jsonElement.getAsJsonArray();


        //station2.setLine1(Collections.singletonList(data));


        return station2;
    }
}
