package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {

        //todo парсинг цвета линии
        String url = "https://ru.wikipedia.org/wiki/Список_станций_Минского_метрополитена";
        Document page = Jsoup.connect(url).get();
        Elements elements = page.select("div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody > tr td");
        //System.out.println(elements.attr("colspan > style=background:"));
        elements.forEach(element -> System.out.println(element.getElementsByAttributeValueMatching("style","background:#")));

        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody > tr:nth-child(36) > td
        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody > tr:nth-child(19) > td
        //#mw-content-text > div.mw-content-ltr.mw-parser-output > table:nth-child(6) > tbody > tr:nth-child(1) > td

       /* for (Element element : page.select("tbody > tr:nth-child(1) > td").attr("style")) {
            System.out.println(element);

        }*/
    }
}
