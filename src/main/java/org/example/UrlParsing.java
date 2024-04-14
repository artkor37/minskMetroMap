package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.stream.Collectors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UrlParsing {
    public static List<Station> stations4 = new ArrayList<>();

    public static void parsing() throws IOException {
        String url = "https://ru.wikipedia.org/wiki/Список_станций_Минского_метрополитена";
        Document page = Jsoup.connect(url).get();

        Elements table = page.select("div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody");

        Elements line1 = page.select("tr:nth-child(2) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(1) > th > div > div");
        Elements line1stations = table.select("tr:nth-child(2) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(3) > td > table > tbody td:nth-child(5) span > a");

        Elements line2 = page.select("tr:nth-child(20) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(1) > th > div > div");
        Elements line2stations = table.select("tr:nth-child(20) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(3) > td > table > tbody td:nth-child(5) span > a");

        Elements line3 = page.select("tr:nth-child(37) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(1) > th > div > div");
        Elements line3stations = table.select("tr:nth-child(37) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(3) > td > table > tbody td:nth-child(5) span > a");

        // todo вывод в консоль
        String line1Name = line1.text();
        System.out.println(line1Name);
        line1stations.forEach(element -> System.out.println(element.select("a").text()));

        String line2Name = line2.text();
        System.out.println(line2Name);
        line2stations.forEach(element -> System.out.println(element.select("a").text()));

        String line3Name = line3.text();
        System.out.println(line3Name);
        line3stations.forEach(element -> System.out.println(element.select("a").text()));

        //todo добавление в List
        line1stations.forEach(element -> {
            Elements elements = element.select("a");
            String stationName = elements.select("a").text();
            stations4.add(new Station(line1Name,stationName));
        });
        line2stations.forEach(element -> {
            Elements elements = element.select("a");
            String stationName = elements.select("a").text();
            stations4.add(new Station(line2Name,stationName));
        });
        line3stations.forEach(element -> {
            Elements elements = element.select("a");
            String stationName = elements.select("a").text();
            stations4.add(new Station(line3Name,stationName));
        });

        System.out.println("Kоличество станций: " + stations4.size() + ": " + stations4);
    }
}
