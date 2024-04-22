package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.stream.Collectors;

import java.io.IOException;

public class UrlParsing {
   private static String line1 = null;
    public static Map<String, List<Station>> stat = new HashMap<>();
    public static List<Station> stations1 = new ArrayList<>();
    //public static List<Line> lines = new ArrayList<>();


    public static void parsing() throws IOException {
        String url = "https://ru.wikipedia.org/wiki/Список_станций_Минского_метрополитена";
        Document page = Jsoup.connect(url).get();

        //todo достаем линии
        Elements lineColor = page.getElementsByAttribute("style:background-color:#1b59dc");
        Elements line1 = page.select("tr:nth-child(2) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(1) > th > div > div a");
        Elements line1stations = page.select("tr:nth-child(2) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(3) > td > table > tbody td:nth-child(5) > span > a");
        addLines(line1);
        addStations(line1stations);

        Elements line2 = page.select("tr:nth-child(20) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(1) > th > div > div");
        Elements line2stations = page.select("tr:nth-child(20) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(3) > td > table > tbody td:nth-child(5) > span > a");
        addLines(line2);
        addStations(line2stations);
        Elements line3 = page.select("tr:nth-child(37) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(1) > th > div > div");
        Elements line3stations = page.select("tr:nth-child(37) > th:nth-child(7) > table > tbody > " +
                "tr:nth-child(3) > td > table > tbody td:nth-child(5) span > a");
        addLines(line3);
        addStations(line3stations);


        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody > tr:nth-child(2) > th:nth-child(7)
        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody > tr:nth-child(20) > th:nth-child(7)
        //todo достаем станции


        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6)
        // > tbody > tr:nth-child(2) > th:nth-child(7) > table > tbody > tr:nth-child(1) > th
        //Elements line1stations = page.select("tr:nth-child(2) > th:nth-child(7) > table > tbody > " +
        //                "tr:nth-child(3) > td > table > tbody td:nth-child(5) > span > a");





        // todo вывод в консоль
       /* String col = line1color.text();
        String line1Name = line1.text();
        System.out.println("Line 1 - " + line1Name + " :" + col);
        line1stations.forEach(element -> System.out.println(element.select("a").text()));*/

      /*  String line2Name = line2.text();
        System.out.println("Line 2 - " + line2Name);
        line2stations.forEach(element -> System.out.println(element.select("a").text()));

        String line3Name = line3.text();
        System.out.println("Line 3 - " + line3Name);
        line3stations.forEach(element -> System.out.println(element.select("a").text()));*/

        //todo добавление в List
      /*  line1stations.forEach(element -> {
            Elements elements = element.select("a");
            String stationName = elements.select("a").text();
           // stations1.add(new Station(line1Name, stationName));
           // stat.put(line1Name, stations1);
        });
        line2stations.forEach(element -> {
            Elements elements = element.select("a");
            String stationName = elements.select("a").text();
           // stations2.add(new Station(line2Name, stationName));
        });
        line3stations.forEach(element -> {
            Elements elements = element.select("a");
            String stationName = elements.select("a").text();
           // stations3.add(new Station(line3Name, stationName));
        });*/

        Metro metro = new Metro();

        System.out.println("Kоличество линий: " + metro.getStations());
       /* Metro metro = new Metro();
        for (Line line : metro.getLines()) {
            System.out.println(line.getName());
        }*/
        System.out.println("Kоличество станций: " + stations1.size() + ": " + stations1);
        for (Station station : stations1) {
            System.out.println(station.getName());
        }

      /*  for (Map.Entry<String, List<Station>> entry : stat.entrySet()) {
            System.out.println(entry.getKey() +" " + entry.getValue());
        }*/

    }


    public static void addLines(Elements elements) {

        System.out.println(elements.text());
        new Metro().addLine(new Line(elements.text()));
        //elements.forEach(line -> new Metro().addLine(new Line(line.text())));
        //style:background-color:#1b59dc
        // elements.forEach(line->stat.put(line.text(),stations1));
    }

    public static void addStations(Elements elements) {
       /* Metro metro = new Metro();
        for (Line line : metro.getLines()) {
            line1 = line.getName();
        }
        elements.forEach(st -> stations1.add(new Station(line1, st.text())));*/
    }

}

