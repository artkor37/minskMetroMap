package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class JsonMetroStruct {
    //todo connections пары переходов
    public List<List<Connection>> connections = new ArrayList<>();

    //todo список линий
    public List<Line> lines = new ArrayList<>();

    //todo Map линии, станции на линии
    private Map<Line, List<Station>> stations;

    public void add() {
        addLines("Московская линия", "Синий");
        addLines("Автозаводская линия", "Красный");
        addLines("Зеленолужская линия", "Зеленый");
        //System.out.println("Количество линий: " + lines.size() + " " + lines);
        for (Line s : lines) {
            // System.out.println(s);
        }

        connections.add(new ArrayList<Connection>());
        connections.get(0).add(new Connection("Автозаводская линия", "Купаловская"));
        connections.get(0).add(new Connection("Московская линия", "Октябрьская"));
       // System.out.println(connections);
        addConnection("Автозаводская линия", "Купаловская");

        connections.add(new ArrayList<Connection>());
        connections.get(1).add(new Connection("Автозаводская линия", "Фрунзенская"));
        connections.get(1).add(new Connection("Зеленолужская линия", "Юбилейная площадь"));
       // System.out.println(connections);

        connections.add(new ArrayList<Connection>());
        connections.get(2).add(new Connection("Зеленолужская линия", "Вокзальная"));
        connections.get(2).add(new Connection("Московская линия", "Площадь Ленина"));
       // System.out.println(connections);
        for(List<Connection> c : connections){
           // System.out.println(c);
        }
    }

    public void addLines(String line, String color) {
        lines.add(new Line(line, color));
    }

    public static void addConnection(String line, String name) {


    }
}
