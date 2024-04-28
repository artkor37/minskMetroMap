package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.serializators.LineSerializator;
import org.example.serializators.StationSerializator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://ru.wikipedia.org/wiki/Список_станций_Минского_метрополитена";
        Document page = Jsoup.connect(url).get();

        JsonMetroStruct jsonMetroStruct = new JsonMetroStruct();
        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table.wikitable > tbody > tr:nth-child(3) > td:nth-child(2) > a
        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table.wikitable > tbody > tr:nth-child(2) > td:nth-child(5) > a
        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table.wikitable > tbody > tr:nth-child(2) > td:nth-child(2) > a

        for (Element elementLine : page.select("div.mw-content-ltr > table:nth-child(6) > tbody " +
                "th:nth-child(7) > table > tbody")) {
            String lineName = elementLine.select(" > tr:nth-child(1)> th > div > div > a > span").text();
            String lineColor = colorColor(elementLine.select("th").attr("style"));
            Line line = new Line();
            line.setName(lineName);
            line.setColor(lineColor);
            line.stationName = new ArrayList<>();
            for (Element elementSt : elementLine.select("tbody td:nth-child(5) > span > a")) {
                String stat = elementSt.select("a").text();
                Station station = new Station();
                station.setLineName(lineName);
                station.setName(stat);
                line.stationName.add(station);
            }
            jsonMetroStruct.lines.add(line);
            jsonMetroStruct.stations.put(line.getName(), line.stationName);
        }
        jsonMetroStruct.addConnection();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Station.class, new StationSerializator())
                .registerTypeAdapter(Line.class, new LineSerializator())
                // .registerTypeAdapter(Line.class,new LineDeserializator())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(jsonMetroStruct);
        System.out.println(json);
        JsonFileWriter.toJson(json);
    }

    public static String colorColor(String color) {
        String lineColor;
        Color colorLine = new Color();
        if (color.contains("#1b59dc")) {
            lineColor = colorLine.color(ColorName.BLUE);
        } else if (color.contains("#d50d00")) {
            lineColor = colorLine.color(ColorName.RED);
        } else if (color.contains("#14ab0f")) {
            lineColor = colorLine.color(ColorName.GREEN);
        } else {
            return null;
        }
        return lineColor;
    }
}
