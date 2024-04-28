package org.example.deserializators;

import com.google.gson.*;
import org.example.Line;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LineDeserializator implements JsonDeserializer<Line> {
    @Override
    public Line deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Line line = new Line();
        JsonObject lineObject = jsonElement.getAsJsonObject();

        line.setName(lineObject.get("name").getAsString());
       // line.setColor(lineObject.get("color").getAsString());

        List<Line> st = new ArrayList<>();
        JsonArray stationArray = lineObject.get("stations").getAsJsonArray();
        for (JsonElement jsonCase : stationArray) {
            st.add(context.deserialize(jsonCase, Line.class));
        }
       // line.setStations(st);
        return line;

    }
}
