package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.serializators.StationSerializator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        String url = "https://ru.wikipedia.org/wiki/Список_станций_Минского_метрополитена";
        Document page = Jsoup.connect(url).get();
        String station = null;
        Line2 station2 = new Line2();

       // #mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody >
        // tr:nth-child(2) > th:nth-child(7)

        for (Element element : page.select("tbody tbody td:nth-child(5) > span > a")) {
            // System.out.println(element);
            String st = (element.text());
            // System.out.println(stat);
            station2.addStation(st);

        }
        System.out.println(station2);
        for (String i : station2.getStations2()) {
            //System.out.println(i);
        }
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Station.class, new StationSerializator())
                .setPrettyPrinting()
                .create();
        //Gson gson = new Gson();
        String json = gson.toJson(station2);
        JsonFileWriter.toJson(json);


    }
}
